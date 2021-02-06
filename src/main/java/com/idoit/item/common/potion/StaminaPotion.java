package com.idoit.item.common.potion;

public class StaminaPotion {
    public String name;
    public int pointsToRecover;

    public StaminaPotion(String n, int pTR) {
        name = n;
        pointsToRecover = pTR;
    }

    public String getName() {
        return name;
    }

    public int getPointsToRecover() {
        return pointsToRecover;
    }
}
