package com.idoit.meta.character;

import com.idoit.meta.Meta;
import com.idoit.meta.item.weapon.BowMeta;

public class ArcherMeta extends CharacterMeta {
    public ArcherMeta() throws ClassNotFoundException {
        className = "Archer";
        fields.put("bow", Meta.getClassFromMeta(new BowMeta()));
    }
}
