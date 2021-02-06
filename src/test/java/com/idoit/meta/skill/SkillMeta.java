package com.idoit.meta.skill;

import com.idoit.meta.Meta;

import java.util.Arrays;

abstract class SkillMeta extends Meta {
    SkillMeta() {
        packageName = BASE_PACKAGE + ".skill";
        initFields();
        addConstructorWithFieldsParams(Arrays.asList("name", "spendsMana", "minLevel"));
    }

    private void initFields() {
        fields.put("spendsMana", int.class);
        fields.put("minLevel", int.class);
        fields.put("characterClass", String.class);
        fields.put("name", String.class);
    }
}
