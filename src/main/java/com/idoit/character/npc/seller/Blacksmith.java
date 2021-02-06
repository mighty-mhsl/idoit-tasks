package com.idoit.character.npc.seller;

import com.idoit.character.Knight;
import com.idoit.character.Wizard;
import com.idoit.item.special.IgniteHammer;
import com.idoit.item.stone.CriticalHitStone;
import com.idoit.item.stone.DamageStone;
import com.idoit.item.stone.HealStone;
import com.idoit.item.weapon.Bow;
import com.idoit.item.weapon.Staff;
import com.idoit.item.weapon.Sword;

public class Blacksmith {
    public String name;
    public int level;
    public int gold;

    public Blacksmith(String n, int l) {
        name = n;
        level = l;
    }

    public void fix(Knight knight, Sword sword) {
        sword.setDurability(100);
        knight.setGold(knight.getGold() - 20);
    }

    public void fix(Wizard wizard, Staff staff) {
        staff.setDurability(100);
        wizard.setGold(wizard.getGold() - 20);
    }

    public void accept(IgniteHammer hammer) {
        level++; //то же, что level = level + 1;
    }

    public void insertStoneToWeapon(Sword sword, DamageStone stone) {
        sword.setStone(stone);
    }

    public void insertStoneToWeapon(Staff staff, HealStone stone) {
        staff.setStone(stone);
    }

    public void insertStoneToWeapon(Bow bow, CriticalHitStone stone) {
        bow.setStone(stone);
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getGold() {
        return gold;
    }
}
