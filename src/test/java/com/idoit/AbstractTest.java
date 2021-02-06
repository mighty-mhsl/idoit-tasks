package com.idoit;

import com.idoit.meta.Meta;
import org.reflections8.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public abstract class AbstractTest {
    private static final Map<Class<?>, Class<?>> BOXED_UNBOXED_CLASSES = new HashMap<>();

    static {
        BOXED_UNBOXED_CLASSES.put(Integer.class, int.class);
        BOXED_UNBOXED_CLASSES.put(Short.class, short.class);
        BOXED_UNBOXED_CLASSES.put(Byte.class, byte.class);
        BOXED_UNBOXED_CLASSES.put(Long.class, long.class);
        BOXED_UNBOXED_CLASSES.put(Character.class, char.class);
        BOXED_UNBOXED_CLASSES.put(Boolean.class, boolean.class);
        BOXED_UNBOXED_CLASSES.put(Double.class, double.class);
        BOXED_UNBOXED_CLASSES.put(Float.class, float.class);
    }

    private Meta meta;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    protected void setMetaSafe(SafeSupplier<Meta> supplier) {
        try {
            setMeta(supplier.supply());
        } catch (ClassNotFoundException e) {
            fail("Не найдены все требуемые классы для данного теста.", e);
        }
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

    protected void testConstructorSetsValueToFields(Object[] constructorParams) {
        try {
            Class<?>[] paramTypes = getTypesForConstructorParams(constructorParams);
            List<String> fieldNames = meta.getFieldsByConstructorParamTypes(Arrays.asList(paramTypes));
            Object object = meta.getClassFromMeta().getConstructor(paramTypes).newInstance(constructorParams);
            String expectedMessageFormat = "В классе %s полю %s в конструкторе должно выставляться значение параметра";
            String actualMessageFormat = "В классе %s полю %s в конструкторе не выставляется значение параметра";
            String message;
            for (int i = 0; i < fieldNames.size(); i++) {
                Field nameField = object.getClass().getField(fieldNames.get(i));
                Object actualValue = nameField.get(object);
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

    private Class<?>[] getTypesForConstructorParams(Object[] constructorParams) {
        return Arrays.stream(constructorParams)
                .map(param -> BOXED_UNBOXED_CLASSES.getOrDefault(param.getClass(), param.getClass()))
                .collect(Collectors.toList())
                .toArray(new Class<?>[constructorParams.length]);
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
