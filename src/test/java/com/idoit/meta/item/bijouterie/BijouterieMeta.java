package com.idoit.meta.item.bijouterie;

import com.idoit.meta.Meta;

import java.util.Arrays;

public class BijouterieMeta extends Meta {
    public BijouterieMeta() {
        initFields();
        addConstructorWithFieldsParams(Arrays.asList("name", "pointsToAdd"));
    }

    private void initFields() {
        fields.put("name", String.class);
        fields.put("pointsToAdd", int.class);
    }
}
