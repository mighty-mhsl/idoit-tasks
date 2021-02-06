package com.idoit.meta.item.weapon;

import com.idoit.meta.item.stone.DamageStoneMeta;

public class SwordMeta extends WeaponMeta {

    private SwordLook look;

    @Override
    protected Class<? extends Look> getLookClass() {
        return SwordLook.class;
    }

    @Override
    public SwordLook getLook() {
        if (look == null) {
            look = new SwordLook("test", 1);
        }
        return look;
    }

    public class SwordLook extends WeaponLook {

        private DamageStoneMeta stone;

        SwordLook(String n, int d) {
            super(n, d);
        }

        public DamageStoneMeta getStone() {
            Object originalStone = invokeOriginal();
            return (DamageStoneMeta) getMetaFromOriginal(stone, originalStone);
        }

        public void setStone(DamageStoneMeta stone) {
            invokeOriginal(stone);
            this.stone = stone;
        }
    }
}
