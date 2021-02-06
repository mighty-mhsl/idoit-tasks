package com.idoit.meta.item.common.potion;

import com.idoit.meta.Meta;

import java.util.Arrays;

public abstract class PotionMeta extends Meta {

    public PotionMeta() {
        defaultConstructorParams = new Object[]{"test", 1};
    }

    @Override
    protected Class<? extends Look> getLookClass() {
        return PotionLook.class;
    }

    @Override
    public PotionLook getLook() {
        return new PotionLook("test", 1);
    }

    @Override
    protected void initConstructors() {
        addConstructorForFields(Arrays.asList("name", "pointsToRecover"));
    }

    public class PotionLook extends Look {
        private String name;
        private int pointsToRecover;

        PotionLook(String n, int pTR) {
            name = n;
            pointsToRecover = pTR;
        }

        public String getName() {
            return (String) invokeOriginal();
        }

        public int getPointsToRecover() {
            return (int) invokeOriginal();
        }
    }
}
