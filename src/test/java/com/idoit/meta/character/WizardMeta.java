package com.idoit.meta.character;

import com.idoit.meta.Meta;
import com.idoit.meta.item.bijouterie.belt.IntelligenceBeltMeta;
import com.idoit.meta.item.bijouterie.necklace.IntelligenceNecklaceMeta;
import com.idoit.meta.item.bijouterie.ring.IntelligenceRingMeta;
import com.idoit.meta.item.weapon.StaffMeta;

public class WizardMeta extends CharacterMeta {
    public WizardMeta() throws ClassNotFoundException {
        className = "Wizard";
        initFields();
        initSetters();
        initGetters();
        addMethod(void.class, "castSkill", Class.forName(packageName + ".Knight")); //can't pass character meta to itself :(
    }

    private void initFields() throws ClassNotFoundException {
        fields.put("staff", Meta.getClassFromMeta(new StaffMeta()));
        fields.put("leftRing", Meta.getClassFromMeta(new IntelligenceRingMeta()));
        fields.put("rightRing", Meta.getClassFromMeta(new IntelligenceRingMeta()));
        fields.put("belt", Meta.getClassFromMeta(new IntelligenceBeltMeta()));
        fields.put("necklace", Meta.getClassFromMeta(new IntelligenceNecklaceMeta()));
        fields.put("skill", Class.forName("com.idoit.skill.Heal")); //circular dependency :(
    }

    private void initSetters() throws ClassNotFoundException {
        addMethod(void.class, "setStaff", Meta.getClassFromMeta(new StaffMeta()));
        addMethod(void.class, "setLeftRing", Meta.getClassFromMeta(new IntelligenceRingMeta()));
        addMethod(void.class, "setRightRing", Meta.getClassFromMeta(new IntelligenceRingMeta()));
        addMethod(void.class, "setBelt", Meta.getClassFromMeta(new IntelligenceBeltMeta()));
        addMethod(void.class, "setNecklace", Meta.getClassFromMeta(new IntelligenceNecklaceMeta()));
        addMethod(void.class, "setSkill", Class.forName("com.idoit.skill.Heal")); //circular dependency :(
    }

    private void initGetters() throws ClassNotFoundException {
        addMethod(Meta.getClassFromMeta(new StaffMeta()), "getStaff");
        addMethod(Meta.getClassFromMeta(new IntelligenceRingMeta()), "getLeftRing");
        addMethod(Meta.getClassFromMeta(new IntelligenceRingMeta()), "getRightRing");
        addMethod(Meta.getClassFromMeta(new IntelligenceBeltMeta()), "getBelt");
        addMethod(Meta.getClassFromMeta(new IntelligenceNecklaceMeta()), "getNecklace");
        addMethod(Class.forName("com.idoit.skill.Heal"), "getSkill"); //circular dependency :(
    }
}
