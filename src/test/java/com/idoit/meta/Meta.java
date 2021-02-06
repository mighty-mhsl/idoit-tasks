package com.idoit.meta;

import com.idoit.TestUtil;

import java.util.ArrayList;
import java.util.Arrays;
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
    private Set<Method> methods = new HashSet<>();

    public static Class<?> getClassFromMeta(Meta meta) throws ClassNotFoundException {
        return Class.forName(meta.getFullClassName());
    }

    public static Object instantiateObjectFromMeta(Class<? extends Meta> metaClass, Object... params) throws Exception {
        Meta meta = MetaContext.getMeta(metaClass);
        return meta.instantiateObjectWithConstructor(params);
    }

    public Class<?> getClassFromMeta() throws ClassNotFoundException {
        return Class.forName(getFullClassName());
    }

    public Object instantiateObjectWithConstructor(Object... params) throws Exception {
        Class<?>[] paramTypes = TestUtil.getTypesForParams(params);
        return getClassFromMeta().getConstructor(paramTypes).newInstance(params);
    }

    public java.lang.reflect.Method getMethodFromMeta(String name, Class<?>... paramTypes) throws ClassNotFoundException, NoSuchMethodException {
        return getClassFromMeta().getDeclaredMethod(name, paramTypes);
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

    protected void addMethod(Class<?> returnType, String name, Class<?>... paramTypes) {
        methods.add(new Method(returnType, name, Arrays.asList(paramTypes)));
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

    public Set<Method> getMethods() {
        return methods;
    }

    public static class Method {
        private Class<?> returnType;
        private String name;
        private List<Class<?>> paramTypes;

        private Method(Class<?> returnType, String name, List<Class<?>> paramTypes) {
            this.returnType = returnType;
            this.name = name;
            this.paramTypes = paramTypes;
        }

        public String getName() {
            return name;
        }

        public List<Class<?>> getParamTypes() {
            return paramTypes;
        }

        public Class<?> getReturnType() {
            return returnType;
        }
    }
}
