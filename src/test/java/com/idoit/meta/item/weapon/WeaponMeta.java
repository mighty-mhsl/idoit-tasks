package com.idoit.meta.item.weapon;

import com.idoit.meta.Meta;

abstract class WeaponMeta extends Meta {
    WeaponMeta() {
        packageName = BASE_PACKAGE + ".item.weapon";
        fields.put("name", String.class);
        fields.put("damage", int.class);
    }
}
