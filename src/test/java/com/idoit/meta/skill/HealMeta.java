package com.idoit.meta.skill;

import com.idoit.meta.character.KnightMeta;
import com.idoit.meta.character.WizardMeta;

public class HealMeta extends SkillMeta {

    public HealMeta() {
        defaultConstructorParams = new Object[]{"test", 1, 2};
    }

    @Override
    protected Class<? extends Look> getLookClass() {
        return HealLook.class;
    }

    @Override
    public HealLook getLook() {
        return new HealLook("test", 1, 2);
    }

    public class HealLook extends SkillLook {

        HealLook(String n, int sM, int mL) {
            super(n, sM, mL);
        }

        public void apply(WizardMeta wizard, KnightMeta knight) {
            invokeOriginal(wizard, knight);
        }
    }
}
