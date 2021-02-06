package com.idoit.meta.item.weapon;

import com.idoit.meta.Meta;

import java.util.Arrays;

abstract class WeaponMeta extends Meta {
    WeaponMeta() {
        packageName = BASE_PACKAGE + ".item.weapon";
        initFields();
        addConstructorWithFieldsParams(Arrays.asList("name", "damage"));
    }

    private void initFields() {
        fields.put("name", String.class);
        fields.put("damage", int.class);
    }
}
