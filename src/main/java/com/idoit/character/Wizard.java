package com.idoit.character;

import com.idoit.battlefield.Point;
import com.idoit.item.armor.Boots;
import com.idoit.item.armor.Cuirass;
import com.idoit.item.armor.Gloves;
import com.idoit.item.armor.Helmet;
import com.idoit.item.armor.Shield;
import com.idoit.item.bijouterie.belt.IntelligenceBelt;
import com.idoit.item.bijouterie.necklace.IntelligenceNecklace;
import com.idoit.item.bijouterie.ring.IntelligenceRing;
import com.idoit.item.weapon.Staff;

public class Wizard {
    public String name;
    public int hp = 100;
    public int mana = 100;
    public int intelligence = 7;
    public int strength;
    public int agility;
    public int level = 1;
    public int experience = 0;
    public int gold = 100;
    public Staff staff;
    public Helmet helmet;
    public Cuirass cuirass;
    public Gloves gloves;
    public Boots boots;
    public Shield shield;
    public IntelligenceRing leftRing;
    public IntelligenceRing rightRing;
    public IntelligenceBelt belt;
    public IntelligenceNecklace necklace;
    public Point point = new Point(0, 0);

    public Wizard(String n) {
        name = n;
    }

    public void hit(Knight enemy) {
        enemy.hp = enemy.hp - 10;
        staff.durability = staff.durability - 1;
        System.out.println(name + " нанес 10 урона " + enemy.name + ". Теперь у " + enemy.name + " " + enemy.hp + " хп.");
    }

    public void go(int x, int y) {
        point.setXY(x, y);
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public void setHelmet(Helmet helmet) {
        this.helmet = helmet;
    }

    public void setCuirass(Cuirass cuirass) {
        this.cuirass = cuirass;
    }

    public void setGloves(Gloves gloves) {
        this.gloves = gloves;
    }

    public void setBoots(Boots boots) {
        this.boots = boots;
    }

    public void setShield(Shield shield) {
        this.shield = shield;
    }

    public void setLeftRing(IntelligenceRing leftRing) {
        this.leftRing = leftRing;
    }

    public void setRightRing(IntelligenceRing rightRing) {
        this.rightRing = rightRing;
    }

    public void setBelt(IntelligenceBelt belt) {
        this.belt = belt;
    }

    public void setNecklace(IntelligenceNecklace necklace) {
        this.necklace = necklace;
    }
}
