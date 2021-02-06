package com.idoit.meta.item.common.food;

import com.idoit.meta.Meta;

public abstract class FoodMeta extends Meta {
    public FoodMeta() {
        packageName = BASE_PACKAGE + ".item.common.food";
        fields.put("name", String.class);
        fields.put("pointsToRecover", int.class);
    }
}
