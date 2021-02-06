package com.idoit.skill;

import com.idoit.character.Knight;

public class Rage {
    public int spendsMana;
    public int minLevel;
    public String name;
    public String characterClass = "Knight";

    public Rage(String n, int sM, int mL) {
        name = n;
        spendsMana = sM;
        minLevel = mL;
    }

    public void apply(Knight knight) {
        knight.strength = knight.strength * 2;
        knight.hp = knight.hp - 15;
        knight.mana = knight.mana - spendsMana;
    }
}
