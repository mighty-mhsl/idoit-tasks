package com.idoit.meta.character.npc;

import com.idoit.meta.Meta;

import java.util.Arrays;

abstract class NpcMeta extends Meta {
    NpcMeta() {
        packageName = BASE_PACKAGE + ".character.npc";
        initFields();
        addConstructorWithFieldsParams(Arrays.asList("name", "level"));
    }

    private void initFields() {
        fields.put("name", String.class);
        fields.put("gold", int.class);
        fields.put("level", int.class);
    }
}
