package com.idoit.meta.item.armor;

import com.idoit.meta.Meta;

import java.util.Arrays;

public abstract class ArmorMeta extends Meta {

    public ArmorMeta() {
        defaultConstructorParams = new Object[] {"test", 1, 2};
    }

    @Override
    protected Class<? extends Look> getLookClass() {
        return ArmorLook.class;
    }

    @Override
    public ArmorLook getLook() {
        return new ArmorLook("test", 1, 2);
    }

    @Override
    protected void initConstructors() {
        addConstructorForFields(Arrays.asList("name", "physicalDefence", "magicDefence"));
    }

    public class ArmorLook extends Look {
        private String name;
        private int physicalDefence;
        private int magicDefence;
        private int durability;
        private String type;

        ArmorLook(String n, int pD, int mD) {
            name = n;
            physicalDefence = pD;
            magicDefence = mD;
        }

        public void setDurability(int durability) {
            invokeOriginal(durability);
            this.durability = durability;
        }

        public String getName() {
            return name;
        }

        public int getPhysicalDefence() {
            return physicalDefence;
        }

        public int getMagicDefence() {
            return magicDefence;
        }

        public int getDurability() {
            return (int) invokeOriginal();
        }

        public String getType() {
            return type;
        }
    }
}
