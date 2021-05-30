package com.idoit.character.npc.enemy.boss;

import com.idoit.battlefield.Point;
import com.idoit.character.Knight;
import com.idoit.profile.Profile;

public class AncientSkeleton {
    public String name;
    public int level;
    public int damage;
    public int expReward;
    public int goldReward;
    public Point point;
    public boolean alive = true;

    public AncientSkeleton(int level, int damage) {
        this.level = level;
        this.damage = damage;
    }

    public void hit(Knight knight) {
        Profile knightProfile = knight.getProfile();
        int updatedHp = knightProfile.getHp() - damage;
        knightProfile.setHp(updatedHp);
        boolean hpCritical = knightProfile.getHp() <= knightProfile.getCriticalHp();
        knightProfile.setHpCritical(hpCritical);
        knightProfile.setAlive(knightProfile.getHp() > 0);
    }

    public void go(int x, int y) {
        point.setXY(x, y);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getExpReward() {
        return expReward;
    }

    public void setExpReward(int expReward) {
        this.expReward = expReward;
    }

    public int getGoldReward() {
        return goldReward;
    }

    public void setGoldReward(int goldReward) {
        this.goldReward = goldReward;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
