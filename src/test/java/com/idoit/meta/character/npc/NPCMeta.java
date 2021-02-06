package com.idoit.meta.character.npc;

import com.idoit.meta.Meta;
import com.idoit.meta.character.KnightMeta;
import com.idoit.meta.quest.QuestMeta;

import java.util.Arrays;

public class NPCMeta extends Meta {

    private NPCLook look;

    public NPCMeta() {
        defaultConstructorParams = new Object[]{"test", 1};
    }

    @Override
    protected Class<? extends Look> getLookClass() {
        return NPCLook.class;
    }

    @Override
    public NPCLook getLook() {
        if (look == null) {
            look = new NPCLook("test", 1);
        }
        return look;
    }

    @Override
    protected void initConstructors() {
        addConstructorForFields(Arrays.asList("name", "level"));
    }

    public class NPCLook extends Look {
        private String name;
        private int level;
        private QuestMeta quest;

        NPCLook(String name, int level) {
            this.name = name;
            this.level = level;
        }

        public void giveQuest(KnightMeta knight) {
            invokeOriginal(knight);
            knight.getLook().setFieldWithoutOriginalCall("activeQuest", quest);
        }

        public void setQuest(QuestMeta quest) {
            invokeOriginal(quest);
            this.quest = quest;
        }

        public String getName() {
            return name;
        }

        public int getLevel() {
            return level;
        }

        public QuestMeta getQuest() {
            return quest;
        }
    }
}
