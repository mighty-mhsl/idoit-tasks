package com.idoit.item.common.potion;

public class HpPotion {
    public String name;
    public int pointsToRecover;

    public HpPotion(String n, int pTR) {
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
