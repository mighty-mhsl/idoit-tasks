package com.idoit.meta.character.npc.enemy.boss;

import com.idoit.meta.Meta;
import com.idoit.meta.battlefield.PointMeta;
import com.idoit.meta.character.KnightMeta;

import java.util.Arrays;
import java.util.Collections;

public abstract class BossMeta extends Meta {
    public BossMeta() throws ClassNotFoundException {
        packageName = BASE_PACKAGE + ".character.npc.enemy.boss";
        initFields();
        addConstructorWithFieldsParams(Collections.unmodifiableList(Arrays.asList("level", "damage")));
        initSetters();
        initGetters();
        addMethod(void.class, "hit", Meta.getClassFromMeta(new KnightMeta()));
        addMethod(void.class, "go", int.class, int.class);
    }

    private void initFields() throws ClassNotFoundException {
        fields.put("name", String.class);
        fields.put("level", int.class);
        fields.put("damage", int.class);
        fields.put("expReward", int.class);
        fields.put("goldReward", int.class);
        fields.put("point", Meta.getClassFromMeta(new PointMeta()));
    }

    private void initSetters() throws ClassNotFoundException {
        addMethod(void.class, "setName", String.class);
        addMethod(void.class, "setLevel", int.class);
        addMethod(void.class, "setDamage", int.class);
        addMethod(void.class, "setExpReward", int.class);
        addMethod(void.class, "setGoldReward", int.class);
        addMethod(void.class, "setPoint", Meta.getClassFromMeta(new PointMeta()));
    }

    private void initGetters() throws ClassNotFoundException {
        addMethod(String.class, "getName");
        addMethod(int.class, "getLevel");
        addMethod(int.class, "getDamage");
        addMethod(int.class, "getExpReward");
        addMethod(int.class, "getGoldReward");
        addMethod(Meta.getClassFromMeta(new PointMeta()), "getPoint");
    }
}
