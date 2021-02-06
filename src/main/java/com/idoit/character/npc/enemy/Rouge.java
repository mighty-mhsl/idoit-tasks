package com.idoit.character.npc.enemy;

import com.idoit.battlefield.Point;
import com.idoit.character.Knight;

public class Rouge {
    public String name = "Rouge";
    public int level;
    public int hp;
    public int expReward;
    public int goldReward;
    public int damage;
    public Point point = new Point(0, 0);

    public Rouge(int level, int damage) {
        this.level = level;
        this.damage = damage;
    }

    public void hit(Knight knight) {
        knight.hp = knight.hp - damage;
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
}
