package com.idoit.meta.item.weapon;

import com.idoit.meta.item.stone.HealStoneMeta;

public class StaffMeta extends WeaponMeta {

    private StaffLook look;

    @Override
    protected Class<? extends Look> getLookClass() {
        return StaffLook.class;
    }

    @Override
    public StaffLook getLook() {
        if (look == null) {
            look = new StaffLook("test", 1);
        }
        return look;
    }

    public class StaffLook extends WeaponLook {

        private HealStoneMeta stone;

        StaffLook(String n, int d) {
            super(n, d);
        }

        public HealStoneMeta getStone() {
            return stone;
        }

        public void setStone(HealStoneMeta stone) {
            this.stone = stone;
        }
    }
}
