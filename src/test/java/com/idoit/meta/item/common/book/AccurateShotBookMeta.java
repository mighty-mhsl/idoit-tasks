package com.idoit.meta.item.common.book;

import com.idoit.meta.Meta;
import com.idoit.meta.skill.AccurateShotMeta;

public class AccurateShotBookMeta extends BookMeta {
    public AccurateShotBookMeta() throws ClassNotFoundException {
        className = "AccurateShotBook";
        fields.put("skill", Meta.getClassFromMeta(new AccurateShotMeta()));
    }
}
