package com.idoit.meta.item.bijouterie;

import com.idoit.meta.Meta;

public class BijouterieMeta extends Meta {
    public BijouterieMeta() {
        fields.put("name", String.class);
        fields.put("pointsToAdd", int.class);
    }
}
