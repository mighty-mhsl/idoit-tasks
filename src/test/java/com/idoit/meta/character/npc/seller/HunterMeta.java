package com.idoit.meta.character.npc.seller;

import com.idoit.meta.item.weapon.BowMeta;

public class HunterMeta extends SellerMeta {

    @Override
    protected Class<? extends Look> getLookClass() {
        return HunterLook.class;
    }

    @Override
    public HunterLook getLook() {
        return new HunterLook("test", 1);
    }

    public class HunterLook extends SellerLook {

        HunterLook(String n, int l) {
            super(n, l);
        }

        public void fix(BowMeta bow) {
            invokeOriginal(bow);
        }
    }
}
