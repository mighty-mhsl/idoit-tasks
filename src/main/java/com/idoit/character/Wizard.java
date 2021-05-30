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
import com.idoit.item.common.food.Apple;
import com.idoit.item.weapon.Staff;
import com.idoit.profile.Profile;
import com.idoit.quest.Quest;
import com.idoit.skill.Heal;

public class Wizard {
    public Profile profile = new Profile();
    public Staff staff;
    public IntelligenceRing leftRing;
    public IntelligenceRing rightRing;
    public IntelligenceBelt belt;
    public IntelligenceNecklace necklace;
    public Point point = new Point(0, 0);
    public Quest activeQuest;
    public Heal skill;

    public Wizard(String name) {
        profile.setName(name);
    }

    public void hit(Knight enemy) {
        Profile enemyProfile = enemy.getProfile();
        int updatedHp = enemyProfile.getHp() - profile.getStrength();
        enemyProfile.setHp(updatedHp);
        enemyProfile.setAlive(enemyProfile.getHp() > 0);
        staff.durability = staff.durability - 1;
        profile.setStamina(profile.getStamina() - 10);
        System.out.println(profile.getName() + " нанес " + profile.getStrength() + " урона " +
                enemyProfile.getName() + ". Теперь у " + enemyProfile.getName() + " " +
                enemyProfile.getHp() + " хп.");
    }

    public void castSkill(Knight knight) {
        skill.apply(this, knight);
    }

    public void go(int x, int y) {
        point.setXY(x, y);
    }

    public void eat(Apple apple) {
        profile.setHp(profile.getHp() + apple.getPointsToRecover());
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public void setHelmet(Helmet helmet) {
        profile.getInventory().setHelmet(helmet);
    }

    public void setCuirass(Cuirass cuirass) {
        profile.getInventory().setCuirass(cuirass);
    }

    public void setGloves(Gloves gloves) {
        profile.getInventory().setGloves(gloves);
    }

    public void setBoots(Boots boots) {
        profile.getInventory().setBoots(boots);
    }

    public void setShield(Shield shield) {
        profile.getInventory().setShield(shield);
    }

    public void setLeftRing(IntelligenceRing leftRing) {
        profile.setIntelligence(profile.getIntelligence() + leftRing.getPointsToAdd());
        this.leftRing = leftRing;
    }

    public void setRightRing(IntelligenceRing rightRing) {
        profile.setIntelligence(profile.getIntelligence() + rightRing.getPointsToAdd());
        this.rightRing = rightRing;
    }

    public void setBelt(IntelligenceBelt belt) {
        profile.setIntelligence(profile.getIntelligence() + belt.getPointsToAdd());
        this.belt = belt;
    }

    public void setNecklace(IntelligenceNecklace necklace) {
        profile.setIntelligence(profile.getIntelligence() + necklace.getPointsToAdd());
        this.necklace = necklace;
    }

    public void takeOffLeftRing() {
        profile.setIntelligence(profile.getIntelligence() - leftRing.getPointsToAdd());
        leftRing = null;
    }

    public void takeOffRightRing() {
        profile.setIntelligence(profile.getIntelligence() - rightRing.getPointsToAdd());
        rightRing = null;
    }

    public void takeOffBelt() {
        profile.setIntelligence(profile.getIntelligence() - belt.getPointsToAdd());
        belt = null;
    }

    public void takeOffNecklace() {
        profile.setIntelligence(profile.getIntelligence() - necklace.getPointsToAdd());
        necklace = null;
    }

    public void setActiveQuest(Quest activeQuest) {
        this.activeQuest = activeQuest;
    }

    public Staff getStaff() {
        return staff;
    }

    public Helmet getHelmet() {
        return profile.getInventory().getHelmet();
    }

    public Cuirass getCuirass() {
        return profile.getInventory().getCuirass();
    }

    public Gloves getGloves() {
        return profile.getInventory().getGloves();
    }

    public Boots getBoots() {
        return profile.getInventory().getBoots();
    }

    public Shield getShield() {
        return profile.getInventory().getShield();
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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void setSkill(Heal skill) {
        this.skill = skill;
    }
}
