package com.idoit.meta.character.npc;

import com.idoit.meta.Meta;

abstract class NpcMeta extends Meta {
    NpcMeta() {
        packageName = BASE_PACKAGE + ".character.npc";
        fields.put("name", String.class);
        fields.put("gold", int.class);
        fields.put("level", int.class);
    }
}
