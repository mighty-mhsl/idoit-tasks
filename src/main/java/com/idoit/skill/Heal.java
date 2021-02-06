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
        int updatedHp = knight.getProfile().getHp() + 10;
        knight.getProfile().setHp(updatedHp);
        int updatedMana = wizard.getProfile().getMana() - spendsMana;
        wizard.getProfile().setMana(updatedMana);
        System.out.println(knight.getProfile().getName() + "was healed and now has " + knight.getProfile().getHp() + " hp");
    }

    public int getSpendsMana() {
        return spendsMana;
    }

    public int getMinLevel() {
        return minLevel;
    }

    public String getName() {
        return name;
    }

    public String getCharacterClass() {
        return characterClass;
    }
}
