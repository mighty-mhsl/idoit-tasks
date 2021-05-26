package com.idoit.character.npc.enemy;

import com.idoit.battlefield.Point;
import com.idoit.character.Knight;

public class Skeleton {
    public String name = "Skeleton";
    public int level;
    public int hp;
    public int expReward;
    public int goldReward;
    public int damage;
    public Point point = new Point(0, 0);
    public boolean alive = true;

    public Skeleton(int level, int damage) {
        this.level = level;
        this.damage = damage;
    }

    public void hit(Knight knight) {
        int updatedHp = knight.getProfile().getHp() - damage;
        knight.getProfile().setHp(updatedHp);
        knight.getProfile().setHpCritical(knight.getProfile().getHp() <= knight.getProfile().getCriticalHp());
        knight.getProfile().setAlive(knight.getProfile().getHp() > 0);
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

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
