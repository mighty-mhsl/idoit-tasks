package com.idoit.item.common.book;

import com.idoit.skill.Heal;

public class HealBook {
    public String name;
    public int minLevel;
    public Heal skill;

    public HealBook(String n, int mL) {
        name = n;
        minLevel = mL;
    }
}
