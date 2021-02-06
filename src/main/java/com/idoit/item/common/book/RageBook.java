package com.idoit.item.common.book;

import com.idoit.skill.Rage;

public class RageBook {
    public String name;
    public int minLevel;
    public Rage skill;

    public RageBook(String n, int mL) {
        name = n;
        minLevel = mL;
    }

    public String getName() {
        return name;
    }

    public int getMinLevel() {
        return minLevel;
    }

    public Rage getSkill() {
        return skill;
    }
}
