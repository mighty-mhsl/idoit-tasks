package com.idoit.meta.character;

import com.idoit.meta.Meta;
import com.idoit.meta.item.bijouterie.belt.StrengthBeltMeta;
import com.idoit.meta.item.bijouterie.necklace.StrengthNecklaceMeta;
import com.idoit.meta.item.bijouterie.ring.StrengthRingMeta;
import com.idoit.meta.item.weapon.SwordMeta;

public class KnightMeta extends CharacterMeta {
    public KnightMeta() throws ClassNotFoundException {
        className = "Knight";
        initFields();
        addMethod(void.class, "setSword", Meta.getClassFromMeta(new SwordMeta()));
        addMethod(void.class, "setLeftRing", Meta.getClassFromMeta(new StrengthRingMeta()));
        addMethod(void.class, "setRightRing", Meta.getClassFromMeta(new StrengthRingMeta()));
        addMethod(void.class, "setBelt", Meta.getClassFromMeta(new StrengthBeltMeta()));
        addMethod(void.class, "setNecklace", Meta.getClassFromMeta(new StrengthNecklaceMeta()));
        addMethod(void.class, "addGold", int.class);
        addMethod(void.class, "addExperience", int.class);
        addMethod(void.class, "calculatePhysicalDefence");
        addMethod(void.class, "calculateMagicDefence");
        addMethod(void.class, "talkTo", Class.forName("com.idoit.character.npc.NPC")); //circular dependency in meta context :(
        addMethod(void.class, "castSkill");
    }

    private void initFields() throws ClassNotFoundException {
        fields.put("sword", Meta.getClassFromMeta(new SwordMeta()));
        fields.put("leftRing", Meta.getClassFromMeta(new StrengthRingMeta()));
        fields.put("rightRing", Meta.getClassFromMeta(new StrengthRingMeta()));
        fields.put("belt", Meta.getClassFromMeta(new StrengthBeltMeta()));
        fields.put("necklace", Meta.getClassFromMeta(new StrengthNecklaceMeta()));
        fields.put("skill", Class.forName("com.idoit.skill.Rage")); //circular dependency :(
        fields.put("physicalDefence", int.class);
        fields.put("magicDefence", int.class);
    }
}
