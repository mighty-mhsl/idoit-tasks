package com.idoit.meta.profile;

import com.idoit.meta.Meta;
import com.idoit.meta.item.armor.BootsMeta;
import com.idoit.meta.item.armor.CuirassMeta;
import com.idoit.meta.item.armor.GlovesMeta;
import com.idoit.meta.item.armor.HelmetMeta;
import com.idoit.meta.item.armor.ShieldMeta;
import com.idoit.meta.item.common.BagMeta;

public class InventoryMeta extends Meta {
    public InventoryMeta() throws ClassNotFoundException {
        packageName = BASE_PACKAGE + ".profile";
        className = "Inventory";
        initFields();
        initSetters();
        initGetters();
    }

    private void initFields() throws ClassNotFoundException {
        fields.put("helmet", new HelmetMeta().getClassFromMeta());
        fields.put("cuirass", new CuirassMeta().getClassFromMeta());
        fields.put("gloves", new GlovesMeta().getClassFromMeta());
        fields.put("boots", new BootsMeta().getClassFromMeta());
        fields.put("shield", new ShieldMeta().getClassFromMeta());
        fields.put("bag", new BagMeta().getClassFromMeta());
    }

    private void initSetters() throws ClassNotFoundException {
        addMethod(void.class, "setHelmet", new HelmetMeta().getClassFromMeta());
        addMethod(void.class, "setCuirass", new CuirassMeta().getClassFromMeta());
        addMethod(void.class, "setGloves", new GlovesMeta().getClassFromMeta());
        addMethod(void.class, "setBoots", new BootsMeta().getClassFromMeta());
        addMethod(void.class, "setShield", new ShieldMeta().getClassFromMeta());
        addMethod(void.class, "setBag", new BagMeta().getClassFromMeta());
    }

    private void initGetters() throws ClassNotFoundException {
        addMethod(new HelmetMeta().getClassFromMeta(), "getHelmet");
        addMethod(new CuirassMeta().getClassFromMeta(), "getCuirass");
        addMethod(new GlovesMeta().getClassFromMeta(), "getGloves");
        addMethod(new BootsMeta().getClassFromMeta(), "getBoots");
        addMethod(new ShieldMeta().getClassFromMeta(), "getShield");
        addMethod(new BagMeta().getClassFromMeta(), "getBag");
    }
}
