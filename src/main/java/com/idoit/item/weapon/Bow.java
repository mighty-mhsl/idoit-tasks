package com.idoit.item.weapon;

public class Bow {
    public String name;
    public int damage;
    public int durability = 100;

    public Bow(String n, int d) {
        name = n;
        damage = d;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }
}
