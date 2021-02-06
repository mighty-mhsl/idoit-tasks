package com.idoit.meta.character.npc.enemy;

import com.idoit.meta.Meta;
import com.idoit.meta.battlefield.PointMeta;
import com.idoit.meta.character.KnightMeta;

import java.util.Arrays;

public abstract class EnemyMeta extends Meta {
    public EnemyMeta() throws ClassNotFoundException {
        packageName = BASE_PACKAGE + ".character.npc.enemy";
        initFields();
        addConstructorWithFieldsParams(Arrays.asList("level", "damage"));
        addMethod(void.class, "hit", Meta.getClassFromMeta(new KnightMeta()));
        addMethod(void.class, "go", int.class, int.class);
    }

    private void initFields() throws ClassNotFoundException {
        fields.put("name", String.class);
        fields.put("hp", int.class);
        fields.put("level", int.class);
        fields.put("expReward", int.class);
        fields.put("goldReward", int.class);
        fields.put("damage", int.class);
        fields.put("point", Meta.getClassFromMeta(new PointMeta()));
    }
}
