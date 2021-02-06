package com.idoit.item.bijouterie.necklace;

public class StrengthNecklace {
    public String name;
    public int pointsToAdd;

    public StrengthNecklace(String n, int pTA) {
        name = n;
        pointsToAdd = pTA;
    }

    public String getName() {
        return name;
    }

    public int getPointsToAdd() {
        return pointsToAdd;
    }
}
