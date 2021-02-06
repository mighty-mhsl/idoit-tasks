package com.idoit.skill;

import com.idoit.character.Knight;
import com.idoit.character.Wizard;

public class Heal {
    public int spendsMana;
    public int minLevel;
    public String name;
    public String characterClass = "Wizard";

    public Heal(String n, int sM, int mL) {
        name = n;
        spendsMana = sM;
        minLevel = mL;
    }

    public void apply(Wizard wizard, Knight knight) {
        knight.hp = knight.hp + 10;
        wizard.mana = wizard.mana - spendsMana;
        System.out.println(knight.name + "was healed and now has " + knight.hp + " hp");
    }
}
