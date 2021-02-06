package com.idoit.meta.item.weapon;

import com.idoit.meta.Meta;

import java.util.Arrays;

public abstract class WeaponMeta extends Meta {
    public WeaponMeta() {
        packageName = BASE_PACKAGE + ".item.weapon";
        initFields();
        addConstructorWithFieldsParams(Arrays.asList("name", "damage"));
        addMethod(void.class, "setDurability", int.class);
    }

    private void initFields() {
        fields.put("name", String.class);
        fields.put("damage", int.class);
        fields.put("durability", int.class);
    }
}
