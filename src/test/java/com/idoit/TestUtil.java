package com.idoit;

import org.reflections8.Reflections;
import org.reflections8.scanners.SubTypesScanner;
import org.reflections8.util.ClasspathHelper;
import org.reflections8.util.ConfigurationBuilder;
import org.reflections8.util.FilterBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestUtil {

    private static final List<ClassLoader> CLASS_LOADERS = new ArrayList<>();
    private static final Map<Class<?>, Class<?>> BOXED_UNBOXED_CLASSES = new HashMap<>();

    static {
        CLASS_LOADERS.add(ClasspathHelper.contextClassLoader());
        CLASS_LOADERS.add(ClasspathHelper.staticClassLoader());

        BOXED_UNBOXED_CLASSES.put(Integer.class, int.class);
        BOXED_UNBOXED_CLASSES.put(Short.class, short.class);
        BOXED_UNBOXED_CLASSES.put(Byte.class, byte.class);
        BOXED_UNBOXED_CLASSES.put(Long.class, long.class);
        BOXED_UNBOXED_CLASSES.put(Character.class, char.class);
        BOXED_UNBOXED_CLASSES.put(Boolean.class, boolean.class);
        BOXED_UNBOXED_CLASSES.put(Double.class, double.class);
        BOXED_UNBOXED_CLASSES.put(Float.class, float.class);
    }

    public static Class<?>[] getTypesForParams(Object[] params) {
        return Arrays.stream(params)
                .map(param -> BOXED_UNBOXED_CLASSES.getOrDefault(param.getClass(), param.getClass()))
                .collect(Collectors.toList())
                .toArray(new Class<?>[params.length]);
    }

    public static Reflections getBaseReflections(String packageName) {
        return new Reflections(new ConfigurationBuilder()
                .setScanners(new SubTypesScanner(false))
                .setUrls(ClasspathHelper.forClassLoader(CLASS_LOADERS.toArray(new ClassLoader[0])))
                .filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix(packageName))));
    }
}
