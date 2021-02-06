package com.idoit.meta.skill;

import com.idoit.meta.Meta;
import com.idoit.meta.character.KnightMeta;

public class RageMeta extends SkillMeta {
    public RageMeta() throws ClassNotFoundException {
        className = "Rage";
        addMethod(void.class, "apply", Meta.getClassFromMeta(new KnightMeta()));
    }
}
