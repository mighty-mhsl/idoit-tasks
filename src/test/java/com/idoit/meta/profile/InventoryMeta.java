package com.idoit.meta.profile;

import com.idoit.meta.Meta;
import com.idoit.meta.item.armor.BootsMeta;
import com.idoit.meta.item.armor.CuirassMeta;
import com.idoit.meta.item.armor.GlovesMeta;
import com.idoit.meta.item.armor.HelmetMeta;
import com.idoit.meta.item.armor.ShieldMeta;
import com.idoit.meta.item.common.BagMeta;

public class InventoryMeta extends Meta {

    private InventoryLook look;

    @Override
    protected Class<? extends Look> getLookClass() {
        return InventoryLook.class;
    }

    @Override
    public InventoryLook getLook() {
        if (look == null) {
            look = new InventoryLook();
        }
        return look;
    }

    public class InventoryLook extends Look {
        private HelmetMeta helmet;
        private CuirassMeta cuirass;
        private GlovesMeta gloves;
        private BootsMeta boots;
        private ShieldMeta shield;
        private BagMeta bag;

        public HelmetMeta getHelmet() {
            Object originalHelmet = invokeOriginal();
            return (HelmetMeta) getMetaFromOriginal(helmet, originalHelmet);
        }

        public void setHelmet(HelmetMeta helmet) {
            invokeOriginal(helmet);
            this.helmet = helmet;
        }

        public CuirassMeta getCuirass() {
            Object originalCuirass = invokeOriginal();
            return (CuirassMeta) getMetaFromOriginal(cuirass, originalCuirass);
        }

        public void setCuirass(CuirassMeta cuirass) {
            invokeOriginal(cuirass);
            this.cuirass = cuirass;
        }

        public GlovesMeta getGloves() {
            Object originalGloves = invokeOriginal();
            return (GlovesMeta) getMetaFromOriginal(gloves, originalGloves);
        }

        public void setGloves(GlovesMeta gloves) {
            invokeOriginal(gloves);
            this.gloves = gloves;
        }

        public BootsMeta getBoots() {
            Object originalBoots = invokeOriginal();
            return (BootsMeta) getMetaFromOriginal(boots, originalBoots);
        }

        public void setBoots(BootsMeta boots) {
            invokeOriginal(boots);
            this.boots = boots;
        }

        public ShieldMeta getShield() {
            Object originalShield = invokeOriginal();
            return (ShieldMeta) getMetaFromOriginal(shield, originalShield);
        }

        public void setShield(ShieldMeta shield) {
            invokeOriginal(shield);
            this.shield = shield;
        }

        public BagMeta getBag() {
            Object originalBag = invokeOriginal();
            return (BagMeta) getMetaFromOriginal(bag, originalBag);
        }

        public void setBag(BagMeta bag) {
            invokeOriginal(bag);
            this.bag = bag;
        }
    }
}
