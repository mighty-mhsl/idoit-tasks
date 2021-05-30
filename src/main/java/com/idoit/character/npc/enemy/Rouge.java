package com.idoit.character.npc.enemy;

import com.idoit.battlefield.Point;
import com.idoit.character.Knight;
import com.idoit.profile.Profile;

public class Rouge {
    public String name = "Rouge";
    public int level;
    public int hp;
    public int expReward;
    public int goldReward;
    public int damage;
    public Point point = new Point(0, 0);
    public boolean alive = true;

    public Rouge(int level, int damage) {
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

    public int getLevel() {
        return level;
    }

    public int getHp() {
        return hp;
    }

    public int getExpReward() {
        return expReward;
    }

    public int getGoldReward() {
        return goldReward;
    }

    public int getDamage() {
        return damage;
    }

    public Point getPoint() {
        return point;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
