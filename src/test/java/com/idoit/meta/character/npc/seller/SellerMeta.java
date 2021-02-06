package com.idoit.meta.character.npc.seller;

import com.idoit.meta.Meta;

import java.util.Arrays;

public abstract class SellerMeta extends Meta {

    public SellerMeta() {
        defaultConstructorParams = new Object[]{"test", 1};
    }

    @Override
    protected Class<? extends Look> getLookClass() {
        return SellerLook.class;
    }

    @Override
    public Look getLook() {
        return new SellerLook("", 1);
    }

    @Override
    protected void initConstructors() {
        addConstructorForFields(Arrays.asList("name", "level"));
    }

    public class SellerLook extends Look {
        private String name;
        private int level;
        private int gold;

        SellerLook(String n, int l) {
            name = n;
            level = l;
        }

        public String getName() {
            return (String) invokeOriginal();
        }

        public int getLevel() {
            return (int) invokeOriginal();
        }

        public int getGold() {
            return (int) invokeOriginal();
        }
    }
}
