package com.idoit.meta.item.common.book;

import com.idoit.meta.Meta;

import java.util.Arrays;

public abstract class BookMeta extends Meta {
    public BookMeta() {
        packageName = BASE_PACKAGE + ".item.common.book";
        initFields();
        addConstructorWithFieldsParams(Arrays.asList("name", "minLevel"));
    }

    private void initFields() {
        fields.put("name", String.class);
        fields.put("minLevel", int.class);
    }
}
