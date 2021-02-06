package com.idoit.meta.character.npc.seller;

import com.idoit.meta.character.KnightMeta;
import com.idoit.meta.character.WizardMeta;
import com.idoit.meta.item.special.IgniteHammerMeta;
import com.idoit.meta.item.stone.CriticalHitStoneMeta;
import com.idoit.meta.item.stone.DamageStoneMeta;
import com.idoit.meta.item.stone.HealStoneMeta;
import com.idoit.meta.item.weapon.BowMeta;
import com.idoit.meta.item.weapon.StaffMeta;
import com.idoit.meta.item.weapon.SwordMeta;

public class BlacksmithMeta extends SellerMeta {

    @Override
    protected Class<? extends Look> getLookClass() {
        return BlacksmithLook.class;
    }

    @Override
    public BlacksmithLook getLook() {
        return new BlacksmithLook("test", 1);
    }

    public class BlacksmithLook extends SellerLook {

        BlacksmithLook(String n, int l) {
            super(n, l);
        }

        public void fix(KnightMeta knight, SwordMeta sword) {
            invokeOriginal(knight, sword);
        }

        public void fix(WizardMeta wizard, StaffMeta staff) {
            invokeOriginal(wizard, staff);
        }

        public void accept(IgniteHammerMeta hammer) {
            invokeOriginal(hammer);
        }

        public void insertStoneToWeapon(SwordMeta sword, DamageStoneMeta stone) {
            invokeOriginal(sword, stone);
            sword.getLook().setFieldWithoutOriginalCall("stone", stone);
        }

        public void insertStoneToWeapon(StaffMeta staff, HealStoneMeta stone) {
            invokeOriginal(staff, stone);
            staff.getLook().setFieldWithoutOriginalCall("stone", stone);
        }

        public void insertStoneToWeapon(BowMeta bow, CriticalHitStoneMeta stone) {
            invokeOriginal(bow, stone);
            bow.getLook().setFieldWithoutOriginalCall("stone", stone);
        }
    }
}
