package com.idoit.item.bijouterie.belt;

public class AgilityBelt {
    public String name;
    public int pointsToAdd;

    public AgilityBelt(String n, int pTA) {
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
