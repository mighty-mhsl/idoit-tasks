package com.idoit.character.npc;

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

    public void fix(Sword sword) {
        sword.setDurability(100);
    }

    public void fix(Staff staff) {
        staff.setDurability(100);
    }
}
