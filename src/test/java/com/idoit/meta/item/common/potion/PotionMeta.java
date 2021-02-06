package com.idoit.meta.item.common.potion;

import com.idoit.meta.Meta;

import java.util.Arrays;

public abstract class PotionMeta extends Meta {
    public PotionMeta() {
        packageName = BASE_PACKAGE + ".item.common.potion";
        initFields();
        addConstructorWithFieldsParams(Arrays.asList("name", "pointsToRecover"));
        initGetters();
    }

    private void initFields() {
        fields.put("name", String.class);
        fields.put("pointsToRecover", int.class);
    }

    private void initGetters() {
        addMethod(String.class, "getName");
        addMethod(int.class, "getPointsToRecover");
    }
}
