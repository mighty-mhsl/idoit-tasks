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
        addMethod(void.class, "setBow", Meta.getClassFromMeta(new BowMeta()));
        addMethod(void.class, "setLeftRing", Meta.getClassFromMeta(new AgilityRingMeta()));
        addMethod(void.class, "setRightRing", Meta.getClassFromMeta(new AgilityRingMeta()));
        addMethod(void.class, "setBelt", Meta.getClassFromMeta(new AgilityBeltMeta()));
        addMethod(void.class, "setNecklace", Meta.getClassFromMeta(new AgilityNecklaceMeta()));
    }

    private void initFields() throws ClassNotFoundException {
        fields.put("bow", Meta.getClassFromMeta(new BowMeta()));
        fields.put("leftRing", Meta.getClassFromMeta(new AgilityRingMeta()));
        fields.put("rightRing", Meta.getClassFromMeta(new AgilityRingMeta()));
        fields.put("belt", Meta.getClassFromMeta(new AgilityBeltMeta()));
        fields.put("necklace", Meta.getClassFromMeta(new AgilityNecklaceMeta()));
    }
}
