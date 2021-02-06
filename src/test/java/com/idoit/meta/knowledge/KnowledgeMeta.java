package com.idoit.meta.knowledge;

import com.idoit.meta.Meta;

public class KnowledgeMeta extends Meta {
    public KnowledgeMeta() {
        packageName = BASE_PACKAGE + ".knowledge";
        className = "Knowledge";
        initFields();
        initSetters();
        initGetters();
    }

    private void initFields() {
        fields.put("description", String.class);
        fields.put("person", String.class);
    }

    private void initSetters() {
        addMethod(void.class, "setDescription", String.class);
        addMethod(void.class, "setPerson", String.class);
    }

    private void initGetters() {
        addMethod(String.class, "getDescription");
        addMethod(String.class, "getPerson");
    }
}
