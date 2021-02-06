package com.idoit.character;

import com.idoit.battlefield.Point;
import com.idoit.character.npc.NPC;
import com.idoit.item.armor.Boots;
import com.idoit.item.armor.Cuirass;
import com.idoit.item.armor.Gloves;
import com.idoit.item.armor.Helmet;
import com.idoit.item.armor.Shield;
import com.idoit.item.bijouterie.belt.StrengthBelt;
import com.idoit.item.bijouterie.necklace.StrengthNecklace;
import com.idoit.item.bijouterie.ring.StrengthRing;
import com.idoit.item.weapon.Sword;
import com.idoit.quest.Quest;
import com.idoit.skill.Rage;

public class Knight {
    public String name;
    public int strength = 7;
    public int agility;
    public int intelligence;
    public int hp = 100;
    public int mana = 100;
    public int stamina = 100;
    public int level = 1;
    public int experience = 0;
    public int gold = 100;
    public int physicalDefence;
    public int magicDefence;
    public Sword sword;
    public Helmet helmet;
    public Cuirass cuirass;
    public Gloves gloves;
    public Boots boots;
    public Shield shield;
    public StrengthRing leftRing;
    public StrengthRing rightRing;
    public StrengthBelt belt;
    public StrengthNecklace necklace;
    public Point point = new Point(0, 0);
    public Quest activeQuest;
    public Rage skill;

    public Knight(String n) {
        name = n;
    }

    public void hit(Knight enemy) {
        enemy.hp = enemy.hp - 10;
        sword.durability = sword.durability - 1;
        stamina = stamina - 10;
        System.out.println(name + " нанес 10 урона " + enemy.name + ". Теперь у " + enemy.name + " " + enemy.hp + " хп.");
    }

    public void castSkill() {
        skill.apply(this);
    }

    public void go(int x, int y) {
        point.setXY(x, y);
    }

    public void talkTo(NPC npc) {
        npc.giveQuest(this);
    }

    public void addGold(int gold) {
        this.gold = this.gold + gold;
    }

    public void addExperience(int exp) {
        this.experience = this.experience + exp;
    }

    public void calculatePhysicalDefence() {
        physicalDefence = physicalDefence + helmet.physicalDefence + cuirass.physicalDefence + gloves.physicalDefence + boots.physicalDefence + shield.physicalDefence;
    }

    private void calculateMagicDefence() {
        magicDefence = magicDefence + helmet.magicDefence + cuirass.magicDefence + gloves.magicDefence + boots.magicDefence + shield.magicDefence;
    }

    public void setSword(Sword sword) {
        this.sword = sword;
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

    public void setLeftRing(StrengthRing leftRing) {
        this.leftRing = leftRing;
    }

    public void setRightRing(StrengthRing rightRing) {
        this.rightRing = rightRing;
    }

    public void setBelt(StrengthBelt belt) {
        this.belt = belt;
    }

    public void setNecklace(StrengthNecklace necklace) {
        this.necklace = necklace;
    }

    public void setActiveQuest(Quest activeQuest) {
        this.activeQuest = activeQuest;
    }
}
