package com.idoit.meta.item.common.book;

import com.idoit.meta.Meta;
import com.idoit.meta.skill.HealMeta;

public class HealBookMeta extends BookMeta {
    public HealBookMeta() throws ClassNotFoundException {
        className = "HealBook";
        fields.put("skill", Meta.getClassFromMeta(new HealMeta()));
    }
}
