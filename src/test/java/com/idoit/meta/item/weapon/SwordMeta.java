package com.idoit.meta.item.weapon;

import com.idoit.meta.Meta;
import com.idoit.meta.item.stone.DamageStoneMeta;

public class SwordMeta extends WeaponMeta {
    public SwordMeta() throws ClassNotFoundException {
        className = "Sword";
        initFields();
        initSetters();
        initGetters();
    }

    private void initFields() throws ClassNotFoundException {
        fields.put("stone", Meta.getClassFromMeta(new DamageStoneMeta()));
    }

    private void initSetters() throws ClassNotFoundException {
        addMethod(void.class, "setStone", Meta.getClassFromMeta(new DamageStoneMeta()));
    }

    private void initGetters() throws ClassNotFoundException {
        addMethod(Meta.getClassFromMeta(new DamageStoneMeta()), "getStone");
    }
}
