package com.idoit.meta.item.common;

import com.idoit.meta.Meta;

import java.util.Collections;

public class BagMeta extends Meta {

    public BagMeta() {
        defaultConstructorParams = new Object[]{"test"};
    }

    @Override
    protected Class<? extends Look> getLookClass() {
        return BagLook.class;
    }

    @Override
    public Look getLook() {
        return new BagLook("test");
    }

    @Override
    protected void initConstructors() {
        addConstructorForFields(Collections.singletonList("name"));
    }

    private class BagLook extends Look {
        private String name;

        public BagLook(String n) {
            name = n;
        }

        public String getName() {
            return name;
        }
    }
}
