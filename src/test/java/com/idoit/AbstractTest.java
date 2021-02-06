package com.idoit;

import com.idoit.meta.Meta;
import com.idoit.meta.MetaContext;
import com.idoit.safe.Safer;
import org.reflections8.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.StringJoiner;
import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public abstract class AbstractTest {

    private Meta meta;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Class<? extends Meta> clazz) {
        this.meta = MetaContext.getMeta(clazz);
    }

    protected void testClassIsInPackage() {
        Reflections reflections = TestUtil.getBaseReflections(meta.getPackageName());
        boolean classExists = checkIfClassExistsInPackage(reflections);
        assertTrue(classExists, getMessageForClassExistence(classExists));
    }

    protected void testClassHasFields() {
        getClassOrFail().ifPresent(this::testClassHasFields);
    }

    protected void testClassHasConstructors() {
        getClassOrFail().ifPresent(this::testClassHasConstructors);
    }

    protected void testConstructorSetsValueToFields(Object... constructorParams) {
        try {
            Class<?>[] paramTypes = TestUtil.getTypesForParams(constructorParams);
            Object object = meta.instantiateObjectWithConstructor(constructorParams);
            List<String> fieldNames = meta.getFieldsByConstructorParamTypes(Arrays.asList(paramTypes));
            String expectedMessageFormat = "В классе %s полю %s в конструкторе должно выставляться значение параметра";
            String actualMessageFormat = "В классе %s полю %s в конструкторе не выставляется значение параметра";
            String message;
            for (int i = 0; i < fieldNames.size(); i++) {
                Field field = object.getClass().getField(fieldNames.get(i));
                Object actualValue = field.get(object);
                message = MessageUtil.formatAssertMessage(
                        String.format(expectedMessageFormat, meta.getClassName(), fieldNames.get(i)),
                        String.format(actualMessageFormat, meta.getClassName(), fieldNames.get(i))
                );
                assertEquals(constructorParams[i], actualValue, message);
            }
        } catch (Exception e) {
            fail(String.format("Ошибка при создании объекта класса %s c помощью конструктора и обращении к его полям",
                    meta.getClassName()), e);
        }
    }

    protected void testClassHasAllMethods() {
        meta.getMethods().forEach(this::testClassHasMethod);
    }

    protected void testClassMethod(BiConsumer<Object, Object[]> whatShouldHappen, Object caller, String methodName, Object... params) {
        Safer.runSafe(() -> {
            Class<?>[] paramTypes = TestUtil.getTypesForParams(params);
            Method method = meta.getMethodFromMeta(methodName, paramTypes);
            method.setAccessible(true);
            method.invoke(caller, params);
            whatShouldHappen.accept(caller, params);
        });
    }

    protected Object callClassMethodAndReturnResult(Object caller, String methodName, Object... params) {
        return Safer.runSafe(() -> {
            Class<?>[] paramTypes = TestUtil.getTypesForParams(params);
            Method method = meta.getMethodFromMeta(methodName, paramTypes);
            method.setAccessible(true);
            return method.invoke(caller, params);
        });
    }

    protected Object getFieldValue(Object instance, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Field targetHpField = instance.getClass().getField(fieldName);
        return targetHpField.get(instance);
    }

    protected void testSetterWithMetaParam(Class<? extends Meta> paramMetaClass, Object[] paramConstructorArgs,
                                           String methodName, String fieldName, Object... constructorParams) {
        Safer.runSafe(() -> {
            Meta meta = MetaContext.getMeta(paramMetaClass);
            Object param = meta.instantiateObjectWithConstructor(paramConstructorArgs);
            String message = getSetterAssertMessage(methodName, paramMetaClass.getName(), getMeta().getClassName());
            testSetter(param, methodName, fieldName, message, constructorParams);
        });
    }

    protected void testSetter(Object value, String methodName, String fieldName, String assertMessage, Object... constructorParams) {
        Safer.runSafe(() -> {
            Object obj = getMeta().instantiateObjectWithConstructor(constructorParams);
            BiConsumer<Object, Object[]> setterAssert = getSetterAssert(fieldName, assertMessage);
            testClassMethod(setterAssert, obj, methodName, value);
        });
    }

    protected void testSetter(Object value, String methodName, String fieldName, Object... constructorParams) {
        Safer.runSafe(() -> {
            Object obj = getMeta().instantiateObjectWithConstructor(constructorParams);
            String assertMessage = getSetterAssertMessage(methodName, value.getClass().getName(), getMeta().getClassName());
            BiConsumer<Object, Object[]> setterAssert = getSetterAssert(fieldName, assertMessage);
            testClassMethod(setterAssert, obj, methodName, value);
        });
    }

    protected String getSetterAssertMessage(String methodName, String valueType, String callerType) {
        return MessageUtil.formatAssertMessage(
                String.format(
                        "После вызова метода %s, переданный %s должен записаться в поле %s, у которого вызывается метод",
                        methodName, valueType, callerType
                ),
                String.format("После вызова метода %s, переданный %s не записался в поле %s, у которого вызывается метод",
                        methodName, valueType, callerType)
        );
    }

    protected Object setFieldForObjectAndGet(Object obj, String setterName, Class<? extends Meta> paramMeta,
                                             Object... paramConstructorArgs) throws Exception {
        Meta meta = MetaContext.getMeta(paramMeta);
        Object param = meta.instantiateObjectWithConstructor(paramConstructorArgs);
        setValue(obj, setterName, param);
        return param;
    }

    protected void testGetter(String getterName, String setterName, Object expectedValue, Object... constructorParams) {
        Safer.runSafe(() -> {
            Object obj = meta.instantiateObjectWithConstructor(constructorParams);
            setValue(obj, setterName, expectedValue);
            Method getter = obj.getClass().getDeclaredMethod(getterName);
            Object actualValue = getter.invoke(obj);
            String message = getGetterAssertMessage(obj.getClass(), getterName, expectedValue, actualValue);
            assertEquals(expectedValue, actualValue, message);
        });
    }

    protected String getMethodReturnResultAssertMessage(String methodName, Object expectedResult, Object actualResult) {
        return MessageUtil.formatAssertMessage(
                String.format("Метод %s в классе %s должен возвращать %s", methodName, getMeta().getClassName(), expectedResult),
                String.format("Метод %s в классе %s возвращает %s", methodName, getMeta().getClassName(), actualResult)
        );
    }

    protected String getFieldValueAssert(String className, String methodName, String fieldName, Object expectedValue, Object actualValue) {
        return MessageUtil.formatAssertMessage(
                String.format("После вызова метода %s в классе %s поле %s должно иметь значение %s", methodName, className, fieldName, expectedValue),
                String.format("После вызова метода %s в классе %s поле %s имеет значение %s", methodName, className, fieldName, actualValue)
        );
    }

    protected void setValue(Object obj, String setterName, Object value) throws Exception {
        try {
            Method setter = obj.getClass().getDeclaredMethod(setterName, value.getClass());
            setter.invoke(obj, value);
        } catch (NoSuchMethodException | SecurityException e) {
            String fieldName = getFieldNameFromSetter(setterName);
            Field field = obj.getClass().getField(fieldName);
            field.set(obj, value);
        }
    }

    private String getFieldNameFromSetter(String setterName) {
        String fieldName = setterName.replaceFirst("set", "");
        return fieldName.substring(0, 1).toLowerCase() + fieldName.substring(1);
    }

    private String getGetterAssertMessage(Class<?> clazz, String getterName, Object expectedValue, Object actualValue) {
        return MessageUtil.formatAssertMessage(
                String.format("Метод %s в классе %s должен возвращать %s", getterName, clazz.getName(), expectedValue),
                String.format("Метод %s в классе %s возвращает %s", getterName, clazz.getName(), actualValue)
        );
    }

    private BiConsumer<Object, Object[]> getSetterAssert(String fieldName, String assertMessage) {
        return (obj, params) -> {
            Object param = params[0];
            Safer.runSafe(() -> {
                Object fieldValue = getFieldValue(obj, fieldName);
                assertEquals(param, fieldValue, assertMessage);
            });
        };
    }

    private void testClassHasMethod(Meta.Method method) {
        StringJoiner paramsJoiner = new StringJoiner(", ");
        method.getParamTypes().forEach(param -> paramsJoiner.add(param.getName()));
        try {
            Method actualMethod = meta.getClassFromMeta()
                    .getDeclaredMethod(method.getName(), method.getParamTypes().toArray(new Class<?>[0]));
            String message = getMethodReturnTypeMessage(method, actualMethod, paramsJoiner.toString());
            assertEquals(method.getReturnType(), actualMethod.getReturnType(), message);
        } catch (ClassNotFoundException e) {
            fail(String.format("Класс %s не найден в пакете %s", meta.getClassName(), meta.getPackageName()));
        } catch (NoSuchMethodException e) {
            fail(String.format("Метод %s(%s) не найден в классе %s", method.getName(), paramsJoiner.toString(),
                    meta.getClassName()));
        }
    }

    private String getMethodReturnTypeMessage(Meta.Method method, Method actualMethod, String methodParams) {
        return MessageUtil.formatAssertMessage(
                String.format("Метод %s(%s) в классе %s должен возвращать %s", method.getName(),
                        methodParams, meta.getClassName(), method.getReturnType().getName()),
                String.format("Метод %s(%s) в классе %s возвращает %s", method.getName(),
                        methodParams, meta.getClassName(), actualMethod.getReturnType().getName())
        );
    }

    private Optional<Class<?>> getClassOrFail() {
        Class<?> clazz = null;
        try {
            clazz = meta.getClassFromMeta();
        } catch (ClassNotFoundException e) {
            fail(String.format("Класс %s не найден в пакете %s", meta.getClassName(), meta.getPackageName()));
        }
        return Optional.ofNullable(clazz);
    }

    private void testClassHasConstructors(Class<?> clazz) {
        List<Constructor<?>> actualConstructors = checkActualConstructorsSizeAndGet(clazz);
        Set<List<Map.Entry<String, Class<?>>>> expectedConstructors = meta.getConstructors();
        expectedConstructors.forEach(constructor -> checkConstructorExistsInClass(constructor, actualConstructors));
    }

    private List<Constructor<?>> checkActualConstructorsSizeAndGet(Class<?> clazz) {
        Set<List<Map.Entry<String, Class<?>>>> expectedConstructors = meta.getConstructors();
        List<Constructor<?>> actualConstructors = Arrays.asList(clazz.getConstructors());
        String sizeMessage = MessageUtil.formatAssertMessage(
                String.format("Число конструкторов в классе %s: %d", clazz.getName(), expectedConstructors.size()),
                String.format("Число конструкторов в классе %s: %d", clazz.getName(), actualConstructors.size())
        );
        assertEquals(expectedConstructors.size(), actualConstructors.size(), sizeMessage);
        return actualConstructors;
    }

    private void checkConstructorExistsInClass(List<Map.Entry<String, Class<?>>> constructor, List<Constructor<?>> actualConstructors) {
        StringJoiner paramTypeJoiner = new StringJoiner(",");
        constructor.forEach(param -> paramTypeJoiner.add(param.getValue().getName()));
        String message = MessageUtil.formatAssertMessage(
                String.format("В классе %s есть конструктор с параметрами: %s", meta.getClassName(), paramTypeJoiner.toString()),
                String.format("В классе %s нет конструктора с параметрами: %s", meta.getClassName(), paramTypeJoiner.toString())
        );
        boolean exists = actualConstructors.stream()
                .anyMatch(actualConstructor -> isTheSameConstructor(constructor, actualConstructor));
        assertTrue(exists, message);
    }

    private boolean isTheSameConstructor(List<Map.Entry<String, Class<?>>> constructor, Constructor<?> actualConstructor) {
        return actualConstructor.getParameterCount() == constructor.size() &&
                Arrays.stream(actualConstructor.getParameterTypes())
                        .allMatch(paramType -> constructor.stream()
                                .anyMatch(expectedParam -> expectedParam.getValue().equals(paramType)));
    }

    private void testClassHasFields(Class<?> clazz) {
        Map<String, Class<?>> expectedFields = meta.getFields();
        List<Field> actualFields = checkActualFieldsSizeAndGet(clazz);
        String className = clazz.getName();
        expectedFields.forEach((name, type) -> checkFieldExistsInClass(className, name, type, actualFields));
    }

    private List<Field> checkActualFieldsSizeAndGet(Class<?> clazz) {
        Map<String, Class<?>> expectedFields = meta.getFields();
        String className = clazz.getName();
        List<Field> actualFields = Arrays.asList(clazz.getFields());
        String sizeMessage = MessageUtil.formatAssertMessage(
                String.format("Число полей в классе %s: %d", className, expectedFields.size()),
                String.format("Число полей в классе %s: %d", className, actualFields.size())
        );
        assertEquals(expectedFields.size(), actualFields.size(), sizeMessage);
        return actualFields;
    }

    private void checkFieldExistsInClass(String className, String fieldName, Class<?> fieldType, List<Field> actualFields) {
        String fieldExistsMessage = MessageUtil.formatAssertMessage(
                String.format("Класс %s содержит поле %s типа %s", className, fieldName, fieldType.getName()),
                String.format("Класс %s не содержит поле %s типа %s", className, fieldName, fieldType.getName())
        );
        boolean exists = actualFields.stream()
                .anyMatch(actualField -> isTheSameField(fieldName, fieldType, actualField));

        assertTrue(exists, fieldExistsMessage);
    }

    private boolean isTheSameField(String name, Class<?> type, Field actual) {
        return name.equals(actual.getName()) && type.equals(actual.getType());
    }

    private boolean checkIfClassExistsInPackage(Reflections reflections) {
        return reflections.getSubTypesOf(Object.class).stream()
                .map(Class::getName)
                .anyMatch(meta.getFullClassName()::equals);
    }

    private String getMessageForClassExistence(boolean classExists) {
        String defaultMessage = String.format("Нет класса с именем %s", meta.getClassName());
        String actualMessage = defaultMessage;
        if (!classExists) {
            actualMessage = getMessageForAnotherPackage(defaultMessage);
        }

        String expected = String.format("Класс %s в пакете %s", meta.getClassName(), meta.getPackageName());
        return MessageUtil.formatAssertMessage(expected, actualMessage);
    }

    private String getMessageForAnotherPackage(String defaultMessage) {
        Reflections reflections = TestUtil.getBaseReflections(Meta.BASE_PACKAGE);
        return reflections.getSubTypesOf(Object.class).stream()
                .filter(clazz -> clazz.getName().contains(meta.getClassName()))
                .findFirst()
                .map(clazz -> String.format("Класс %s в пакете %s", meta.getClassName(), clazz.getPackage().getName()))
                .orElse(defaultMessage);
    }
}
