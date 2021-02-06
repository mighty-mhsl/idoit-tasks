package com.idoit.character;

import com.idoit.meta.Meta;
import com.idoit.meta.MetaContext;
import com.idoit.meta.battlefield.PointMeta;
import com.idoit.meta.character.KnightMeta;
import com.idoit.meta.character.npc.NpcMeta;
import com.idoit.meta.character.npc.seller.BlacksmithMeta;
import com.idoit.meta.item.armor.BootsMeta;
import com.idoit.meta.item.armor.CuirassMeta;
import com.idoit.meta.item.armor.GlovesMeta;
import com.idoit.meta.item.armor.HelmetMeta;
import com.idoit.meta.item.armor.ShieldMeta;
import com.idoit.meta.item.bijouterie.belt.StrengthBeltMeta;
import com.idoit.meta.item.bijouterie.necklace.StrengthNecklaceMeta;
import com.idoit.meta.item.bijouterie.ring.StrengthRingMeta;
import com.idoit.meta.item.common.potion.HpPotionMeta;
import com.idoit.meta.item.weapon.SwordMeta;
import com.idoit.meta.profile.ProfileMeta;
import com.idoit.meta.quest.QuestMeta;
import com.idoit.meta.skill.RageMeta;
import com.idoit.safe.Safer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты логики в классе Knight")
class KnightTest extends CharacterTest {

    @BeforeEach
	void setUp() {
        setMeta(KnightMeta.class);
    }

    @DisplayName("Тест, что класс Knight находится в пакете com.idoit.character")
    @Test
    void testKnightIsInCharacterPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Knight имеет все необходимые поля")
    @Test
    void testKnightHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе Knight есть конструктор принимающий имя персонажа")
    @Test
    void testKnightHasConstructorWithNameParam() {
        testClassHasConstructors();
        testConstructorSetsValuesToProfile();
    }

    @DisplayName("Тест, что в классе Knight есть все необходимые методы")
    @Test
    void testKnightHasAllMethods() {
        testClassHasAllMethods();
    }

    @DisplayName("Тест, что метод hit в классе Knight уменьшает хп противника на 10")
    @Test
    void testHitDecreasesEnemyHp() {
        Meta swordMeta = MetaContext.getMeta(SwordMeta.class);
        testHitDamagesEnemy(swordMeta, "setSword");
    }

    @DisplayName("Тест, что метод hit в классе Knight уменьшает прочность оружия на 1")
    @Test
    void testHitDecreasesWeaponDurability() {
        Meta swordMeta = MetaContext.getMeta(SwordMeta.class);
        testHitDamagesWeapon(swordMeta, "setSword", "sword");
    }

    @DisplayName("Тест, что метод hit в классе Knight уменьшает выносливость персонажа на 10")
    @Test
    void testHitDecreasesStamina() {
        Meta swordMeta = MetaContext.getMeta(SwordMeta.class);
        testHitDecreasesStamina(swordMeta, "setSword");
    }

    @DisplayName("Тест, что метод go в классе Knight меняет координаты точки персонажа")
    @Test
    void testGoChangesPointCoordinates() {
        testGo(CONSTRUCTOR_PARAM);
    }

    @DisplayName("Тест, что метод setSword в классе Knight сохраняет переданный Sword в поле класса")
    @Test
    void testSetSwordSavesSwordToField() {
        String methodName = "setSword";
        Meta valueMeta = MetaContext.getMeta(SwordMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetWeapon(valueMeta, methodName, "sword", message);
    }

    @DisplayName("Тест, что метод setHelmet в классе Knight сохраняет полученный Helmet в инвентарь")
    @Test
    void testSetHelmetSavesHelmetToInventory() {
        String methodName = "setHelmet";
        Meta valueMeta = MetaContext.getMeta(HelmetMeta.class);
        testSetArmor(valueMeta, methodName, "helmet");
    }

    @DisplayName("Тест, что метод setCuirass в классе Knight сохраняет полученный Cuirass в инвентарь")
    @Test
    void testSetCuirassSavesCuirassToInventory() {
        String methodName = "setCuirass";
        Meta valueMeta = MetaContext.getMeta(CuirassMeta.class);
        testSetArmor(valueMeta, methodName, "cuirass");
    }

    @DisplayName("Тест, что метод setGloves в классе Knight сохраняет полученный Gloves в инвентарь")
    @Test
    void testSetGlovesSavesGlovesToInventory() {
        String methodName = "setGloves";
        Meta valueMeta = MetaContext.getMeta(GlovesMeta.class);
        testSetArmor(valueMeta, methodName, "gloves");
    }

    @DisplayName("Тест, что метод setBoots в классе Knight сохраняет полученный Boots в инвентарь")
    @Test
    void testSetBootsSavesBootsToInventory() {
        String methodName = "setBoots";
        Meta valueMeta = MetaContext.getMeta(BootsMeta.class);
        testSetArmor(valueMeta, methodName, "boots");
    }

    @DisplayName("Тест, что метод setShield в классе Knight сохраняет полученный Shield в инвентарь")
    @Test
    void testSetShieldSavesShieldToInventory() {
        String methodName = "setShield";
        Meta valueMeta = MetaContext.getMeta(ShieldMeta.class);
        testSetArmor(valueMeta, methodName, "shield");
    }

    @DisplayName("Тест, что метод setLeftRing в классе Knight сохраняет полученный StrengthRing в поле класса")
    @Test
    void testSetLeftRingSavesStrengthRingToField() {
        String methodName = "setLeftRing";
        Meta valueMeta = MetaContext.getMeta(StrengthRingMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetBijouterie(valueMeta, methodName, "leftRing", message);
    }

    @DisplayName("Тест, что метод setLeftRing в классе Knight добавляет очки кольца к соответствующей характеристике персонажа")
    @Test
    void testSetLeftRingAddsPoints() {
        testBijouterieAddsPoints("setLeftRing", "strength", StrengthRingMeta.class);
    }

    @DisplayName("Тест, что метод setRightRing в классе Knight сохраняет полученный StrengthRing в поле класса")
    @Test
    void testSetRightRingSavesStrengthRingToField() {
        String methodName = "setRightRing";
        Meta valueMeta = MetaContext.getMeta(StrengthRingMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetBijouterie(valueMeta, methodName, "rightRing", message);
    }

    @DisplayName("Тест, что метод setRightRing в классе Knight добавляет очки кольца к соответствующей характеристике персонажа")
    @Test
    void testSetRightRingAddsPoints() {
        testBijouterieAddsPoints("setRightRing", "strength", StrengthRingMeta.class);
    }

    @DisplayName("Тест, что метод setBelt в классе Knight сохраняет полученный StrengthBelt в поле класса")
    @Test
    void testSetBeltSavesStrengthBeltToField() {
        String methodName = "setBelt";
        Meta valueMeta = MetaContext.getMeta(StrengthBeltMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetBijouterie(valueMeta, methodName, "belt", message);
    }

    @DisplayName("Тест, что метод setBelt в классе Knight добавляет очки кольца к соответствующей характеристике персонажа")
    @Test
    void testSetBeltAddsPoints() {
        testBijouterieAddsPoints("setBelt", "strength", StrengthBeltMeta.class);
    }

    @DisplayName("Тест, что метод setNecklace в классе Knight сохраняет полученный StrengthNecklace в поле класса")
    @Test
    void testSetNecklaceSavesStrengthNecklaceToField() {
        String methodName = "setNecklace";
        Meta valueMeta = MetaContext.getMeta(StrengthNecklaceMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetBijouterie(valueMeta, methodName, "necklace", message);
    }

    @DisplayName("Тест, что метод setNecklace в классе Knight добавляет очки кольца к соответствующей характеристике персонажа")
    @Test
    void testSetNecklaceAddsPoints() {
        testBijouterieAddsPoints("setNecklace", "strength", StrengthNecklaceMeta.class);
    }

    @DisplayName("Тест, что метод setActiveQuest в классе Knight сохраняет переданный Quest в поле класса")
    @Test
    void testSetActiveQuestSavesQuestToField() {
        Object[] questConstructor = new Object[] {"test1", "test2", 1, 2, 3};
        testSetterWithMetaParam(QuestMeta.class, questConstructor, "setActiveQuest", "activeQuest", "test");
    }

    @DisplayName("Тест, что метод setSkill в классе Knight сохраняет переданный Rage в поле класса")
    @Test
    void testSetSkillSavesSkillToField() {
        Object[] rageConstructor = new Object[]{"test", 1, 1};
        testSetterWithMetaParam(RageMeta.class, rageConstructor, "setSkill", "skill", "test");
    }

    @DisplayName("Тест, что метод takeOffLeftRing в классе Knight снимает левое кольцо")
    @Test
    void testTakeOffLeftRing() {
        testTakeOffRemovesBijouterie("takeOffLeftRing", "setLeftRing", "leftRing", StrengthRingMeta.class);
    }

    @DisplayName("Тест, что метод takeOffLeftRing в классе Knight отнимает от соответствующей характиристике количество очков предмета")
    @Test
    void testTakeOffLeftRingDecreasesCharacteristic() {
        testTakeOffDecreasesCharacteristic("takeOffLeftRing", "setLeftRing", "strength", StrengthRingMeta.class);
    }

    @DisplayName("Тест, что метод takeOffRightRing в классе Knight снимает левое кольцо")
    @Test
    void testTakeOffRightRing() {
        testTakeOffRemovesBijouterie("takeOffRightRing", "setRightRing", "rightRing", StrengthRingMeta.class);
    }

    @DisplayName("Тест, что метод takeOffRightRing в классе Knight отнимает от соответствующей характиристике количество очков предмета")
    @Test
    void testTakeOffRightRingDecreasesCharacteristic() {
        testTakeOffDecreasesCharacteristic("takeOffRightRing", "setRightRing", "strength", StrengthRingMeta.class);
    }

    @DisplayName("Тест, что метод takeOffBelt в классе Knight снимает левое кольцо")
    @Test
    void testTakeOffBelt() {
        testTakeOffRemovesBijouterie("takeOffBelt", "setBelt", "belt", StrengthBeltMeta.class);
    }

    @DisplayName("Тест, что метод takeOffBelt в классе Knight отнимает от соответствующей характиристике количество очков предмета")
    @Test
    void testTakeOffBeltDecreasesCharacteristic() {
        testTakeOffDecreasesCharacteristic("takeOffBelt", "setBelt", "strength", StrengthBeltMeta.class);
    }

    @DisplayName("Тест, что метод takeOffNecklace в классе Knight снимает левое кольцо")
    @Test
    void testTakeOffNecklace() {
        testTakeOffRemovesBijouterie("takeOffNecklace", "setNecklace", "necklace", StrengthNecklaceMeta.class);
    }

    @DisplayName("Тест, что метод takeOffNecklace в классе Knight отнимает от соответствующей характиристике количество очков предмета")
    @Test
    void testTakeOffNecklaceDecreasesCharacteristic() {
        testTakeOffDecreasesCharacteristic("takeOffNecklace", "setNecklace", "strength", StrengthNecklaceMeta.class);
    }

    @DisplayName("Тест, что метод getHelmet в классе Knight возвращает шлем персонажа")
    @Test
    void testGetHelmet() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(HelmetMeta.class).instantiateObjectWithConstructor("test", 1, 2);
            testGetter("getHelmet", "setHelmet", param, CONSTRUCTOR_PARAM);
        });
    }

    @DisplayName("Тест, что метод getCuirass в классе Knight возвращает кирасу персонажа")
    @Test
    void testGetCuirass() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(CuirassMeta.class).instantiateObjectWithConstructor("test", 1, 2);
            testGetter("getCuirass", "setCuirass", param, CONSTRUCTOR_PARAM);
        });
    }

    @DisplayName("Тест, что метод getGloves в классе Knight возвращает перчатки персонажа")
    @Test
    void testGetGloves() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(GlovesMeta.class).instantiateObjectWithConstructor("test", 1, 2);
            testGetter("getGloves", "setGloves", param, CONSTRUCTOR_PARAM);
        });
    }

    @DisplayName("Тест, что метод getBoots в классе Knight возвращает сапоги персонажа")
    @Test
    void testGetBoots() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(BootsMeta.class).instantiateObjectWithConstructor("test", 1, 2);
            testGetter("getBoots", "setBoots", param, CONSTRUCTOR_PARAM);
        });
    }

    @DisplayName("Тест, что метод getShield в классе Knight возвращает щит персонажа")
    @Test
    void testGetShield() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(ShieldMeta.class).instantiateObjectWithConstructor("test", 1, 2);
            testGetter("getShield", "setShield", param, CONSTRUCTOR_PARAM);
        });
    }

    @DisplayName("Тест, что метод getPoint в классе Knight возвращает точку персонажа")
    @Test
    void testGetPoint() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(PointMeta.class).instantiateObjectWithConstructor(1, 2);
            testGetter("getPoint", "setPoint", param, CONSTRUCTOR_PARAM);
        });
    }

    @DisplayName("Тест, что метод getActiveQuest в классе Knight возвращает задание персонажа")
    @Test
    void testGetActiveQuest() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(QuestMeta.class).instantiateObjectWithConstructor("t", "u", 1, 2, 3);
            testGetter("getActiveQuest", "setActiveQuest", param, CONSTRUCTOR_PARAM);
        });
    }

    @DisplayName("Тест, что метод getSword в классе Knight возвращает оружие персонажа")
    @Test
    void testGetSword() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(SwordMeta.class).instantiateObjectWithConstructor("test", 1);
            testGetter("getSword", "setSword", param, CONSTRUCTOR_PARAM);
        });
    }

    @DisplayName("Тест, что метод getLeftRing в классе Knight возвращает левое кольцо персонажа")
    @Test
    void testGetLeftRing() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(StrengthRingMeta.class).instantiateObjectWithConstructor("test", 1);
            testGetter("getLeftRing", "setLeftRing", param, CONSTRUCTOR_PARAM);
        });
    }

    @DisplayName("Тест, что метод getRightRing в классе Knight возвращает правое кольцо персонажа")
    @Test
    void testGetRightRing() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(StrengthRingMeta.class).instantiateObjectWithConstructor("test", 1);
            testGetter("getRightRing", "setRightRing", param, CONSTRUCTOR_PARAM);
        });
    }

    @DisplayName("Тест, что метод getBelt в классе Knight возвращает ремень персонажа")
    @Test
    void testGetBelt() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(StrengthBeltMeta.class).instantiateObjectWithConstructor("test", 1);
            testGetter("getBelt", "setBelt", param, CONSTRUCTOR_PARAM);
        });
    }

    @DisplayName("Тест, что метод getNecklace в классе Knight возвращает ожерелье персонажа")
    @Test
    void testGetNecklace() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(StrengthNecklaceMeta.class).instantiateObjectWithConstructor("test", 1);
            testGetter("getNecklace", "setNecklace", param, CONSTRUCTOR_PARAM);
        });
    }

    @DisplayName("Тест, что метод getSkill в классе Knight возвращает навык персонажа")
    @Test
    void testGetSkill() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(RageMeta.class).instantiateObjectWithConstructor("test", 1, 2);
            testGetter("getSkill", "setSkill", param, CONSTRUCTOR_PARAM);
        });
    }

    @DisplayName("Тест, что метод setProfile в классе Wizard сохраняет профиль персонажа в поле класса")
    @Test
    void testSetProfile() {
        testSetterWithMetaParam(ProfileMeta.class, new Object[]{}, "setProfile", "profile", CONSTRUCTOR_PARAM);
    }

    @DisplayName("Тест, что метод getProfile в классе Wizard возвращает профиль персонажа")
    @Test
    void testGetProfile() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(ProfileMeta.class).instantiateObjectWithConstructor();
            testGetter("getProfile", "setProfile", param, CONSTRUCTOR_PARAM);
        });
    }

    @DisplayName("Тест, что метод addGold в классе Knight добавляет переданное количество золота к текущему")
    @Test
    void testAddGold() {
        testAddMethod("addGold", "gold", 100);
    }

    @DisplayName("Тест, что метод addExperience в классе Knight добавляет переданное количество опыта к текущему")
    @Test
    void testAddExperience() {
        testAddMethod("addExperience", "experience", 0);
    }

    @DisplayName("Тест, что метод talkTo в классе Knight добавляет рыцарю задание от переданного NPC")
    @Test
    void testTalkTo() {
        Safer.runSafe(() -> {
            String methodName = "talkTo";
            Object knight = getMeta().instantiateObjectWithConstructor(CONSTRUCTOR_PARAM);
            Object npc = Meta.instantiateObjectFromMeta(NpcMeta.class,"test", 1);
            Object expectedQuest = setFieldForObjectAndGet(npc, "setQuest", QuestMeta.class, "name", "desc", 1, 2, 3);

            BiConsumer<Object, Object[]> talkToAssert = (obj, params) -> {
                Safer.runSafe(() -> {
                    String fieldName = "activeQuest";
                    Object activeQuest = getFieldValue(knight, fieldName);
                    String message = getFieldValueAssert(getMeta().getClassName(), methodName, fieldName, expectedQuest, activeQuest);
                    assertEquals(expectedQuest, activeQuest, message);
                });
            };

            testClassMethod(talkToAssert, knight, "talkTo", npc);
        });
    }

    @DisplayName("Тест, что метод calculatePhysicalDefence в классе Knight рассчитывает общую защиту для значения поля physicalDefence для всей брони")
    @Test
    void testCalculatePhysicalDefence() {
        testCalculate("calculatePhysicalDefence", "physicalDefence", 25);
    }

    @DisplayName("Тест, что метод calculateMagicDefence в классе Knight рассчитывает общую защиту для значения поля magicDefence для всей брони")
    @Test
    void testCalculateMagicDefence() {
        testCalculate("calculateMagicDefence", "magicDefence", 30);
    }

    @DisplayName("Тест, что метод castSkill в классе Knight применяет Rage к себе")
    @Test
    void testCastSkill() {
        Safer.runSafe(() -> {
            Object knight = getMeta().instantiateObjectWithConstructor(CONSTRUCTOR_PARAM);
            setFieldForObjectAndGet(knight, "setSkill", RageMeta.class, "test", 10, 1);
            Object profile = getProfile(knight);
            setValue(profile, "setStrength", 7);

            BiConsumer<Object, Object[]> castAssert = (obj, params) -> Safer.runSafe(() -> {
                int expectedHp = 85;
                int expectedMana = 90;
                int expectedStrength = 14;
                String className = getMeta().getClassName();
                String methodName = "castSkill";
                String hpFieldName = "hp";
                String manaFieldName = "mana";
                String strengthFieldName = "strength";
                Object actualHp = getFieldValue(profile, hpFieldName);
                Object actualMana = getFieldValue(profile, manaFieldName);
                Object actualStrength = getFieldValue(profile, strengthFieldName);
                String hpMessage = getFieldValueAssert(className, methodName, hpFieldName, expectedHp, actualHp);
                String manaMessage = getFieldValueAssert(className, methodName, manaFieldName, expectedMana, actualMana);
                String strengthMessage = getFieldValueAssert(className, methodName, strengthFieldName, expectedStrength, actualStrength);
                assertEquals(expectedHp, actualHp, hpMessage);
                assertEquals(expectedMana, actualMana, manaMessage);
                assertEquals(expectedStrength, actualStrength, strengthMessage);
            });

            testClassMethod(castAssert, knight, "castSkill");
        });
    }

    @DisplayName("Тест, что метод calculateDistance в классе Knight вычисляет расстояние между персонажем и переданной точкой")
    @Test
    void testCalculateDistance() {
        Safer.runSafe(() -> {
            String methodName = "calculateDistance";
            Object knight = getMeta().instantiateObjectWithConstructor(CONSTRUCTOR_PARAM);
            Meta pointMeta = MetaContext.getMeta(PointMeta.class);
            int x = 3, y = 3;
            double expectedDistance = Math.sqrt(x * x + y * y);
            Object point = pointMeta.instantiateObjectWithConstructor(x, y);
            Object actualDistance = callClassMethodAndReturnResult(knight, methodName, point);
            String message = getMethodReturnResultAssertMessage(methodName, expectedDistance, actualDistance);
            assertEquals(expectedDistance, actualDistance, message);
        });
    }

    @DisplayName("Тест, что метод drinkHpPotion в классе Knight добавляет к здоровью персонажа количество очков переданного зелья")
    @Test
    void testDrinkHpPotion() {
        Safer.runSafe(() -> {
            String methodName = "drinkHpPotion";
            Object knight = getMeta().instantiateObjectWithConstructor(CONSTRUCTOR_PARAM);
            int pointsToRecover = 10;

            BiConsumer<Object, Object[]> drinkAssert = (obj, params) -> Safer.runSafe(() -> {
                String fieldName = "hp";
                int expectedHp = 100 + pointsToRecover;
                Object profile = getProfile(obj);
                Object actualHp = getFieldValue(profile, fieldName);
                String message = getFieldValueAssert(getMeta().getClassName(), methodName, fieldName, expectedHp, actualHp);
                assertEquals(expectedHp, actualHp, message);
            });

            Meta potionMeta = MetaContext.getMeta(HpPotionMeta.class);
            Object potion = potionMeta.instantiateObjectWithConstructor("test", pointsToRecover);
            testClassMethod(drinkAssert, knight, methodName, potion);
        });
    }

    @DisplayName("Тест, что метод talkTo в классе Knight отдает оружие рыцаря на починку кузнецу")
    @Test
    void testTalkToBlacksmith() {
        Safer.runSafe(() -> {
            String methodName = "talkTo";
            Object knight = getMeta().instantiateObjectWithConstructor(CONSTRUCTOR_PARAM);
            setFieldForObjectAndGet(knight, "setSword", SwordMeta.class, "sword", 10);

            BiConsumer<Object, Object[]> talkToAssert = (obj, params) -> Safer.runSafe(() -> {
                Object sword = getFieldValue(obj, "sword");
                String durabilityFieldName = "durability";
                Object actualDurability = getFieldValue(sword, durabilityFieldName);
                String durabilityMessage = getFieldValueAssert(getMeta().getClassName(), methodName, durabilityFieldName, 100, actualDurability);
                assertEquals(100, actualDurability, durabilityMessage);

                int expectedGold = 80;
                String goldFieldName = "gold";
                Object profile = getProfile(obj);
                Object actualGold = getFieldValue(profile, goldFieldName);
                String goldMessage = getFieldValueAssert(getMeta().getClassName(), methodName, goldFieldName, expectedGold, actualGold);
                assertEquals(expectedGold, actualGold, goldMessage);
            });

            Meta blacksmithMeta = MetaContext.getMeta(BlacksmithMeta.class);
            Object blacksmith = blacksmithMeta.instantiateObjectWithConstructor("test", 1);
            testClassMethod(talkToAssert, knight, "talkTo", blacksmith);
        });
    }

    @DisplayName("Тест, что метод eat в классе Knight добавляет здоровье в количестве очков восстановления яблока")
    @Test
    void testEatMethod() {
        testEat();
    }

    private void testCalculate(String methodName, String fieldName, int expectedDef) {
        Safer.runSafe(() -> {
            Object knight = getMeta().instantiateObjectWithConstructor(CONSTRUCTOR_PARAM);
            setFieldForObjectAndGet(knight, "setHelmet", HelmetMeta.class, "test", 5, 6);
            setFieldForObjectAndGet(knight, "setCuirass", CuirassMeta.class, "test", 5, 6);
            setFieldForObjectAndGet(knight, "setGloves", GlovesMeta.class, "test", 5, 6);
            setFieldForObjectAndGet(knight, "setBoots", BootsMeta.class, "test", 5, 6);
            setFieldForObjectAndGet(knight, "setShield", ShieldMeta.class, "test", 5, 6);

            BiConsumer<Object, Object[]> calculateAssert = (obj, params) -> Safer.runSafe(() -> {
                String profileFieldName = "profile";
                Object profile = getFieldValue(obj, profileFieldName);
                Object actualDef = getFieldValue(profile, fieldName);
                String message = getFieldValueAssert(getMeta().getClassName(), methodName, fieldName, expectedDef, actualDef);
                assertEquals(expectedDef, actualDef, message);
            });

            testClassMethod(calculateAssert, knight, methodName);
        });
    }

    private void testAddMethod(String methodName, String fieldName, int defaultValue) {
        Safer.runSafe(() -> {
            Object knight = getMeta().instantiateObjectWithConstructor("test");
            int added = 10;

            BiConsumer<Object, Object[]> addAssert = (obj, params) -> Safer.runSafe(() -> {
                Object profile = getProfile(knight);
                int actualValue = (int) getFieldValue(profile, fieldName);
                int expectedValue = defaultValue + added;
                String message = getFieldValueAssert(getMeta().getClassName(), methodName, fieldName, expectedValue, actualValue);
                assertEquals(expectedValue, actualValue, message);
            });

            testClassMethod(addAssert, knight, methodName, added);
        });
    }
}
