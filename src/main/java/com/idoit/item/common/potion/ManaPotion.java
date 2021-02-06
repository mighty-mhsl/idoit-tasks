package com.idoit.item.common.potion;

public class ManaPotion {
    public String name;
    public int pointsToRecover;

    public ManaPotion(String n, int pTR) {
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
