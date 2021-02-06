package com.idoit.meta;

import com.idoit.TestUtil;
import com.idoit.safe.SafeConsumer;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.fail;

public abstract class Meta {
    public static final String BASE_PACKAGE = "com.idoit";

    private String packageName = getPackageNameFromMeta();
    private String className = getClassNameFromMeta();
    private Map<String, Class<?>> fields = new HashMap<>();
    private Set<List<Map.Entry<String, Class<?>>>> constructors = new HashSet<>();
    private Set<Method> methods = new HashSet<>();

    protected abstract Class<? extends Look> getLookClass();

    public abstract Look getLook();

    void init() throws ClassNotFoundException {
        initFields();
        initConstructors();
        initMethods();
    }

    protected void initConstructors() {
        //no constructors by default
    }

    public Class<?> getClassFromMeta() throws ClassNotFoundException {
        return Class.forName(getFullClassName());
    }

    public Object instantiateObjectWithConstructor(Object... params) throws Exception {
        Class<?>[] paramTypes = TestUtil.getTypesForParams(params);
        return getClassFromMeta().getConstructor(paramTypes).newInstance(params);
    }

    protected void addConstructorForFields(List<String> fieldNames) {
        List<Map.Entry<String, Class<?>>> constructor = new ArrayList<>();
        fieldNames.forEach(fieldName -> fields.entrySet().stream()
                .filter(field -> field.getKey().equals(fieldName))
                .findFirst()
                .ifPresent(constructor::add));
        constructors.add(constructor);
    }

    protected void addConstructorWithParams(Map<String, Class<?>> params) {
        constructors.add(new ArrayList<>(params.entrySet()));
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
        return packageName + '.' + className;
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

    private static Class<?> getClassFromMeta(Class<? extends Meta> clazz) throws ClassNotFoundException {
        Meta meta = MetaContext.getMeta(clazz);
        return getClassFromMeta(meta);
    }

    private static Class<?> getClassFromMeta(Meta meta) throws ClassNotFoundException {
        return Class.forName(meta.getFullClassName());
    }

    private void addMethod(Class<?> returnType, String name, Class<?>... paramTypes) throws ClassNotFoundException {
        if (Meta.class.isAssignableFrom(returnType)) {
            returnType = MetaContext.getMeta(returnType).getClassFromMeta();
        }
        for (int i = 0; i < paramTypes.length; i++) {
            if (Meta.class.isAssignableFrom(paramTypes[i])) {
                paramTypes[i] = MetaContext.getMeta(paramTypes[i]).getClassFromMeta();
            }
        }
        methods.add(new Method(returnType, name, Arrays.asList(paramTypes)));
    }

    private void addField(String fieldName, Class<?> clazz) {
        fields.put(fieldName, clazz);
    }

    private void initFields() throws ClassNotFoundException {
        Class<? extends Look> look = getLookClass();
        addFields(look);
        processSuperLooks(look, this::addFields);
    }

    private void initMethods() throws ClassNotFoundException {
        Class<? extends Look> look = getLookClass();
        addMethods(look);
        processSuperLooks(look, this::addMethods);
    }

    private String getPackageNameFromMeta() {
        return getClass().getPackage().getName().replaceFirst("\\.meta", "");
    }

    private String getClassNameFromMeta() {
        return getClass().getSimpleName().replaceFirst("Meta", "");
    }

    private void processSuperLooks(Class<? extends Look> look, SafeConsumer<Class<?>> superClassConsumer) throws ClassNotFoundException {
        Class<?> superClass = look.getSuperclass();
        while (Look.class != superClass && Look.class.isAssignableFrom(superClass)) {
            superClassConsumer.consume(superClass);
            superClass = superClass.getSuperclass();
        }
    }

    private void addFields(Class<?> look) throws ClassNotFoundException {
        for (Field field : look.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.getName().contains("this$")) {
                continue;
            }
            if (Meta.class.isAssignableFrom(field.getType())) {
                addField(field.getName(), MetaContext.getMeta(field.getType()).getClassFromMeta());
            } else {
                addField(field.getName(), field.getType());
            }
        }
    }

    private void addMethods(Class<?> look) throws ClassNotFoundException {
        for (java.lang.reflect.Method method : look.getDeclaredMethods()) {
            method.setAccessible(true);
            Class<?> returnType = getMethodReturnType(method);
            Class<?>[] paramTypes = getMethodParamTypes(method);
            addMethod(returnType, method.getName(), paramTypes);
        }
    }

    private Class<?> getMethodReturnType(java.lang.reflect.Method method) throws ClassNotFoundException {
        if (Meta.class.isAssignableFrom(method.getReturnType())) {
            return MetaContext.getMeta(method.getReturnType()).getClassFromMeta();
        } else {
            return method.getReturnType();
        }
    }

    private Class<?>[] getMethodParamTypes(java.lang.reflect.Method method) throws ClassNotFoundException {
        Class<?>[] paramTypes = new Class<?>[method.getParameterTypes().length];
        for (int i = 0; i < paramTypes.length; i++) {
            Class<?> paramType = method.getParameterTypes()[i];
            if (Meta.class.isAssignableFrom(paramType)) {
                paramTypes[i] = MetaContext.getMeta(paramType).getClassFromMeta();
            } else {
                paramTypes[i] = paramType;
            }
        }
        return paramTypes;
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

    protected Object[] defaultConstructorParams = {};
    private Object originalInstance;

    public void refresh() {
        originalInstance = null;
    }

    private Object getOriginalInstance() {
        getLook().createOriginalInstanceIfNeeded();
        return originalInstance;
    }

    public abstract class Look {

        public void setFieldWithoutOriginalCall(String fieldName, Meta value) {
            try {
                Field field = getClass().getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(this, value);
            } catch (Exception e) {
                fail(String.format("Невозможно установить значение поля %s без вызова оригинального метода в классе %s",
                        fieldName, getClassName()));
            }
        }

        protected Meta syncField(Class<? extends Meta> metaClass, String fieldName) {
            Meta meta = MetaContext.getMeta(metaClass);
            try {
                createOriginalInstanceIfNeeded();
                Field field = originalInstance.getClass().getField(fieldName);
                meta.originalInstance = field.get(originalInstance);
            } catch (Exception e) {
                fail(String.format("Невозможно синхронизировать значение по умолчанию поля %s в классе %s", fieldName, getClassName()));
            }
            return meta;
        }

        protected Meta getMetaFromOriginal(Meta dependency, Object original) {
            return dependency != null && dependency.originalInstance == original ? dependency : null;
        }

        protected Object invokeOriginal(Object... params) {
            java.lang.reflect.Method method;
            String methodName = null;
            try {
                methodName = Thread.currentThread().getStackTrace()[2].getMethodName(); //not the current method but the one that calls it
                Class<?> clazz = getClassFromMeta();
                createOriginalInstanceIfNeeded();
                mapMetaToOriginal(params);
                Class<?>[] paramTypes = TestUtil.getTypesForParams(params);
                method = clazz.getDeclaredMethod(methodName, paramTypes);
                method.setAccessible(true);
                return method.invoke(originalInstance, params);
            } catch (Exception e) {
                fail(String.format("Не удалось вызвать метод %s в классе %s", methodName, getClassName()));
            }
            return null;
        }

        void createOriginalInstanceIfNeeded() {
            try {
                if (originalInstance == null) {
                    Class<?>[] paramTypes = TestUtil.getTypesForParams(defaultConstructorParams);
                    originalInstance = getClassFromMeta().getDeclaredConstructor(paramTypes).newInstance(defaultConstructorParams);
                }
            } catch (Exception e) {
                fail(String.format("Не удалось создать объект класса %s с параметрами %s", getClassName(),
                        Arrays.toString(defaultConstructorParams)));
            }
        }

        private void mapMetaToOriginal(Object... params) {
            for (int i = 0; i < params.length; i++) {
                if (Meta.class.isAssignableFrom(params[i].getClass())) {
                    params[i] = ((Meta) params[i]).getOriginalInstance();
                }
            }
        }
    }
}
