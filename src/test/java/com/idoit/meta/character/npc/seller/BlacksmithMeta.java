package com.idoit.meta.character.npc.seller;

import com.idoit.meta.Meta;
import com.idoit.meta.item.weapon.StaffMeta;
import com.idoit.meta.item.weapon.SwordMeta;

public class BlacksmithMeta extends SellerMeta {
    public BlacksmithMeta() throws ClassNotFoundException {
        className = "Blacksmith";
        addMethod(void.class, "fix", Meta.getClassFromMeta(new SwordMeta()));
        addMethod(void.class, "fix", Meta.getClassFromMeta(new StaffMeta()));
    }
}
