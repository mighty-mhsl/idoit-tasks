package com.idoit.meta.item.weapon;

import com.idoit.meta.Meta;

import java.util.Arrays;

public abstract class WeaponMeta extends Meta {

    WeaponMeta() {
        defaultConstructorParams = new Object[]{"test", 1};
    }

    @Override
    protected Class<? extends Look> getLookClass() {
        return WeaponLook.class;
    }

    @Override
    public Look getLook() {
        return new WeaponLook("test", 1);
    }

    @Override
    protected void initConstructors() {
        addConstructorForFields(Arrays.asList("name", "damage"));
    }

    public class WeaponLook extends Look {
        private String name;
        private int damage;
        private int durability;

        WeaponLook(String n, int d) {
            name = n;
            damage = d;
        }

        public void setDurability(int durability) {
            invokeOriginal(durability);
            this.durability = durability;
        }

        public String getName() {
            return name;
        }

        public int getDamage() {
            return damage;
        }

        public int getDurability() {
            return (int) invokeOriginal();
        }
    }
}
