package com.idoit.meta;

import java.util.HashMap;
import java.util.Map;

public abstract class Meta {
    public static final String BASE_PACKAGE = "com.idoit";

    protected String packageName;
    protected String className;
    protected Map<String, Class<?>> fields = new HashMap<>();

    public static Class<?> getClassFromMeta(Meta meta) throws ClassNotFoundException {
        return Class.forName(meta.getFullClassName());
    }

    public Class<?> getClassFromMeta() throws ClassNotFoundException {
        return Class.forName(getFullClassName());
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
}
