package com.idoit.meta.item.common.book;

import com.idoit.meta.skill.RageMeta;

public class RageBookMeta extends BookMeta {

    @Override
    protected Class<? extends Look> getLookClass() {
        return RageBookLook.class;
    }

    @Override
    public Look getLook() {
        return new RageBookLook("", 1);
    }

    private class RageBookLook extends BookLook {
        private RageMeta skill;

        public RageBookLook(String name, int minLevel) {
            super(name, minLevel);
        }

        public RageMeta getSkill() {
            return skill;
        }
    }
}
