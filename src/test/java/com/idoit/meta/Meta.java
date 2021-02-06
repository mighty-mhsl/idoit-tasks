package com.idoit.meta;

public abstract class Meta {
    public static final String BASE_PACKAGE = "com.idoit";

    public static String getFullClassName(String className, String packageName) {
        return packageName + "." + className;
    }
}
