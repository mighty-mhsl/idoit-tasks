package com.idoit.meta.profile;

import com.idoit.meta.Meta;

public class ProfileMeta extends Meta {
    public ProfileMeta() throws ClassNotFoundException {
        packageName = BASE_PACKAGE + ".profile";
        className = "Profile";
        initFields();
        initSetters();
        initGetters();
    }

    private void initFields() throws ClassNotFoundException {
        fields.put("name", String.class);
        fields.put("strength", int.class);
        fields.put("agility", int.class);
        fields.put("intelligence", int.class);
        fields.put("hp", int.class);
        fields.put("mana", int.class);
        fields.put("stamina", int.class);
        fields.put("level", int.class);
        fields.put("experience", int.class);
        fields.put("gold", int.class);
        fields.put("physicalDefence", int.class);
        fields.put("magicDefence", int.class);
        fields.put("inventory", new InventoryMeta().getClassFromMeta());
    }

    private void initSetters() throws ClassNotFoundException {
        addMethod(void.class, "setName", String.class);
        addMethod(void.class, "setStrength", int.class);
        addMethod(void.class, "setAgility", int.class);
        addMethod(void.class, "setIntelligence", int.class);
        addMethod(void.class, "setHp", int.class);
        addMethod(void.class, "setMana", int.class);
        addMethod(void.class, "setStamina", int.class);
        addMethod(void.class, "setLevel", int.class);
        addMethod(void.class, "setExperience", int.class);
        addMethod(void.class, "setGold", int.class);
        addMethod(void.class, "setPhysicalDefence", int.class);
        addMethod(void.class, "setMagicDefence", int.class);
        addMethod(void.class, "setInventory", new InventoryMeta().getClassFromMeta());
    }

    private void initGetters() throws ClassNotFoundException {
        addMethod(String.class, "getName");
        addMethod(int.class, "getStrength");
        addMethod(int.class, "getAgility");
        addMethod(int.class, "getIntelligence");
        addMethod(int.class, "getHp");
        addMethod(int.class, "getMana");
        addMethod(int.class, "getStamina");
        addMethod(int.class, "getLevel");
        addMethod(int.class, "getExperience");
        addMethod(int.class, "getGold");
        addMethod(int.class, "getPhysicalDefence");
        addMethod(int.class, "getMagicDefence");
        addMethod(new InventoryMeta().getClassFromMeta(), "getInventory");
    }
}
