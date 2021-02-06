package com.idoit.item.weapon;

import com.idoit.item.stone.CriticalHitStone;

public class Bow {
    public String name;
    public int damage;
    public int durability = 100;
    public CriticalHitStone stone;

    public Bow(String n, int d) {
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

    public CriticalHitStone getStone() {
        return stone;
    }

    public void setStone(CriticalHitStone stone) {
        this.stone = stone;
    }
}
