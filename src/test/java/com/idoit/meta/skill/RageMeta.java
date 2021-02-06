package com.idoit.meta.skill;

import com.idoit.meta.character.KnightMeta;

public class RageMeta extends SkillMeta {

    @Override
    protected Class<? extends Look> getLookClass() {
        return RageLook.class;
    }

    @Override
    public RageLook getLook() {
        return new RageLook("test", 1, 2);
    }

    public class RageLook extends SkillLook {

        RageLook(String n, int sM, int mL) {
            super(n, sM, mL);
        }

        public void apply(KnightMeta knight) {
            invokeOriginal(knight);
        }
    }
}
