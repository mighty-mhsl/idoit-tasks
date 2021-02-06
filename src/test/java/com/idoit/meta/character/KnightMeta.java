package com.idoit.meta.character;

import com.idoit.meta.Meta;
import com.idoit.meta.item.weapon.SwordMeta;

public class KnightMeta extends CharacterMeta {
    public KnightMeta() throws ClassNotFoundException {
        className = "Knight";
        fields.put("sword", Meta.getClassFromMeta(new SwordMeta()));
    }
}
