package com.idoit.item.bijouterie.ring;

public class StrengthRing {
    public String name;
    public int pointsToAdd;

    public StrengthRing(String n, int pTA) {
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
