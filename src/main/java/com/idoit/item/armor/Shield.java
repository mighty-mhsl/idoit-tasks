package com.idoit.item.armor;

public class Shield {
    public String name;
    public int physicalDefence;
    public int magicDefence;
    public int durability = 100;
    public String type;

    public Shield(String n, int pD, int mD) {
        name = n;
        physicalDefence = pD;
        magicDefence = mD;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public String getName() {
        return name;
    }

    public int getPhysicalDefence() {
        return physicalDefence;
    }

    public int getMagicDefence() {
        return magicDefence;
    }

    public int getDurability() {
        return durability;
    }

    public String getType() {
        return type;
    }
}
