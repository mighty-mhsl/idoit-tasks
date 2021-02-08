package com.idoit.meta.character;

import com.idoit.meta.battlefield.PointMeta;
import com.idoit.meta.item.bijouterie.belt.AgilityBeltMeta;
import com.idoit.meta.item.bijouterie.necklace.AgilityNecklaceMeta;
import com.idoit.meta.item.bijouterie.ring.AgilityRingMeta;
import com.idoit.meta.item.weapon.BowMeta;
import com.idoit.meta.skill.AccurateShotMeta;

public class ArcherMeta extends CharacterMeta {

    private ArcherLook look;

    @Override
    protected Class<? extends Look> getLookClass() {
        return ArcherLook.class;
    }

    @Override
    public ArcherLook getLook() {
        if (look == null) {
            look = new ArcherLook("test");
        }
        return look;
    }

    public class ArcherLook extends CharacterLook {
        private BowMeta bow;
        private AgilityRingMeta leftRing;
        private AgilityRingMeta rightRing;
        private AgilityBeltMeta belt;
        private AgilityNecklaceMeta necklace;
        private AccurateShotMeta skill;

        ArcherLook(String name) {
            super(name);
            point = (PointMeta) syncField(PointMeta.class, "point");
        }

        public void castSkill(KnightMeta knight) {
            skill.getLook().apply(ArcherMeta.this, knight);
        }

        public BowMeta getBow() {
            Object originalBow = invokeOriginal();
            return (BowMeta) getMetaFromOriginal(bow, originalBow);
        }

        public void setBow(BowMeta bow) {
            invokeOriginal(bow);
            this.bow = bow;
        }

        public AgilityRingMeta getLeftRing() {
            Object originalRing = invokeOriginal();
            return (AgilityRingMeta) getMetaFromOriginal(leftRing, originalRing);
        }

        public void setLeftRing(AgilityRingMeta leftRing) {
            invokeOriginal(leftRing);
            this.leftRing = leftRing;
        }

        public AgilityRingMeta getRightRing() {
            Object originalRing = invokeOriginal();
            return (AgilityRingMeta) getMetaFromOriginal(rightRing, originalRing);
        }

        public void setRightRing(AgilityRingMeta rightRing) {
            invokeOriginal(rightRing);
            this.rightRing = rightRing;
        }

        public AgilityBeltMeta getBelt() {
            Object originalBelt = invokeOriginal();
            return (AgilityBeltMeta) getMetaFromOriginal(belt, originalBelt);
        }

        public void setBelt(AgilityBeltMeta belt) {
            invokeOriginal(belt);
            this.belt = belt;
        }

        public AgilityNecklaceMeta getNecklace() {
            Object originalNecklace = invokeOriginal();
            return (AgilityNecklaceMeta) getMetaFromOriginal(necklace, originalNecklace);
        }

        public void setNecklace(AgilityNecklaceMeta necklace) {
            invokeOriginal(necklace);
            this.necklace = necklace;
        }

        public AccurateShotMeta getSkill() {
            Object originalSkill = invokeOriginal();
            return (AccurateShotMeta) getMetaFromOriginal(skill, originalSkill);
        }

        public void setSkill(AccurateShotMeta skill) {
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
