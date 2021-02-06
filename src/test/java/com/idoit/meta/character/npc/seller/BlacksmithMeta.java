package com.idoit.meta.character.npc.seller;

import com.idoit.meta.Meta;
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
    public BlacksmithMeta() throws ClassNotFoundException {
        className = "Blacksmith";
        addMethod(void.class, "fix", Meta.getClassFromMeta(new KnightMeta()), Meta.getClassFromMeta(new SwordMeta()));
        addMethod(void.class, "fix", Meta.getClassFromMeta(new WizardMeta()), Meta.getClassFromMeta(new StaffMeta()));
        addMethod(void.class, "accept", Meta.getClassFromMeta(new IgniteHammerMeta()));
        addMethod(void.class, "insertStoneToWeapon", Meta.getClassFromMeta(new SwordMeta()), Meta.getClassFromMeta(new DamageStoneMeta()));
        addMethod(void.class, "insertStoneToWeapon", Meta.getClassFromMeta(new StaffMeta()), Meta.getClassFromMeta(new HealStoneMeta()));
        addMethod(void.class, "insertStoneToWeapon", Meta.getClassFromMeta(new BowMeta()), Meta.getClassFromMeta(new CriticalHitStoneMeta()));
    }
}
