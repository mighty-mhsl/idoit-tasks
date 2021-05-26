package com.idoit.character;

import com.idoit.battlefield.Point;
import com.idoit.character.npc.enemy.Skeleton;
import com.idoit.item.armor.Boots;
import com.idoit.item.armor.Cuirass;
import com.idoit.item.armor.Gloves;
import com.idoit.item.armor.Helmet;
import com.idoit.item.armor.Shield;
import com.idoit.item.bijouterie.belt.AgilityBelt;
import com.idoit.item.bijouterie.necklace.AgilityNecklace;
import com.idoit.item.bijouterie.ring.AgilityRing;
import com.idoit.item.common.food.Apple;
import com.idoit.item.weapon.Bow;
import com.idoit.profile.Profile;
import com.idoit.quest.Quest;
import com.idoit.skill.AccurateShot;

public class Archer {
    public Profile profile = new Profile();
    public Bow bow;
    public AgilityRing leftRing;
    public AgilityRing rightRing;
    public AgilityBelt belt;
    public AgilityNecklace necklace;
    public Point point = new Point(0, 0);
    public Quest activeQuest;
    public AccurateShot skill;

    public Archer(String name) {
        profile.setName(name);
    }

    public void hit(Knight enemy) {
        int updatedHp = enemy.getProfile().getHp() - getProfile().getStrength();
        enemy.getProfile().setHp(updatedHp);
        enemy.getProfile().setAlive(enemy.getProfile().getHp() > 0);
        bow.durability = bow.durability - 1;
        profile.setStamina(profile.getStamina() - 10);
        System.out.println(profile.getName() + " нанес " + getProfile().getStrength() + " урона " +
                enemy.getProfile().getName() + ". Теперь у " + enemy.getProfile().getName() + " " +
                enemy.getProfile().getHp() + " хп.");
    }

    public void hitSkeleton(Skeleton skeleton) {
        int updatedHp = skeleton.getHp() - getProfile().getStrength();
        skeleton.setHp(updatedHp);
        skeleton.setAlive(skeleton.getHp() > 0);
        bow.durability = bow.durability - 1;
        profile.setStamina(profile.getStamina() - 10);
        System.out.println(profile.getName() + " нанес " + getProfile().getStrength() + " урона " +
                skeleton.getName() + ". Теперь у " + skeleton.getName() + " " + skeleton.getHp() + " хп.");
    }

    public void castSkill(Knight enemy) {
        skill.apply(this, enemy);
    }

    public void go(int x, int y) {
        point.setXY(x, y);
    }

    public void eat(Apple apple) {
        profile.setHp(profile.getHp() + apple.getPointsToRecover());
    }

    public void setBow(Bow bow) {
        this.bow = bow;
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

    public void setLeftRing(AgilityRing leftRing) {
        profile.setAgility(profile.getAgility() + leftRing.getPointsToAdd());
        this.leftRing = leftRing;
    }

    public void setRightRing(AgilityRing rightRing) {
        profile.setAgility(profile.getAgility() + rightRing.getPointsToAdd());
        this.rightRing = rightRing;
    }

    public void setBelt(AgilityBelt belt) {
        profile.setAgility(profile.getAgility() + belt.getPointsToAdd());
        this.belt = belt;
    }

    public void setNecklace(AgilityNecklace necklace) {
        profile.setAgility(profile.getAgility() + necklace.getPointsToAdd());
        this.necklace = necklace;
    }

    public void takeOffLeftRing() {
        profile.setAgility(profile.getAgility() - leftRing.getPointsToAdd());
        leftRing = null;
    }

    public void takeOffRightRing() {
        profile.setAgility(profile.getAgility() - rightRing.getPointsToAdd());
        rightRing = null;
    }

    public void takeOffBelt() {
        profile.setAgility(profile.getAgility() - belt.getPointsToAdd());
        belt = null;
    }

    public void takeOffNecklace() {
        profile.setAgility(profile.getAgility() - necklace.getPointsToAdd());
        necklace = null;
    }

    public void setActiveQuest(Quest activeQuest) {
        this.activeQuest = activeQuest;
    }

    public Bow getBow() {
        return bow;
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

    public AgilityRing getLeftRing() {
        return leftRing;
    }

    public AgilityRing getRightRing() {
        return rightRing;
    }

    public AgilityBelt getBelt() {
        return belt;
    }

    public AgilityNecklace getNecklace() {
        return necklace;
    }

    public Point getPoint() {
        return point;
    }

    public Quest getActiveQuest() {
        return activeQuest;
    }

    public AccurateShot getSkill() {
        return skill;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void setSkill(AccurateShot skill) {
        this.skill = skill;
    }
}
