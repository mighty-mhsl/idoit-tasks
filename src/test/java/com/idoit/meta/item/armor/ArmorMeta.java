package com.idoit.meta.item.armor;

import com.idoit.meta.Meta;

abstract class ArmorMeta extends Meta {
    ArmorMeta() {
        packageName = BASE_PACKAGE + ".item.armor";
        fields.put("name", String.class);
        fields.put("type", String.class);
        fields.put("physicalDefence", int.class);
        fields.put("magicDefence", int.class);
    }
}
