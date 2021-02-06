package com.idoit.meta.quest;

import com.idoit.meta.Meta;
import com.idoit.meta.character.KnightMeta;

import java.util.Arrays;

public class QuestMeta extends Meta {

    public QuestMeta() {
        defaultConstructorParams = new Object[]{"test", "test1", 1, 2, 3};
    }

    @Override
    protected Class<? extends Look> getLookClass() {
        return QuestLook.class;
    }

    @Override
    public QuestLook getLook() {
        return new QuestLook("test", "test1", 1, 2, 3);
    }

    @Override
    protected void initConstructors() {
        addConstructorForFields(Arrays.asList("name", "description", "expReward", "goldReward", "minLevel"));
    }

    public class QuestLook extends Look {
        private String name;
        private String description;
        private int expReward;
        private int goldReward;
        private int minLevel;

        QuestLook(String name, String description, int expReward, int goldReward, int minLevel) {
            this.name = name;
            this.description = description;
            this.expReward = expReward;
            this.goldReward = goldReward;
            this.minLevel = minLevel;
        }

        public void complete(KnightMeta knight) {
            invokeOriginal(knight);
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public int getExpReward() {
            return expReward;
        }

        public int getGoldReward() {
            return goldReward;
        }

        public int getMinLevel() {
            return minLevel;
        }
    }
}
