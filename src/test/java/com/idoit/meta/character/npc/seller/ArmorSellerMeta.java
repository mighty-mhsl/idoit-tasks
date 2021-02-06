package com.idoit.meta.character.npc.seller;

import com.idoit.meta.item.armor.BootsMeta;
import com.idoit.meta.item.armor.CuirassMeta;
import com.idoit.meta.item.armor.GlovesMeta;
import com.idoit.meta.item.armor.HelmetMeta;
import com.idoit.meta.item.armor.ShieldMeta;
import com.idoit.meta.item.special.InitialStoneMeta;

public class ArmorSellerMeta extends SellerMeta {

    @Override
    protected Class<? extends Look> getLookClass() {
        return ArmorSellerLook.class;
    }

    @Override
    public ArmorSellerLook getLook() {
        return new ArmorSellerLook("test", 1);
    }

    public class ArmorSellerLook extends SellerLook {

        ArmorSellerLook(String n, int l) {
            super(n, l);
        }

        public void fix(HelmetMeta helmet) {
            invokeOriginal(helmet);
        }

        public void fix(CuirassMeta cuirass) {
            invokeOriginal(cuirass);
        }

        public void fix(GlovesMeta gloves) {
            invokeOriginal(gloves);
        }

        public void fix(BootsMeta boots) {
            invokeOriginal(boots);
        }

        public void fix(ShieldMeta shield) {
            invokeOriginal(shield);
        }

        public void accept(InitialStoneMeta stone) {
            invokeOriginal(stone);
        }
    }
}
