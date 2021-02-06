package com.idoit.meta.item.weapon;

import com.idoit.meta.item.stone.CriticalHitStoneMeta;

public class BowMeta extends WeaponMeta {

    private BowLook look;

    @Override
    protected Class<? extends Look> getLookClass() {
        return BowLook.class;
    }

    @Override
    public BowLook getLook() {
        if (look == null) {
            look = new BowLook("test", 1);
        }
        return look;
    }

    public class BowLook extends WeaponLook {

        private CriticalHitStoneMeta stone;

        BowLook(String n, int d) {
            super(n, d);
        }

        public CriticalHitStoneMeta getStone() {
            return stone;
        }

        public void setStone(CriticalHitStoneMeta stone) {
            this.stone = stone;
        }
    }
}
