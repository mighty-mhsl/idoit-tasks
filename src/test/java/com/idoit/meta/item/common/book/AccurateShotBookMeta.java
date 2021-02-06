package com.idoit.meta.item.common.book;

import com.idoit.meta.skill.AccurateShotMeta;

public class AccurateShotBookMeta extends BookMeta {

    @Override
    protected Class<? extends Look> getLookClass() {
        return AccurateShotBookLook.class;
    }

    @Override
    public Look getLook() {
        return new AccurateShotBookLook("", 1);
    }

    private class AccurateShotBookLook extends BookLook {
        private AccurateShotMeta skill;

        AccurateShotBookLook(String name, int minLevel) {
            super(name, minLevel);
        }

        public AccurateShotMeta getSkill() {
            return skill;
        }
    }
}
