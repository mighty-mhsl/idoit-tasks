package com.idoit.meta.item.common.potion;

import com.idoit.meta.Meta;

abstract class PotionMeta extends Meta {
    PotionMeta() {
        packageName = BASE_PACKAGE + ".item.common.potion";
        fields.put("name", String.class);
        fields.put("pointsToRecover", int.class);
    }
}
