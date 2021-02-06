package com.idoit.meta.item.common.book;

import com.idoit.meta.skill.HealMeta;

public class HealBookMeta extends BookMeta {

    @Override
    protected Class<? extends Look> getLookClass() {
        return HealBookLook.class;
    }

    @Override
    public Look getLook() {
        return new HealBookLook("", 1);
    }

    private class HealBookLook extends BookLook {
        private HealMeta skill;

        public HealBookLook(String name, int minLevel) {
            super(name, minLevel);
        }

        public HealMeta getSkill() {
            return skill;
        }
    }
}
