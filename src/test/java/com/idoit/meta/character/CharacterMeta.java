package com.idoit.meta.character;

import com.idoit.meta.Meta;
import com.idoit.meta.battlefield.PointMeta;
import com.idoit.meta.item.bijouterie.belt.StrengthBeltMeta;
import com.idoit.meta.item.bijouterie.necklace.StrengthNecklaceMeta;
import com.idoit.meta.item.bijouterie.ring.StrengthRingMeta;
import com.idoit.meta.item.common.food.AppleMeta;
import com.idoit.meta.profile.ProfileMeta;

import java.util.HashMap;
import java.util.Map;

public abstract class CharacterMeta extends Meta {
    public CharacterMeta() throws ClassNotFoundException {
        packageName = BASE_PACKAGE + ".character";
        initFields();

        Map<String, Class<?>> constructor = new HashMap<>();
        constructor.put("name", String.class);
        addConstructorWithParams(constructor);

        initSetters();
        initGetters();
        addMethod(void.class, "hit", Class.forName(packageName + ".Knight")); //can't pass character meta to itself :(
        addMethod(void.class, "go", int.class, int.class);
        addMethod(void.class, "setActiveQuest", Class.forName("com.idoit.quest.Quest")); //circular dependency in meta context :(
        addMethod(void.class, "eat", new AppleMeta().getClassFromMeta());
    }

    private void initFields() throws ClassNotFoundException {
        fields.put("profile", Meta.getClassFromMeta(new ProfileMeta()));
        fields.put("leftRing", Meta.getClassFromMeta(new StrengthRingMeta()));
        fields.put("rightRing", Meta.getClassFromMeta(new StrengthRingMeta()));
        fields.put("belt", Meta.getClassFromMeta(new StrengthBeltMeta()));
        fields.put("necklace", Meta.getClassFromMeta(new StrengthNecklaceMeta()));
        fields.put("point", Meta.getClassFromMeta(new PointMeta()));
        fields.put("activeQuest", Class.forName("com.idoit.quest.Quest")); //circular dependency in meta context :(
    }

    private void initSetters() throws ClassNotFoundException {
        addMethod(void.class, "setProfile", Meta.getClassFromMeta(new ProfileMeta()));
    }

    private void initGetters() throws ClassNotFoundException {
        addMethod(Meta.getClassFromMeta(new ProfileMeta()), "getProfile");
        addMethod(Class.forName("com.idoit.quest.Quest"), "getActiveQuest"); //circular dependency :(
    }
}
