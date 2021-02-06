package com.idoit.meta.skill;

import com.idoit.meta.Meta;

import java.util.Arrays;

public abstract class SkillMeta extends Meta {

    SkillMeta() {
        defaultConstructorParams = new Object[] {"test", 1, 2};
    }

    @Override
    protected Class<? extends Look> getLookClass() {
        return SkillLook.class;
    }

    @Override
    public Look getLook() {
        return new SkillLook("test", 1, 1);
    }

    @Override
    protected void initConstructors() {
        addConstructorForFields(Arrays.asList("name", "spendsMana", "minLevel"));
    }

    public class SkillLook extends Look {
        private int spendsMana;
        private int minLevel;
        private String name;
        private String characterClass;

        SkillLook(String n, int sM, int mL) {
            name = n;
            spendsMana = sM;
            minLevel = mL;
        }

        public int getSpendsMana() {
            return spendsMana;
        }

        public int getMinLevel() {
            return minLevel;
        }

        public String getName() {
            return name;
        }

        public String getCharacterClass() {
            return characterClass;
        }
    }
}
