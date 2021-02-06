package com.idoit.item.weapon;

import com.idoit.item.stone.HealStone;

public class Staff {
    public String name;
    public int damage;
    public int durability = 100;
    public HealStone stone;

    public Staff(String n, int d) {
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

    public HealStone getStone() {
        return stone;
    }

    public void setStone(HealStone stone) {
        this.stone = stone;
    }
}
