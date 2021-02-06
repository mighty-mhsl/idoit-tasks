package com.idoit.meta.profile;

import com.idoit.meta.Meta;

public class ProfileMeta extends Meta {

    private ProfileLook look;

    @Override
    protected Class<? extends Look> getLookClass() {
        return ProfileLook.class;
    }

    @Override
    public ProfileLook getLook() {
        if (look == null) {
            look = new ProfileLook();
        }
        return look;
    }

    public class ProfileLook extends Look {
        private String name;
        private int strength;
        private int agility;
        private int intelligence;
        private int hp = 100;
        private int mana = 100;
        private int stamina = 100;
        private int level = 1;
        private int experience = 0;
        private int gold = 100;
        private int physicalDefence;
        private int magicDefence;
        private InventoryMeta inventory;

        public String getName() {
            return (String) invokeOriginal();
        }

        public void setName(String name) {
            invokeOriginal(name);
        }

        public int getStrength() {
            return (int) invokeOriginal();
        }

        public void setStrength(int strength) {
            invokeOriginal(strength);
        }

        public int getAgility() {
            return (int) invokeOriginal();
        }

        public void setAgility(int agility) {
            invokeOriginal(agility);
        }

        public int getIntelligence() {
            return (int) invokeOriginal();
        }

        public void setIntelligence(int intelligence) {
            invokeOriginal(intelligence);
        }

        public int getHp() {
            return (int) invokeOriginal();
        }

        public void setHp(int hp) {
            invokeOriginal(hp);
        }

        public int getMana() {
            return (int) invokeOriginal();
        }

        public void setMana(int mana) {
            invokeOriginal(mana);
        }

        public int getStamina() {
            return (int) invokeOriginal();
        }

        public void setStamina(int stamina) {
            invokeOriginal(stamina);
        }

        public int getLevel() {
            return (int) invokeOriginal();
        }

        public void setLevel(int level) {
            invokeOriginal(level);
        }

        public int getExperience() {
            return (int) invokeOriginal();
        }

        public void setExperience(int experience) {
            invokeOriginal(experience);
        }

        public int getGold() {
            return (int) invokeOriginal();
        }

        public void setGold(int gold) {
            invokeOriginal(gold);
        }

        public int getPhysicalDefence() {
            return (int) invokeOriginal();
        }

        public void setPhysicalDefence(int physicalDefence) {
            invokeOriginal(physicalDefence);
        }

        public int getMagicDefence() {
            return (int) invokeOriginal();
        }

        public void setMagicDefence(int magicDefence) {
            invokeOriginal(magicDefence);
        }

        public InventoryMeta getInventory() {
            Object originalInventory = invokeOriginal();
            return (InventoryMeta) getMetaFromOriginal(inventory, originalInventory);
        }

        public void setInventory(InventoryMeta inventory) {
            invokeOriginal(inventory);
            this.inventory = inventory;
        }
    }
}
