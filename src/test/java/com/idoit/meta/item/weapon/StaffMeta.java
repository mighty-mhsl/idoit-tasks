package com.idoit.meta.item.weapon;

import com.idoit.meta.Meta;
import com.idoit.meta.item.stone.HealStoneMeta;

public class StaffMeta extends WeaponMeta {
    public StaffMeta() throws ClassNotFoundException {
        className = "Staff";
        initFields();
        initSetters();
        initGetters();
    }

    private void initFields() throws ClassNotFoundException {
        fields.put("stone", Meta.getClassFromMeta(new HealStoneMeta()));
    }

    private void initSetters() throws ClassNotFoundException {
        addMethod(void.class, "setStone", Meta.getClassFromMeta(new HealStoneMeta()));
    }

    private void initGetters() throws ClassNotFoundException {
        addMethod(Meta.getClassFromMeta(new HealStoneMeta()), "getStone");
    }
}
