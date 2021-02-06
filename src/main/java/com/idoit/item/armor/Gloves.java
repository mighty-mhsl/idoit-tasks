package com.idoit.item.armor;

public class Gloves {
    public String name;
    public int physicalDefence;
    public int magicDefence;
    public int durability = 100;
    public String type;

    public Gloves(String n, int pD, int mD) {
        name = n;
        physicalDefence = pD;
        magicDefence = mD;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }
}
