package com.idoit.meta.skill;

import com.idoit.meta.character.ArcherMeta;
import com.idoit.meta.character.KnightMeta;

public class AccurateShotMeta extends SkillMeta {

    private AccurateShotLook look;

    @Override
    protected Class<? extends Look> getLookClass() {
        return AccurateShotLook.class;
    }

    @Override
    public AccurateShotLook getLook() {
        if (look == null) {
            look = new AccurateShotLook("test", 1, 2);
        }
        return look;
    }

    public class AccurateShotLook extends SkillLook {

        AccurateShotLook(String n, int sM, int mL) {
            super(n, sM, mL);
        }

        public void apply(ArcherMeta archer, KnightMeta knight) {
            invokeOriginal(archer, knight);
        }
    }
}
