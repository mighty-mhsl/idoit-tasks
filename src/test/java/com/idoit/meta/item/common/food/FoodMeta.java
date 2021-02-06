package com.idoit.meta.item.common.food;

import com.idoit.meta.Meta;

public abstract class FoodMeta extends Meta {

    @Override
    protected Class<? extends Look> getLookClass() {
        return FoodLook.class;
    }

    @Override
    public FoodLook getLook() {
        return new FoodLook();
    }

    public class FoodLook extends Look {
        private String name;
        private int pointsToRecover;

        public String getName() {
            return (String) invokeOriginal();
        }

        public int getPointsToRecover() {
            return (int) invokeOriginal();
        }

        public void setName(String name) {
            invokeOriginal(name);
            this.name = name;
        }

        public void setPointsToRecover(int pointsToRecover) {
            invokeOriginal(pointsToRecover);
            this.pointsToRecover = pointsToRecover;
        }
    }
}
