package com.idoit.item.weapon;

public class Sword {
    public String name;
    public int damage;
    public int durability = 100;

    public Sword(String n, int d) {
        name = n;
        damage = d;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }
}
