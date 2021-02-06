package com.idoit.skill;

import com.idoit.character.Archer;
import com.idoit.character.Knight;

public class AccurateShot {
    public int spendsMana;
    public int minLevel;
    public String name;
    public String characterClass = "Archer";

    public AccurateShot(String n, int sM, int mL) {
        name = n;
        spendsMana = sM;
        minLevel = mL;
    }

    public void apply(Archer archer, Knight knight) {
        knight.hp = knight.hp - archer.bow.damage * 2;
    }
}
