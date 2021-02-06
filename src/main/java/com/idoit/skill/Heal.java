package com.idoit.skill;

public class Heal {
    public int spendsMana;
    public int minLevel;
    public String name;
    public String characterClass;

    public Heal(String n, int sM, int mL) {
        name = n;
        spendsMana = sM;
        minLevel = mL;
    }
}
