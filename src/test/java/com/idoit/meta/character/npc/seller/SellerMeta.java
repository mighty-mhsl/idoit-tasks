package com.idoit.meta.character.npc.seller;

import com.idoit.meta.Meta;

import java.util.Arrays;

public abstract class SellerMeta extends Meta {
    public SellerMeta() {
        packageName = BASE_PACKAGE + ".character.npc.seller";
        initFields();
        addConstructorWithFieldsParams(Arrays.asList("name", "level"));
    }

    private void initFields() {
        fields.put("name", String.class);
        fields.put("gold", int.class);
        fields.put("level", int.class);
    }
}
