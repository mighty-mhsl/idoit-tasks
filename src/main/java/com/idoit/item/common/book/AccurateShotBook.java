package com.idoit.item.common.book;

import com.idoit.skill.AccurateShot;

public class AccurateShotBook {
    public String name;
    public int minLevel;
    public AccurateShot skill;

    public AccurateShotBook(String n, int mL) {
        name = n;
        minLevel = mL;
    }

    public String getName() {
        return name;
    }

    public int getMinLevel() {
        return minLevel;
    }

    public AccurateShot getSkill() {
        return skill;
    }
}
