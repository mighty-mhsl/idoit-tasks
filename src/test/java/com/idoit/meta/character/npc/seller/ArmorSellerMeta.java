package com.idoit.meta.character.npc.seller;

import com.idoit.meta.Meta;
import com.idoit.meta.item.armor.BootsMeta;
import com.idoit.meta.item.armor.CuirassMeta;
import com.idoit.meta.item.armor.GlovesMeta;
import com.idoit.meta.item.armor.HelmetMeta;
import com.idoit.meta.item.armor.ShieldMeta;

public class ArmorSellerMeta extends SellerMeta {
    public ArmorSellerMeta() throws ClassNotFoundException {
        className = "ArmorSeller";
        addMethod(void.class, "fix", Meta.getClassFromMeta(new HelmetMeta()));
        addMethod(void.class, "fix", Meta.getClassFromMeta(new CuirassMeta()));
        addMethod(void.class, "fix", Meta.getClassFromMeta(new GlovesMeta()));
        addMethod(void.class, "fix", Meta.getClassFromMeta(new BootsMeta()));
        addMethod(void.class, "fix", Meta.getClassFromMeta(new ShieldMeta()));
    }
}
