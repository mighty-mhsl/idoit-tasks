package com.idoit.meta.character.npc;

import com.idoit.meta.Meta;
import com.idoit.meta.character.KnightMeta;
import com.idoit.meta.quest.QuestMeta;

import java.util.Arrays;

public class NpcMeta extends Meta {
    public NpcMeta() throws ClassNotFoundException {
        packageName = BASE_PACKAGE + ".character.npc";
        className = "NPC";
        initFields();
        addConstructorWithFieldsParams(Arrays.asList("name", "level"));
        addMethod(void.class, "setQuest", Meta.getClassFromMeta(new QuestMeta()));
        addMethod(void.class, "giveQuest", Meta.getClassFromMeta(new KnightMeta()));
    }

    private void initFields() throws ClassNotFoundException {
        fields.put("name", String.class);
        fields.put("level", int.class);
        fields.put("quest", Meta.getClassFromMeta(new QuestMeta()));
    }
}
