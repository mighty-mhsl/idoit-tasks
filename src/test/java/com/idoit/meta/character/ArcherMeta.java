package com.idoit.meta.character;

import com.idoit.meta.Meta;
import com.idoit.meta.item.bijouterie.belt.AgilityBeltMeta;
import com.idoit.meta.item.bijouterie.necklace.AgilityNecklaceMeta;
import com.idoit.meta.item.bijouterie.ring.AgilityRingMeta;
import com.idoit.meta.item.weapon.BowMeta;

public class ArcherMeta extends CharacterMeta {
    public ArcherMeta() throws ClassNotFoundException {
        className = "Archer";
        initFields();
        initSetters();
        initGetters();
        addMethod(void.class, "castSkill", Class.forName(packageName + ".Knight")); //can't pass character meta to itself :(
    }

    private void initFields() throws ClassNotFoundException {
        fields.put("bow", Meta.getClassFromMeta(new BowMeta()));
        fields.put("leftRing", Meta.getClassFromMeta(new AgilityRingMeta()));
        fields.put("rightRing", Meta.getClassFromMeta(new AgilityRingMeta()));
        fields.put("belt", Meta.getClassFromMeta(new AgilityBeltMeta()));
        fields.put("necklace", Meta.getClassFromMeta(new AgilityNecklaceMeta()));
        fields.put("skill", Class.forName("com.idoit.skill.AccurateShot")); // circular dependency :(
    }

    private void initSetters() throws ClassNotFoundException {
        addMethod(void.class, "setBow", Meta.getClassFromMeta(new BowMeta()));
        addMethod(void.class, "setLeftRing", Meta.getClassFromMeta(new AgilityRingMeta()));
        addMethod(void.class, "setRightRing", Meta.getClassFromMeta(new AgilityRingMeta()));
        addMethod(void.class, "setBelt", Meta.getClassFromMeta(new AgilityBeltMeta()));
        addMethod(void.class, "setNecklace", Meta.getClassFromMeta(new AgilityNecklaceMeta()));
        addMethod(void.class, "setSkill", Class.forName("com.idoit.skill.AccurateShot")); //circular dependency :(
    }

    private void initGetters() throws ClassNotFoundException {
        addMethod(Meta.getClassFromMeta(new BowMeta()), "getBow");
        addMethod(Meta.getClassFromMeta(new AgilityRingMeta()), "getLeftRing");
        addMethod(Meta.getClassFromMeta(new AgilityRingMeta()), "getRightRing");
        addMethod(Meta.getClassFromMeta(new AgilityBeltMeta()), "getBelt");
        addMethod(Meta.getClassFromMeta(new AgilityNecklaceMeta()), "getNecklace");
        addMethod(Class.forName("com.idoit.skill.AccurateShot"), "getSkill"); //circular dependency :(
    }
}
