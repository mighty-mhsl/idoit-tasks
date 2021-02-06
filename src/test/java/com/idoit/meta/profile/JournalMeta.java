package com.idoit.meta.profile;

import com.idoit.meta.Meta;
import com.idoit.meta.knowledge.KnowledgeMeta;
import com.idoit.meta.quest.QuestMeta;

public class JournalMeta extends Meta {

    @Override
    protected Class<? extends Look> getLookClass() {
        return JournalLook.class;
    }

    @Override
    public JournalLook getLook() {
        return new JournalLook();
    }

    public class JournalLook extends Look {
        private QuestMeta quest;
        private KnowledgeMeta knowledge;

        public QuestMeta getQuest() {
            Object originalQuest = invokeOriginal();
            return (QuestMeta) getMetaFromOriginal(quest, originalQuest);
        }

        public void setQuest(QuestMeta quest) {
            invokeOriginal(quest);
            this.quest = quest;
        }

        public KnowledgeMeta getKnowledge() {
            Object originalKnowledge = invokeOriginal();
            return (KnowledgeMeta) getMetaFromOriginal(knowledge, originalKnowledge);
        }

        public void setKnowledge(KnowledgeMeta knowledge) {
            invokeOriginal(knowledge);
            this.knowledge = knowledge;
        }
    }
}
