package com.idoit;

import com.idoit.meta.Meta;
import org.reflections8.Reflections;

import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class AbstractTest {

    protected abstract String getPackageName();

    protected void testClassIsInPackage(String className) {
        String packageName = getPackageName();
        Reflections reflections = TestUtil.getBaseReflections(packageName);
        boolean classExists = checkIfClassExistsInPackage(reflections, className, packageName);
        assertTrue(classExists, getMessage(classExists, className, packageName));
    }

    private boolean checkIfClassExistsInPackage(Reflections reflections, String className, String packageName) {
        return reflections.getSubTypesOf(Object.class).stream()
                .map(Class::getName)
                .anyMatch(Meta.getFullClassName(className, packageName)::equals);
    }

    private String getMessage(boolean classExists, String className, String packageName) {
        String defaultMessage = String.format("Нет класса с именем %s", className);
        String actualMessage = defaultMessage;
        if (!classExists) {
            actualMessage = getMessageForAnotherPackage(className, defaultMessage);
        }

        String expected = String.format("Класс %s в пакете %s", className, packageName);
        return MessageUtil.formatAssertMessage(expected, actualMessage);
    }

    private String getMessageForAnotherPackage(String className, String defaultMessage) {
        Reflections reflections = TestUtil.getBaseReflections(Meta.BASE_PACKAGE);
        return reflections.getSubTypesOf(Object.class).stream()
                .filter(clazz -> clazz.getName().contains(className))
                .findFirst()
                .map(clazz -> String.format("Класс %s в пакете %s", className, clazz.getPackage().getName()))
                .orElse(defaultMessage);
    }
}
