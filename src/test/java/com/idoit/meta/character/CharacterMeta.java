package com.idoit.meta.character;

import com.idoit.meta.Meta;
import com.idoit.meta.item.armor.BootsMeta;
import com.idoit.meta.item.armor.CuirassMeta;
import com.idoit.meta.item.armor.GlovesMeta;
import com.idoit.meta.item.armor.HelmetMeta;
import com.idoit.meta.item.armor.ShieldMeta;

abstract class CharacterMeta extends Meta {
    CharacterMeta() throws ClassNotFoundException {
        packageName = BASE_PACKAGE + ".character";
        fields.put("name", String.class);
        fields.put("hp", int.class);
        fields.put("mana", int.class);
        fields.put("strength", int.class);
        fields.put("intelligence", int.class);
        fields.put("agility", int.class);
        fields.put("level", int.class);
        fields.put("experience", int.class);
        fields.put("gold", int.class);
        fields.put("helmet", Meta.getClassFromMeta(new HelmetMeta()));
        fields.put("gloves", Meta.getClassFromMeta(new GlovesMeta()));
        fields.put("cuirass", Meta.getClassFromMeta(new CuirassMeta()));
        fields.put("boots", Meta.getClassFromMeta(new BootsMeta()));
        fields.put("shield", Meta.getClassFromMeta(new ShieldMeta()));
    }
}
