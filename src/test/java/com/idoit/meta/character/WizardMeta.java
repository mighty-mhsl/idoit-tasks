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
        addMethod(void.class, "setStaff", Meta.getClassFromMeta(new StaffMeta()));
        addMethod(void.class, "setLeftRing", Meta.getClassFromMeta(new IntelligenceRingMeta()));
        addMethod(void.class, "setRightRing", Meta.getClassFromMeta(new IntelligenceRingMeta()));
        addMethod(void.class, "setBelt", Meta.getClassFromMeta(new IntelligenceBeltMeta()));
        addMethod(void.class, "setNecklace", Meta.getClassFromMeta(new IntelligenceNecklaceMeta()));
    }

    private void initFields() throws ClassNotFoundException {
        fields.put("staff", Meta.getClassFromMeta(new StaffMeta()));
        fields.put("leftRing", Meta.getClassFromMeta(new IntelligenceRingMeta()));
        fields.put("rightRing", Meta.getClassFromMeta(new IntelligenceRingMeta()));
        fields.put("belt", Meta.getClassFromMeta(new IntelligenceBeltMeta()));
        fields.put("necklace", Meta.getClassFromMeta(new IntelligenceNecklaceMeta()));
    }
}
