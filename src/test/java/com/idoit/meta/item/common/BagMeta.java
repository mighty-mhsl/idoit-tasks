package com.idoit.meta.item.common;

import java.util.Collections;

public class BagMeta extends CommonMeta {
    public BagMeta() {
        className = "Bag";
        initFields();
        addConstructorWithFieldsParams(Collections.singletonList("name"));
    }

    private void initFields() {
        fields.put("name", String.class);
    }
}
