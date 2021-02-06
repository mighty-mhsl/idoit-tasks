package com.idoit.meta.character;

import com.idoit.meta.Meta;
import com.idoit.meta.battlefield.PointMeta;
import com.idoit.meta.item.armor.BootsMeta;
import com.idoit.meta.item.armor.CuirassMeta;
import com.idoit.meta.item.armor.GlovesMeta;
import com.idoit.meta.item.armor.HelmetMeta;
import com.idoit.meta.item.armor.ShieldMeta;
import com.idoit.meta.item.bijouterie.belt.StrengthBeltMeta;
import com.idoit.meta.item.bijouterie.necklace.StrengthNecklaceMeta;
import com.idoit.meta.item.bijouterie.ring.StrengthRingMeta;

import java.util.Collections;

public abstract class CharacterMeta extends Meta {
    public CharacterMeta() throws ClassNotFoundException {
        packageName = BASE_PACKAGE + ".character";
        initFields();
        addConstructorWithFieldsParams(Collections.singletonList("name"));
        initSetters();
        initGetters();
        addMethod(void.class, "hit", Class.forName(packageName + ".Knight")); //can't pass character meta to itself :(
        addMethod(void.class, "go", int.class, int.class);
        addMethod(void.class, "setActiveQuest", Class.forName("com.idoit.quest.Quest")); //circular dependency in meta context :(
    }

    private void initFields() throws ClassNotFoundException {
        fields.put("name", String.class);
        fields.put("hp", int.class);
        fields.put("mana", int.class);
        fields.put("stamina", int.class);
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
        fields.put("leftRing", Meta.getClassFromMeta(new StrengthRingMeta()));
        fields.put("rightRing", Meta.getClassFromMeta(new StrengthRingMeta()));
        fields.put("belt", Meta.getClassFromMeta(new StrengthBeltMeta()));
        fields.put("necklace", Meta.getClassFromMeta(new StrengthNecklaceMeta()));
        fields.put("point", Meta.getClassFromMeta(new PointMeta()));
        fields.put("activeQuest", Class.forName("com.idoit.quest.Quest")); //circular dependency in meta context :(
    }

    private void initSetters() throws ClassNotFoundException {
        addMethod(void.class, "setHelmet", Meta.getClassFromMeta(new HelmetMeta()));
        addMethod(void.class, "setCuirass", Meta.getClassFromMeta(new CuirassMeta()));
        addMethod(void.class, "setGloves", Meta.getClassFromMeta(new GlovesMeta()));
        addMethod(void.class, "setBoots", Meta.getClassFromMeta(new BootsMeta()));
        addMethod(void.class, "setShield", Meta.getClassFromMeta(new ShieldMeta()));
    }

    private void initGetters() throws ClassNotFoundException {
        addMethod(String.class, "getName");
        addMethod(int.class, "getStrength");
        addMethod(int.class, "getAgility");
        addMethod(int.class, "getIntelligence");
        addMethod(int.class, "getHp");
        addMethod(int.class, "getMana");
        addMethod(int.class, "getStamina");
        addMethod(int.class, "getLevel");
        addMethod(int.class, "getExperience");
        addMethod(int.class, "getGold");
        addMethod(Meta.getClassFromMeta(new HelmetMeta()), "getHelmet");
        addMethod(Meta.getClassFromMeta(new CuirassMeta()), "getCuirass");
        addMethod(Meta.getClassFromMeta(new GlovesMeta()), "getGloves");
        addMethod(Meta.getClassFromMeta(new BootsMeta()), "getBoots");
        addMethod(Meta.getClassFromMeta(new ShieldMeta()), "getShield");
        addMethod(Meta.getClassFromMeta(new PointMeta()), "getPoint");
        addMethod(Class.forName("com.idoit.quest.Quest"), "getActiveQuest"); //circular dependency :(
    }
}
