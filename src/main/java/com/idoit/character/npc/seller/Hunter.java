package com.idoit.character.npc.seller;

import com.idoit.item.weapon.Bow;

public class Hunter {
    public String name;
    public int level;
    public int gold;

    public Hunter(String n, int l) {
        name = n;
        level = l;
    }

    public void fix(Bow bow) {
        bow.setDurability(100);
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
