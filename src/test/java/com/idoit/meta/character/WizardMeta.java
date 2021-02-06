package com.idoit.meta.character;

import com.idoit.meta.item.bijouterie.belt.IntelligenceBeltMeta;
import com.idoit.meta.item.bijouterie.necklace.IntelligenceNecklaceMeta;
import com.idoit.meta.item.bijouterie.ring.IntelligenceRingMeta;
import com.idoit.meta.item.weapon.StaffMeta;
import com.idoit.meta.skill.HealMeta;

public class WizardMeta extends CharacterMeta {

    private WizardLook look;

    @Override
    protected Class<? extends Look> getLookClass() {
        return WizardLook.class;
    }

    @Override
    public WizardLook getLook() {
        if (look == null) {
            look = new WizardLook("test");
        }
        return look;
    }

    public void resetLook() {
        look = null;
    }

    public class WizardLook extends CharacterLook {
        private StaffMeta staff;
        private IntelligenceRingMeta leftRing;
        private IntelligenceRingMeta rightRing;
        private IntelligenceBeltMeta belt;
        private IntelligenceNecklaceMeta necklace;
        private HealMeta skill;

        WizardLook(String name) {
            super(name);
        }

        public void castSkill(KnightMeta knight) {
            skill.getLook().apply(WizardMeta.this, knight);
        }

        public StaffMeta getStaff() {
            Object originalStaff = invokeOriginal();
            return (StaffMeta) getMetaFromOriginal(staff, originalStaff);
        }

        public void setStaff(StaffMeta staff) {
            invokeOriginal(staff);
            this.staff = staff;
        }

        public IntelligenceRingMeta getLeftRing() {
            Object originalRing = invokeOriginal();
            return (IntelligenceRingMeta) getMetaFromOriginal(leftRing, originalRing);
        }

        public void setLeftRing(IntelligenceRingMeta leftRing) {
            invokeOriginal(leftRing);
            this.leftRing = leftRing;
        }

        public IntelligenceRingMeta getRightRing() {
            Object originalRing = invokeOriginal();
            return (IntelligenceRingMeta) getMetaFromOriginal(rightRing, originalRing);
        }

        public void setRightRing(IntelligenceRingMeta rightRing) {
            invokeOriginal(rightRing);
            this.rightRing = rightRing;
        }

        public IntelligenceBeltMeta getBelt() {
            Object originalBelt = invokeOriginal();
            return (IntelligenceBeltMeta) getMetaFromOriginal(belt, originalBelt);
        }

        public void setBelt(IntelligenceBeltMeta belt) {
            invokeOriginal(belt);
            this.belt = belt;
        }

        public IntelligenceNecklaceMeta getNecklace() {
            Object originalNecklace = invokeOriginal();
            return (IntelligenceNecklaceMeta) getMetaFromOriginal(necklace, originalNecklace);
        }

        public void setNecklace(IntelligenceNecklaceMeta necklace) {
            invokeOriginal(necklace);
            this.necklace = necklace;
        }

        public HealMeta getSkill() {
            Object originalSkill = invokeOriginal();
            return (HealMeta) getMetaFromOriginal(skill, originalSkill);
        }

        public void setSkill(HealMeta skill) {
            invokeOriginal(skill);
            this.skill = skill;
        }

        public void takeOffLeftRing() {
            invokeOriginal();
            leftRing = null;
        }

        public void takeOffRightRing() {
            invokeOriginal();
            rightRing = null;
        }

        public void takeOffBelt() {
            invokeOriginal();
            belt = null;
        }

        public void takeOffNecklace() {
            invokeOriginal();
            necklace = null;
        }
    }
}
