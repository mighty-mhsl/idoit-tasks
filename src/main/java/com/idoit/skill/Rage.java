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
        int updatedStrength = knight.getProfile().getStrength() * 2;
        int updateHp = knight.getProfile().getHp() - 15;
        int updatedMana = knight.getProfile().getMana() - spendsMana;
        knight.getProfile().setStrength(updatedStrength);
        knight.getProfile().setHp(updateHp);
        knight.getProfile().setMana(updatedMana);
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
