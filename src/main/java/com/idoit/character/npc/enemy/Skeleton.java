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

    public Skeleton(int level, int damage) {
        this.level = level;
        this.damage = damage;
    }

    public void hit(Knight knight) {
        knight.hp = knight.hp - damage;
    }

    public void go(int x, int y) {
        point.setXY(x, y);
    }
}
