package com.idoit.meta.skill;

import com.idoit.meta.Meta;
import com.idoit.meta.character.KnightMeta;

public class HealMeta extends SkillMeta {
    public HealMeta() throws ClassNotFoundException {
        className = "Heal";
        addMethod(void.class, "apply", Meta.getClassFromMeta(new KnightMeta()));
    }
}
