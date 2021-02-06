package com.idoit.meta.skill;

import com.idoit.meta.Meta;
import com.idoit.meta.character.ArcherMeta;
import com.idoit.meta.character.KnightMeta;

public class AccurateShotMeta extends SkillMeta {
    public AccurateShotMeta() throws ClassNotFoundException {
        className = "AccurateShot";
        addMethod(void.class, "apply", Meta.getClassFromMeta(new ArcherMeta()), Meta.getClassFromMeta(new KnightMeta()));
    }
}
