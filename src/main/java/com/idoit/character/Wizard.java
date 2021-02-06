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
import com.idoit.quest.Quest;
import com.idoit.skill.Heal;

public class Wizard {
    public String name;
    public int hp = 100;
    public int mana = 100;
    public int stamina = 100;
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
    public Quest activeQuest;
    public Heal skill;

    public Wizard(String n) {
        name = n;
    }

    public void hit(Knight enemy) {
        enemy.hp = enemy.hp - 10;
        staff.durability = staff.durability - 1;
        stamina = stamina - 10;
        System.out.println(name + " нанес 10 урона " + enemy.name + ". Теперь у " + enemy.name + " " + enemy.hp + " хп.");
    }

    public void castSkill(Knight knight) {
        skill.apply(this, knight);
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

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setLeftRing(IntelligenceRing leftRing) {
        intelligence += leftRing.getPointsToAdd(); // то же, что intelligence  = intelligence + leftRing.getPointsToAdd();
        this.leftRing = leftRing;
    }

    public void setRightRing(IntelligenceRing rightRing) {
        intelligence += rightRing.getPointsToAdd();
        this.rightRing = rightRing;
    }

    public void setBelt(IntelligenceBelt belt) {
        intelligence += belt.getPointsToAdd();
        this.belt = belt;
    }

    public void setNecklace(IntelligenceNecklace necklace) {
        intelligence += necklace.getPointsToAdd();
        this.necklace = necklace;
    }

    public void takeOffLeftRing() {
        intelligence -= leftRing.getPointsToAdd(); // то же, что intelligence = intelligence - leftRing.getPointsToAdd();
        leftRing = null;
    }

    public void takeOffRightRing() {
        intelligence -= rightRing.getPointsToAdd();
        rightRing = null;
    }

    public void takeOffBelt() {
        intelligence -= belt.getPointsToAdd();
        belt = null;
    }

    public void takeOffNecklace() {
        intelligence -= necklace.getPointsToAdd();
        necklace = null;
    }

    public void setActiveQuest(Quest activeQuest) {
        this.activeQuest = activeQuest;
    }

    public void setSkill(Heal skill) {
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getMana() {
        return mana;
    }

    public int getStamina() {
        return stamina;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public int getGold() {
        return gold;
    }

    public Staff getStaff() {
        return staff;
    }

    public Helmet getHelmet() {
        return helmet;
    }

    public Cuirass getCuirass() {
        return cuirass;
    }

    public Gloves getGloves() {
        return gloves;
    }

    public Boots getBoots() {
        return boots;
    }

    public Shield getShield() {
        return shield;
    }

    public IntelligenceRing getLeftRing() {
        return leftRing;
    }

    public IntelligenceRing getRightRing() {
        return rightRing;
    }

    public IntelligenceBelt getBelt() {
        return belt;
    }

    public IntelligenceNecklace getNecklace() {
        return necklace;
    }

    public Point getPoint() {
        return point;
    }

    public Quest getActiveQuest() {
        return activeQuest;
    }

    public Heal getSkill() {
        return skill;
    }
}
