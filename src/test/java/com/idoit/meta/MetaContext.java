package com.idoit.meta;

import com.idoit.TestUtil;
import org.reflections8.Reflections;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.fail;

public class MetaContext {

    private static final Map<Class<? extends Meta>, Meta> META = new HashMap<>();

    static {
        Reflections reflections = TestUtil.getBaseReflections("com.idoit.meta");
        Set<Class<? extends Meta>> allClasses = reflections.getSubTypesOf(Meta.class);
        allClasses.stream()
                .filter(clazz -> !Modifier.isAbstract(clazz.getModifiers()))
                .forEach(clazz -> {
                    try {
                        Meta meta = clazz.getConstructor().newInstance();
                        META.put(clazz, meta);
                    } catch (Exception e) {
                        fail("Ошибка при создании объектов мета-даты для классов, т.к. нет конструктора по умолчанию", e);
                    }
                });
    }

    public static Meta getMeta(Class<? extends Meta> clazz) {
        return META.get(clazz);
    }
}
