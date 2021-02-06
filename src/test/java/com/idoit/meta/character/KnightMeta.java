package com.idoit.meta.character;

import com.idoit.meta.battlefield.PointMeta;
import com.idoit.meta.character.npc.NPCMeta;
import com.idoit.meta.character.npc.seller.BlacksmithMeta;
import com.idoit.meta.item.bijouterie.belt.StrengthBeltMeta;
import com.idoit.meta.item.bijouterie.necklace.StrengthNecklaceMeta;
import com.idoit.meta.item.bijouterie.ring.StrengthRingMeta;
import com.idoit.meta.item.common.potion.HpPotionMeta;
import com.idoit.meta.item.weapon.SwordMeta;
import com.idoit.meta.quest.QuestMeta;
import com.idoit.meta.skill.RageMeta;

public class KnightMeta extends CharacterMeta {

    private KnightLook look;

    @Override
    protected Class<? extends Look> getLookClass() {
        return KnightLook.class;
    }

    @Override
    public KnightLook getLook() {
        if (look == null) {
            look = new KnightLook("test");
        }
        return look;
    }

    public void setLook(KnightLook look) {
        this.look = look;
    }

    public class KnightLook extends CharacterLook {
        private SwordMeta sword;
        private StrengthRingMeta leftRing;
        private StrengthRingMeta rightRing;
        private StrengthBeltMeta belt;
        private StrengthNecklaceMeta necklace;
        private RageMeta skill;
        private QuestMeta activeQuest;

        KnightLook(String name) {
            super(name);
        }

        public void castSkill() {
            skill.getLook().apply(KnightMeta.this);
        }

        public void addGold(int gold) {
            invokeOriginal(gold);
        }

        public void addExperience(int exp) {
            invokeOriginal(exp);
        }

        public void talkTo(NPCMeta npc) {
            invokeOriginal(npc);
            setFieldWithoutOriginalCall("activeQuest", npc.getLook().getQuest());
        }

        public void talkTo(BlacksmithMeta blacksmith) {
            invokeOriginal(blacksmith);
        }

        public void drinkHpPotion(HpPotionMeta potion) {
            invokeOriginal(potion);
        }

        public void calculatePhysicalDefence() {
            invokeOriginal();
        }

        public void calculateMagicDefence() {
            invokeOriginal();
        }

        public double calculateDistance(PointMeta point) {
            return (double) invokeOriginal(point);
        }

        public SwordMeta getSword() {
            Object originalSword = invokeOriginal();
            return (SwordMeta) getMetaFromOriginal(sword, originalSword);
        }

        public void setSword(SwordMeta sword) {
            invokeOriginal(sword);
            this.sword = sword;
        }

        public StrengthRingMeta getLeftRing() {
            Object originalRing = invokeOriginal();
            return (StrengthRingMeta) getMetaFromOriginal(leftRing, originalRing);
        }

        public void setLeftRing(StrengthRingMeta leftRing) {
            invokeOriginal(leftRing);
            this.leftRing = leftRing;
        }

        public StrengthRingMeta getRightRing() {
            Object originalRing = invokeOriginal();
            return (StrengthRingMeta) getMetaFromOriginal(rightRing, originalRing);
        }

        public void setRightRing(StrengthRingMeta rightRing) {
            invokeOriginal(rightRing);
            this.rightRing = rightRing;
        }

        public StrengthBeltMeta getBelt() {
            Object originalBelt = invokeOriginal();
            return (StrengthBeltMeta) getMetaFromOriginal(belt, originalBelt);
        }

        public void setBelt(StrengthBeltMeta belt) {
            invokeOriginal(belt);
            this.belt = belt;
        }

        public StrengthNecklaceMeta getNecklace() {
            Object originalNecklace = invokeOriginal();
            return (StrengthNecklaceMeta) getMetaFromOriginal(necklace, originalNecklace);
        }

        public void setNecklace(StrengthNecklaceMeta necklace) {
            invokeOriginal(necklace);
            this.necklace = necklace;
        }

        public RageMeta getSkill() {
            Object originalSkill = invokeOriginal();
            return (RageMeta) getMetaFromOriginal(skill, originalSkill);
        }

        public void setSkill(RageMeta skill) {
            invokeOriginal(skill);
            this.skill = skill;
        }

        public QuestMeta getActiveQuest() {
            Object originalQuest = invokeOriginal();
            return (QuestMeta) getMetaFromOriginal(activeQuest, originalQuest);
        }

        public void setActiveQuest(QuestMeta activeQuest) {
            invokeOriginal(activeQuest);
            this.activeQuest = activeQuest;
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
