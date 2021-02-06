package com.idoit.item.weapon;

import com.idoit.item.stone.DamageStone;

public class Sword {
    public String name;
    public int damage;
    public int durability = 100;
    public DamageStone stone;

    public Sword(String n, int d) {
        name = n;
        damage = d;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getDurability() {
        return durability;
    }

    public DamageStone getStone() {
        return stone;
    }

    public void setStone(DamageStone stone) {
        this.stone = stone;
    }
}
