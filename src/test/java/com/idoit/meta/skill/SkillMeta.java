package com.idoit.meta.skill;

import com.idoit.meta.Meta;

abstract class SkillMeta extends Meta {
    SkillMeta() {
        packageName = BASE_PACKAGE + ".skill";
        fields.put("spendsMana", int.class);
        fields.put("minLevel", int.class);
        fields.put("characterClass", String.class);
        fields.put("name", String.class);
    }
}
