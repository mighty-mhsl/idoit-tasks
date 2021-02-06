package com.idoit.meta.battlefield;

import com.idoit.meta.Meta;

import java.util.Arrays;

public class PointMeta extends Meta {
    public PointMeta() {
        packageName = BASE_PACKAGE + ".battlefield";
        className = "Point";
        initFields();
        addConstructorWithFieldsParams(Arrays.asList("x", "y"));
        addMethod(void.class, "setX", int.class);
        addMethod(void.class, "setY", int.class);
        addMethod(void.class, "setXY", int.class, int.class);
    }

    private void initFields() {
        fields.put("x", int.class);
        fields.put("y", int.class);
    }
}
