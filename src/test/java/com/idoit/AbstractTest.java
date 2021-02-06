package com.idoit;

import com.idoit.meta.Meta;
import org.reflections8.Reflections;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public abstract class AbstractTest {

    private Meta meta;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    protected void testClassIsInPackage() {
        Reflections reflections = TestUtil.getBaseReflections(meta.getPackageName());
        boolean classExists = checkIfClassExistsInPackage(reflections);
        assertTrue(classExists, getMessage(classExists));
    }

    protected void testClassHasFields() {
        Class<?> clazz = getClassOrFail();
        testClassHasFields(clazz);
    }

    protected void setMetaSafe(SafeSupplier<Meta> supplier) {
        try {
            setMeta(supplier.supply());
        } catch (Exception e) {
            fail("Не найдены все требуемые классы для данного теста.", e);
        }
    }

    private Class<?> getClassOrFail() {
        try {
            return meta.getClassFromMeta();
        } catch (ClassNotFoundException e) {
            fail(String.format("Класс %s не найден в пакете %s", meta.getClassName(), meta.getPackageName()));
        }
        return null;
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

    private String getMessage(boolean classExists) {
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
