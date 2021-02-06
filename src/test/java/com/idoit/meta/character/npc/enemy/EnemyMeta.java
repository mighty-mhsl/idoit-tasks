package com.idoit.meta.character.npc.enemy;

import com.idoit.meta.Meta;
import com.idoit.meta.battlefield.PointMeta;
import com.idoit.meta.character.KnightMeta;

import java.util.Arrays;

public abstract class EnemyMeta extends Meta {

    EnemyMeta() {
        defaultConstructorParams = new Object[]{1, 2};
    }

    @Override
    protected Class<? extends Look> getLookClass() {
        return EnemyLook.class;
    }

    @Override
    public EnemyLook getLook() {
        return new EnemyLook(1, 2);
    }

    @Override
    protected void initConstructors() {
        addConstructorForFields(Arrays.asList("level", "damage"));
    }

    public class EnemyLook extends Look {
        private String name;
        private int level;
        private int hp;
        private int expReward;
        private int goldReward;
        private int damage;
        private PointMeta point;

        EnemyLook(int level, int damage) {
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

        public int getLevel() {
            return (int) invokeOriginal();
        }

        public int getHp() {
            return (int) invokeOriginal();
        }

        public int getExpReward() {
            return (int) invokeOriginal();
        }

        public int getGoldReward() {
            return (int) invokeOriginal();
        }

        public int getDamage() {
            return (int) invokeOriginal();
        }

        public PointMeta getPoint() {
            Object originalPoint = invokeOriginal();
            return (PointMeta) getMetaFromOriginal(point, originalPoint);
        }
    }
}
