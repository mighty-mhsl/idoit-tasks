package com.idoit.meta.character.npc.enemy.boss;

import com.idoit.meta.Meta;
import com.idoit.meta.battlefield.PointMeta;
import com.idoit.meta.character.KnightMeta;

import java.util.Arrays;
import java.util.Collections;

public abstract class BossMeta extends Meta {

    BossMeta() {
        defaultConstructorParams = new Object[]{1, 1};
    }

    @Override
    protected Class<? extends Look> getLookClass() {
        return BossLook.class;
    }

    @Override
    public BossLook getLook() {
        return new BossLook(1, 1);
    }

    @Override
    protected void initConstructors() {
        addConstructorForFields(Collections.unmodifiableList(Arrays.asList("level", "damage")));
    }

    public class BossLook extends Look {
        private String name;
        private int level;
        private int damage;
        private int expReward;
        private int goldReward;
        private PointMeta point;

        BossLook(int level, int damage) {
            this.level = level;
            this.damage = damage;
            point = (PointMeta) syncField(PointMeta.class, "point");
        }

        public void hit(KnightMeta knight) {
            invokeOriginal(knight);
        }

        public void go(int x, int y) {
            invokeOriginal(x, y);
        }

        public String getName() {
            return (String) invokeOriginal();
        }

        public void setName(String name) {
            invokeOriginal(name);
        }

        public int getLevel() {
            return (int) invokeOriginal();
        }

        public void setLevel(int level) {
            invokeOriginal(level);
        }

        public int getDamage() {
            return (int) invokeOriginal();
        }

        public void setDamage(int damage) {
            invokeOriginal(damage);
        }

        public int getExpReward() {
            return (int) invokeOriginal();
        }

        public void setExpReward(int expReward) {
            invokeOriginal(expReward);
        }

        public int getGoldReward() {
            return (int) invokeOriginal();
        }

        public void setGoldReward(int goldReward) {
            invokeOriginal(goldReward);
        }

        public PointMeta getPoint() {
            Object originalPoint = invokeOriginal();
            return (PointMeta) getMetaFromOriginal(point, originalPoint);
        }

        public void setPoint(PointMeta point) {
            invokeOriginal(point);
            this.point = point;
        }
    }
}
