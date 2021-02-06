package com.idoit.meta.item.bijouterie;

import com.idoit.meta.Meta;

import java.util.Arrays;

public abstract class BijouterieMeta extends Meta {

    public BijouterieMeta() {
        defaultConstructorParams = new Object[]{"test", 1};
    }

    @Override
    protected Class<? extends Look> getLookClass() {
        return BijouterieLook.class;
    }

    @Override
    public BijouterieLook getLook() {
        return new BijouterieLook("", 1);
    }

    @Override
    protected void initConstructors() {
        addConstructorForFields(Arrays.asList("name", "pointsToAdd"));
    }

    public class BijouterieLook extends Look {
        private String name;
        private int pointsToAdd;

        BijouterieLook(String n, int pTA) {
            name = n;
            pointsToAdd = pTA;
        }
    }
}
