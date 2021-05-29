package com.idoit.character;

import com.idoit.battlefield.Point;
import com.idoit.character.npc.NPC;
import com.idoit.character.npc.enemy.Rouge;
import com.idoit.character.npc.seller.Blacksmith;
import com.idoit.item.armor.Boots;
import com.idoit.item.armor.Cuirass;
import com.idoit.item.armor.Gloves;
import com.idoit.item.armor.Helmet;
import com.idoit.item.armor.Shield;
import com.idoit.item.bijouterie.belt.StrengthBelt;
import com.idoit.item.bijouterie.necklace.StrengthNecklace;
import com.idoit.item.bijouterie.ring.StrengthRing;
import com.idoit.item.common.food.Apple;
import com.idoit.item.common.potion.HpPotion;
import com.idoit.item.weapon.Sword;
import com.idoit.profile.Profile;
import com.idoit.quest.Quest;
import com.idoit.skill.Rage;

public class Knight {
    public Profile profile = new Profile();
    public Sword sword;
    public StrengthRing leftRing;
    public StrengthRing rightRing;
    public StrengthBelt belt;
    public StrengthNecklace necklace;
    public Point point = new Point(0, 0);
    public Quest activeQuest;
    public Rage skill;

    public Knight(String name) {
        profile.setName(name);
    }

    public void hit(Knight enemy) {
        int updatedHp = enemy.getProfile().getHp() - profile.getStrength();
        enemy.getProfile().setHp(updatedHp);
        enemy.getProfile().setAlive(enemy.getProfile().getHp() > 0);
        sword.durability = sword.durability - 1;
        profile.setStamina(profile.getStamina() - 10);
        System.out.println(profile.getName() + " нанес " + getProfile().getStrength() + " урона " +
                enemy.getProfile().getName() + ". Теперь у " + enemy.getProfile().getName() + " " +
                enemy.getProfile().getHp() + " хп.");
    }

    public void hit(Rouge rouge) {
        int updatedHp = rouge.getHp() - profile.getStrength();
        rouge.setHp(updatedHp);
        rouge.setAlive(rouge.getHp() > 0);
        sword.durability = sword.durability - 1;
        profile.setStamina(profile.getStamina() - 10);
        System.out.println(profile.getName() + " нанес " + getProfile().getStrength() + " урона " +
                rouge.getName() + ". Теперь у " + rouge.getName() + " " + rouge.getHp() + " хп.");
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

    public void talkTo(Blacksmith blacksmith) {
        blacksmith.fix(this, sword);
    }

    public void addGold(int gold) {
        profile.setGold(profile.getGold() + gold);
    }

    public void addExperience(int exp) {
        profile.setExperience(profile.getExperience() + exp);
    }

    public void drinkHpPotion(HpPotion potion) {
        profile.setHp(profile.getHp() + potion.getPointsToRecover());
    }

    public void eat(Apple apple) {
        profile.setHp(profile.getHp() + apple.getPointsToRecover());
    }

    public void calculatePhysicalDefence() {
        int updatedPhyDefence = profile.getPhysicalDefence() +
                profile.getInventory().getHelmet().getPhysicalDefence() +
                profile.getInventory().getCuirass().getPhysicalDefence() +
                profile.getInventory().getGloves().getPhysicalDefence() +
                profile.getInventory().getBoots().getPhysicalDefence() +
                profile.getInventory().getShield().getPhysicalDefence();
        profile.setPhysicalDefence(updatedPhyDefence);
    }

    private void calculateMagicDefence() {
        int updatedMagicDefence = profile.getMagicDefence() +
                profile.getInventory().getHelmet().getMagicDefence() +
                profile.getInventory().getCuirass().getMagicDefence() +
                profile.getInventory().getGloves().getMagicDefence() +
                profile.getInventory().getBoots().getMagicDefence() +
                profile.getInventory().getShield().getMagicDefence();
        profile.setMagicDefence(updatedMagicDefence);
    }

    private double calculateDistance(Point point) {
        int xDif = point.getX() - this.point.getX();
        int yDif = point.getY() - this.point.getY();
        return Math.sqrt(xDif * xDif + yDif * yDif);
    }

    public void setSword(Sword sword) {
        this.sword = sword;
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

    public void setLeftRing(StrengthRing leftRing) {
        profile.setStrength(profile.getStrength() + leftRing.getPointsToAdd());
        this.leftRing = leftRing;
    }

    public void setRightRing(StrengthRing rightRing) {
        profile.setStrength(profile.getStrength() + rightRing.getPointsToAdd());
        this.rightRing = rightRing;
    }

    public void setBelt(StrengthBelt belt) {
        profile.setStrength(profile.getStrength() + belt.getPointsToAdd());
        this.belt = belt;
    }

    public void setNecklace(StrengthNecklace necklace) {
        profile.setStrength(profile.getStrength() + necklace.getPointsToAdd());
        this.necklace = necklace;
    }

    public void takeOffLeftRing() {
        profile.setStrength(profile.getStrength() - leftRing.getPointsToAdd());
        leftRing = null;
    }

    public void takeOffRightRing() {
        profile.setStrength(profile.getStrength() - rightRing.getPointsToAdd());
        rightRing = null;
    }

    public void takeOffBelt() {
        profile.setStrength(profile.getStrength() - belt.getPointsToAdd());
        belt = null;
    }

    public void takeOffNecklace() {
        profile.setStrength(profile.getStrength() - necklace.getPointsToAdd());
        necklace = null;
    }

    public void setActiveQuest(Quest activeQuest) {
        this.activeQuest = activeQuest;
    }

    public Sword getSword() {
        return sword;
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

    public StrengthRing getLeftRing() {
        return leftRing;
    }

    public StrengthRing getRightRing() {
        return rightRing;
    }

    public StrengthBelt getBelt() {
        return belt;
    }

    public StrengthNecklace getNecklace() {
        return necklace;
    }

    public Point getPoint() {
        return point;
    }

    public Quest getActiveQuest() {
        return activeQuest;
    }

    public Rage getSkill() {
        return skill;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void setSkill(Rage skill) {
        this.skill = skill;
    }
}
