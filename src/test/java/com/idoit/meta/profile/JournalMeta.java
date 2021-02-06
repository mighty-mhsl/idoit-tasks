package com.idoit.meta.profile;

import com.idoit.meta.Meta;
import com.idoit.meta.knowledge.KnowledgeMeta;
import com.idoit.meta.quest.QuestMeta;

public class JournalMeta extends Meta {
    public JournalMeta() throws ClassNotFoundException {
        packageName = BASE_PACKAGE + ".profile";
        className = "Journal";
        initFields();
        initSetters();
        initGetters();
    }

    private void initFields() throws ClassNotFoundException {
        fields.put("knowledge", new KnowledgeMeta().getClassFromMeta());
        fields.put("quest", new QuestMeta().getClassFromMeta());
    }

    private void initSetters() throws ClassNotFoundException {
        addMethod(void.class, "setKnowledge", new KnowledgeMeta().getClassFromMeta());
        addMethod(void.class, "setQuest", new QuestMeta().getClassFromMeta());
    }

    private void initGetters() throws ClassNotFoundException {
        addMethod(new KnowledgeMeta().getClassFromMeta(), "getKnowledge");
        addMethod(new QuestMeta().getClassFromMeta(), "getQuest");
    }
}
