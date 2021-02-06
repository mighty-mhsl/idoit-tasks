package com.idoit.meta.item.weapon;

import com.idoit.meta.Meta;
import com.idoit.meta.item.stone.CriticalHitStoneMeta;

public class BowMeta extends WeaponMeta {
    public BowMeta() throws ClassNotFoundException {
        className = "Bow";
        initFields();
        initSetters();
        initGetters();
    }

    private void initFields() throws ClassNotFoundException {
        fields.put("stone", Meta.getClassFromMeta(new CriticalHitStoneMeta()));
    }

    private void initSetters() throws ClassNotFoundException {
        addMethod(void.class, "setStone", Meta.getClassFromMeta(new CriticalHitStoneMeta()));
    }

    private void initGetters() throws ClassNotFoundException {
        addMethod(Meta.getClassFromMeta(new CriticalHitStoneMeta()), "getStone");
    }
}
