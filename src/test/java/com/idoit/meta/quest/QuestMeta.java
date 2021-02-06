package com.idoit.meta.quest;

import com.idoit.meta.Meta;
import com.idoit.meta.character.KnightMeta;

import java.util.Arrays;

public class QuestMeta extends Meta {
    public QuestMeta() throws ClassNotFoundException {
        packageName = BASE_PACKAGE + ".quest";
        className = "Quest";
        initFields();
        addConstructorWithFieldsParams(Arrays.asList("name", "description", "expReward", "goldReward", "minLevel"));
        addMethod(void.class, "complete", Meta.getClassFromMeta(new KnightMeta()));
    }

    private void initFields() {
        fields.put("name", String.class);
        fields.put("description", String.class);
        fields.put("expReward", int.class);
        fields.put("goldReward", int.class);
        fields.put("minLevel", int.class);
    }
}
