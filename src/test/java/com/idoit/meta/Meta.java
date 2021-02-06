package com.idoit.meta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Meta {
    public static final String BASE_PACKAGE = "com.idoit";

    protected String packageName;
    protected String className;
    protected Map<String, Class<?>> fields = new HashMap<>();
    private Set<List<Map.Entry<String, Class<?>>>> constructors = new HashSet<>();

    public static Class<?> getClassFromMeta(Meta meta) throws ClassNotFoundException {
        return Class.forName(meta.getFullClassName());
    }

    public Class<?> getClassFromMeta() throws ClassNotFoundException {
        return Class.forName(getFullClassName());
    }

    protected void addConstructorWithFieldsParams(List<String> fieldNames) {
        List<Map.Entry<String, Class<?>>> constructor = new ArrayList<>();
        fieldNames.forEach(fieldName -> {
            fields.entrySet().stream()
                    .filter(field -> field.getKey().equals(fieldName))
                    .findFirst()
                    .ifPresent(constructor::add);
        });
        constructors.add(constructor);
    }

    public List<String> getFieldsByConstructorParamTypes(List<Class<?>> paramTypes) {
        return constructors.stream()
                .filter(constructor -> constructor.stream().allMatch(param -> paramTypes.contains(param.getValue())))
                .map(constructor -> constructor.stream()
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList())
                ).findFirst()
                .orElse(null);
    }

    public String getFullClassName() {
        return packageName + "." + className;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getClassName() {
        return className;
    }

    public Map<String, Class<?>> getFields() {
        return fields;
    }

    public Set<List<Map.Entry<String, Class<?>>>> getConstructors() {
        return constructors;
    }
}
