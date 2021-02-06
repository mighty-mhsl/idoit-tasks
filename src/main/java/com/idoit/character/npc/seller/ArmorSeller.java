package com.idoit.character.npc.seller;

import com.idoit.item.armor.Boots;
import com.idoit.item.armor.Cuirass;
import com.idoit.item.armor.Gloves;
import com.idoit.item.armor.Helmet;
import com.idoit.item.armor.Shield;
import com.idoit.item.special.InitialStone;

public class ArmorSeller {
    public String name;
    public int level;
    public int gold;

    public ArmorSeller(String n, int l) {
        name = n;
        level = l;
    }

    public void fix(Helmet helmet) {
        helmet.setDurability(100);
    }

    public void fix(Cuirass cuirass) {
        cuirass.setDurability(100);
    }

    public void fix(Gloves gloves) {
        gloves.setDurability(100);
    }

    public void fix(Boots boots) {
        boots.setDurability(100);
    }

    public void fix(Shield shield) {
        shield.setDurability(100);
    }

    public void accept(InitialStone stone) {
        level++; //то же, что level = level + 1;
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
