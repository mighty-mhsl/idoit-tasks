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
        int updatedHp = knight.getProfile().getHp() - archer.getBow().getDamage() * 2;
        int updatedMana = archer.getProfile().getMana() - spendsMana;
        knight.getProfile().setHp(updatedHp);
        archer.getProfile().setMana(updatedMana);
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
