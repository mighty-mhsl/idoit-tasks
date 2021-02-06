package com.idoit.character;

import com.idoit.battlefield.Point;
import com.idoit.item.armor.Boots;
import com.idoit.item.armor.Cuirass;
import com.idoit.item.armor.Gloves;
import com.idoit.item.armor.Helmet;
import com.idoit.item.armor.Shield;
import com.idoit.item.bijouterie.belt.AgilityBelt;
import com.idoit.item.bijouterie.necklace.AgilityNecklace;
import com.idoit.item.bijouterie.ring.AgilityRing;
import com.idoit.item.weapon.Bow;
import com.idoit.quest.Quest;
import com.idoit.skill.AccurateShot;

public class Archer {
    public String name;
    public int hp = 100;
    public int mana = 100;
    public int stamina = 100;
    public int agility = 7;
    public int strength;
    public int intelligence;
    public int level = 1;
    public int experience = 0;
    public int gold = 100;
    public Bow bow;
    public Helmet helmet;
    public Cuirass cuirass;
    public Gloves gloves;
    public Boots boots;
    public Shield shield;
    public AgilityRing leftRing;
    public AgilityRing rightRing;
    public AgilityBelt belt;
    public AgilityNecklace necklace;
    public Point point = new Point(0, 0);
    public Quest activeQuest;
    public AccurateShot skill;

    public Archer(String n) {
        name = n;
    }

    public void hit(Knight enemy) {
        enemy.hp = enemy.hp - 10;
        bow.durability = bow.durability - 1;
        stamina = stamina - 10;
        System.out.println(name + " нанес 10 урона " + enemy.name + ". Теперь у " + enemy.name + " " + enemy.hp + " хп.");
    }

    public void castSkill(Knight enemy) {
        skill.apply(this, enemy);
    }

    public void go(int x, int y) {
        point.setXY(x, y);
    }

    public void setBow(Bow bow) {
        this.bow = bow;
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

    public void setLeftRing(AgilityRing leftRing) {
        this.leftRing = leftRing;
    }

    public void setRightRing(AgilityRing rightRing) {
        this.rightRing = rightRing;
    }

    public void setBelt(AgilityBelt belt) {
        this.belt = belt;
    }

    public void setNecklace(AgilityNecklace necklace) {
        this.necklace = necklace;
    }

    public void setActiveQuest(Quest activeQuest) {
        this.activeQuest = activeQuest;
    }

    public void setSkill(AccurateShot skill) {
        this.skill = skill;
    }
}
