package com.idoit.meta.character;

import com.idoit.meta.Meta;
import com.idoit.meta.battlefield.PointMeta;
import com.idoit.meta.item.armor.BootsMeta;
import com.idoit.meta.item.armor.CuirassMeta;
import com.idoit.meta.item.armor.GlovesMeta;
import com.idoit.meta.item.armor.HelmetMeta;
import com.idoit.meta.item.armor.ShieldMeta;
import com.idoit.meta.item.common.food.AppleMeta;
import com.idoit.meta.profile.ProfileMeta;
import com.idoit.meta.quest.QuestMeta;

import java.util.HashMap;
import java.util.Map;

public abstract class CharacterMeta extends Meta {

    CharacterMeta() {
        defaultConstructorParams = new Object[]{"test"};
    }

    @Override
    protected Class<? extends Look> getLookClass() {
        return CharacterLook.class;
    }

    @Override
    public Look getLook() {
        return new CharacterLook("test");
    }

    @Override
    protected void initConstructors() {
        Map<String, Class<?>> constructor = new HashMap<>();
        constructor.put("name", String.class);
        addConstructorWithParams(constructor);
    }

    public class CharacterLook extends Look {
        private ProfileMeta profile;
        private PointMeta point;
        private QuestMeta activeQuest;

        CharacterLook(String name) {
            point = (PointMeta) syncField(PointMeta.class, "point");
            saved = point.originalInstance;
        }

        public void hit(KnightMeta enemy) {
            invokeOriginal(enemy);
        }

        public void go(int x, int y) {
            invokeOriginal(x, y);
        }

        public void eat(AppleMeta apple) {
            invokeOriginal(apple);
        }

        public ProfileMeta getProfile() {
            Object originalProfile = invokeOriginal();
            return (ProfileMeta) getMetaFromOriginal(profile, originalProfile);
        }

        public void setProfile(ProfileMeta profile) {
            invokeOriginal(profile);
            this.profile = profile;
        }

        public QuestMeta getActiveQuest() {
            Object originalQuest = invokeOriginal();
            return (QuestMeta) getMetaFromOriginal(activeQuest, originalQuest);
        }

        public void setActiveQuest(QuestMeta activeQuest) {
            invokeOriginal(activeQuest);
            this.activeQuest = activeQuest;
        }

        public PointMeta getPoint() {
            Object originalPoint = invokeOriginal();
            return (PointMeta) getMetaFromOriginal(point, originalPoint);
        }

        public void setHelmet(HelmetMeta helmet) {
            invokeOriginal(helmet);
            profile.getLook().getInventory().getLook().setFieldWithoutOriginalCall("helmet", helmet);
        }

        public void setCuirass(CuirassMeta cuirass) {
            invokeOriginal(cuirass);
            profile.getLook().getInventory().getLook().setFieldWithoutOriginalCall("cuirass", cuirass);
        }

        public void setGloves(GlovesMeta gloves) {
            invokeOriginal(gloves);
            profile.getLook().getInventory().getLook().setFieldWithoutOriginalCall("gloves", gloves);
        }

        public void setBoots(BootsMeta boots) {
            invokeOriginal(boots);
            profile.getLook().getInventory().getLook().setFieldWithoutOriginalCall("boots", boots);
        }

        public void setShield(ShieldMeta shield) {
            invokeOriginal(shield);
            profile.getLook().getInventory().getLook().setFieldWithoutOriginalCall("shield", shield);
        }

        public HelmetMeta getHelmet() {
            Object originalHelmet = invokeOriginal();
            HelmetMeta meta = profile.getLook().getInventory().getLook().getHelmet();
            return (HelmetMeta) getMetaFromOriginal(meta, originalHelmet);
        }

        public CuirassMeta getCuirass() {
            Object originalCuirass = invokeOriginal();
            CuirassMeta meta = profile.getLook().getInventory().getLook().getCuirass();
            return (CuirassMeta) getMetaFromOriginal(meta, originalCuirass);
        }

        public GlovesMeta getGloves() {
            Object originalGloves = invokeOriginal();
            GlovesMeta meta = profile.getLook().getInventory().getLook().getGloves();
            return (GlovesMeta) getMetaFromOriginal(meta, originalGloves);
        }

        public BootsMeta getBoots() {
            Object originalBoots = invokeOriginal();
            BootsMeta meta = profile.getLook().getInventory().getLook().getBoots();
            return (BootsMeta) getMetaFromOriginal(meta, originalBoots);
        }

        public ShieldMeta getShield() {
            Object originalShield = invokeOriginal();
            ShieldMeta meta = profile.getLook().getInventory().getLook().getShield();
            return (ShieldMeta) getMetaFromOriginal(meta, originalShield);
        }
    }
}
