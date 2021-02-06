package com.idoit.meta.item.common.book;

import com.idoit.meta.Meta;
import com.idoit.meta.skill.RageMeta;

public class RageBookMeta extends BookMeta {
    public RageBookMeta() throws ClassNotFoundException {
        className = "RageBook";
        fields.put("skill", Meta.getClassFromMeta(new RageMeta()));
    }
}
