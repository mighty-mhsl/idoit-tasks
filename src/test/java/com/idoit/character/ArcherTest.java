package com.idoit.character;

import com.idoit.meta.Meta;
import com.idoit.meta.MetaContext;
import com.idoit.meta.battlefield.PointMeta;
import com.idoit.meta.character.ArcherMeta;
import com.idoit.meta.character.KnightMeta;
import com.idoit.meta.item.armor.BootsMeta;
import com.idoit.meta.item.armor.CuirassMeta;
import com.idoit.meta.item.armor.GlovesMeta;
import com.idoit.meta.item.armor.HelmetMeta;
import com.idoit.meta.item.armor.ShieldMeta;
import com.idoit.meta.item.bijouterie.belt.AgilityBeltMeta;
import com.idoit.meta.item.bijouterie.necklace.AgilityNecklaceMeta;
import com.idoit.meta.item.bijouterie.ring.AgilityRingMeta;
import com.idoit.meta.item.weapon.BowMeta;
import com.idoit.meta.quest.QuestMeta;
import com.idoit.meta.skill.AccurateShotMeta;
import com.idoit.safe.Safer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты логики в классе Archer")
class ArcherTest extends CharacterTest {

    @BeforeEach
	void setUp() {
        setMeta(ArcherMeta.class);
    }

    @DisplayName("Тест, что класс Archer находится в пакете com.idoit.character")
    @Test
    void testArcherIsInCharacterPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Archer имеет все необходимые поля")
    @Test
    void testArcherHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе Archer есть конструктор принимающий имя персонажа")
    @Test
    void testArcherHasConstructorWithNameParam() {
        testClassHasConstructors();
        testConstructorSetsValueToFields("test");
    }

    @DisplayName("Тест, что в классе Archer есть все необходимые методы")
    @Test
    void testArcherHasAllMethods() {
        testClassHasAllMethods();
    }

    @DisplayName("Тест, что метод hit в классе Archer уменьшает хп противника на 10")
    @Test
    void testHitDecreasesEnemyHp() {
        Meta bowMeta = MetaContext.getMeta(BowMeta.class);
        testHitDamagesEnemy(bowMeta, "setBow");
    }

    @DisplayName("Тест, что метод hit в классе Archer уменьшает прочность оружия на 1")
    @Test
    void testHitDecreasesWeaponDurability() {
        Meta bowMeta = MetaContext.getMeta(BowMeta.class);
        testHitDamagesWeapon(bowMeta, "setBow", "bow");
    }

    @DisplayName("Тест, что метод hit в классе Archer уменьшает выносливость персонажа на 10")
    @Test
    void testHitDecreasesStamina() {
        Meta bowMeta = MetaContext.getMeta(BowMeta.class);
        testHitDecreasesStamina(bowMeta, "setBow");
    }

    @DisplayName("Тест, что метод go в классе Archer меняет координаты точки персонажа")
    @Test
    void testGoChangesPointCoordinates() {
        testGo(CONSTRUCTOR_PARAM);
    }

    @DisplayName("Тест, что метод setBow в классе Archer сохраняет переданный Bow в поле класса")
    @Test
    void testSetBowSavesBowToField() {
        String methodName = "setBow";
        Meta valueMeta = MetaContext.getMeta(BowMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetWeapon(valueMeta, methodName, "bow", message);
    }

    @DisplayName("Тест, что метод setHelmet в классе Archer сохраняет полученный Helmet в поле класса")
    @Test
    void testSetHelmetSavesHelmetToField() {
        String methodName = "setHelmet";
        Meta valueMeta = MetaContext.getMeta(HelmetMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetArmor(valueMeta, methodName, "helmet", message);
    }

    @DisplayName("Тест, что метод setCuirass в классе Archer сохраняет полученный Cuirass в поле класса")
    @Test
    void testSetCuirassSavesCuirassToField() {
        String methodName = "setCuirass";
        Meta valueMeta = MetaContext.getMeta(CuirassMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetArmor(valueMeta, methodName, "cuirass", message);
    }

    @DisplayName("Тест, что метод setGloves в классе Archer сохраняет полученный Gloves в поле класса")
    @Test
    void testSetGlovesSavesGlovesToField() {
        String methodName = "setGloves";
        Meta valueMeta = MetaContext.getMeta(GlovesMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetArmor(valueMeta, methodName, "gloves", message);
    }

    @DisplayName("Тест, что метод setBoots в классе Archer сохраняет полученный Boots в поле класса")
    @Test
    void testSetBootsSavesBootsToField() {
        String methodName = "setBoots";
        Meta valueMeta = MetaContext.getMeta(BootsMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetArmor(valueMeta, methodName, "boots", message);
    }

    @DisplayName("Тест, что метод setShield в классе Archer сохраняет полученный Shield в поле класса")
    @Test
    void testSetShieldSavesShieldToField() {
        String methodName = "setShield";
        Meta valueMeta = MetaContext.getMeta(ShieldMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetArmor(valueMeta, methodName, "shield", message);
    }

    @DisplayName("Тест, что метод setLeftRing в классе Archer сохраняет полученный AgilityRing в поле класса")
    @Test
    void testSetLeftRingSavesAgilityRingToField() {
        String methodName = "setLeftRing";
        Meta valueMeta = MetaContext.getMeta(AgilityRingMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetBijouterie(valueMeta, methodName, "leftRing", message);
    }

    @DisplayName("Тест, что метод setLeftRing в классе Archer добавляет очки кольца к соответствующей характеристике персонажа")
    @Test
    void testSetLeftRingAddsPoints() {
        testBijouterieAddsPoints("setLeftRing", "agility", AgilityRingMeta.class);
    }

    @DisplayName("Тест, что метод setRightRing в классе Archer сохраняет полученный AgilityRing в поле класса")
    @Test
    void testSetRightRingSavesAgilityRingToField() {
        String methodName = "setRightRing";
        Meta valueMeta = MetaContext.getMeta(AgilityRingMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetBijouterie(valueMeta, methodName, "rightRing", message);
    }

    @DisplayName("Тест, что метод setRightRing в классе Archer добавляет очки кольца к соответствующей характеристике персонажа")
    @Test
    void testSetRightRingAddsPoints() {
        testBijouterieAddsPoints("setRightRing", "agility", AgilityRingMeta.class);
    }

    @DisplayName("Тест, что метод setBelt в классе Archer сохраняет полученный AgilityBelt в поле класса")
    @Test
    void testSetBeltSavesAgilityBeltToField() {
        String methodName = "setBelt";
        Meta valueMeta = MetaContext.getMeta(AgilityBeltMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetBijouterie(valueMeta, methodName, "belt", message);
    }

    @DisplayName("Тест, что метод setBelt в классе Archer добавляет очки кольца к соответствующей характеристике персонажа")
    @Test
    void testSetBeltAddsPoints() {
        testBijouterieAddsPoints("setBelt", "agility", AgilityBeltMeta.class);
    }

    @DisplayName("Тест, что метод setNecklace в классе Archer сохраняет полученный AgilityNecklace в поле класса")
    @Test
    void testSetNecklaceSavesAgilityNecklaceToField() {
        String methodName = "setNecklace";
        Meta valueMeta = MetaContext.getMeta(AgilityNecklaceMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetBijouterie(valueMeta, methodName, "necklace", message);
    }

    @DisplayName("Тест, что метод setNecklace в классе Archer добавляет очки кольца к соответствующей характеристике персонажа")
    @Test
    void testSetNecklaceAddsPoints() {
        testBijouterieAddsPoints("setNecklace", "agility", AgilityNecklaceMeta.class);
    }

    @DisplayName("Тест, что метод setActiveQuest в классе Archer сохраняет переданный Quest в поле класса")
    @Test
    void testSetActiveQuestSavesQuestToField() {
        Object[] questConstructor = new Object[] {"test1", "test2", 1, 2, 3};
        testSetterWithMetaParam(QuestMeta.class, questConstructor, "setActiveQuest", "activeQuest", "test");
    }

    @DisplayName("Тест, что метод setSkill в классе Archer сохраняет переданный AccurateShot в поле класса")
    @Test
    void testSetSkillSavesSkillToField() {
        Object[] shotConstructor = new Object[]{"test", 1, 1};
        testSetterWithMetaParam(AccurateShotMeta.class, shotConstructor, "setSkill", "skill", "test");
    }

    @DisplayName("Тест, что метод takeOffLeftRing в классе Archer снимает левое кольцо")
    @Test
    void testTakeOffLeftRing() {
        testTakeOffRemovesBijouterie("takeOffLeftRing", "setLeftRing", "leftRing", AgilityRingMeta.class);
    }

    @DisplayName("Тест, что метод takeOffLeftRing в классе Archer отнимает от соответствующей характиристике количество очков предмета")
    @Test
    void testTakeOffLeftRingDecreasesCharacteristic() {
        testTakeOffDecreasesCharacteristic("takeOffLeftRing", "setLeftRing", "agility", AgilityRingMeta.class);
    }

    @DisplayName("Тест, что метод takeOffRightRing в классе Archer снимает левое кольцо")
    @Test
    void testTakeOffRightRing() {
        testTakeOffRemovesBijouterie("takeOffRightRing", "setRightRing", "rightRing", AgilityRingMeta.class);
    }

    @DisplayName("Тест, что метод takeOffRightRing в классе Archer отнимает от соответствующей характиристике количество очков предмета")
    @Test
    void testTakeOffRightRingDecreasesCharacteristic() {
        testTakeOffDecreasesCharacteristic("takeOffRightRing", "setRightRing", "agility", AgilityRingMeta.class);
    }

    @DisplayName("Тест, что метод takeOffBelt в классе Archer снимает левое кольцо")
    @Test
    void testTakeOffBelt() {
        testTakeOffRemovesBijouterie("takeOffBelt", "setBelt", "belt", AgilityBeltMeta.class);
    }

    @DisplayName("Тест, что метод takeOffBelt в классе Archer отнимает от соответствующей характиристике количество очков предмета")
    @Test
    void testTakeOffBeltDecreasesCharacteristic() {
        testTakeOffDecreasesCharacteristic("takeOffBelt", "setBelt", "agility", AgilityBeltMeta.class);
    }

    @DisplayName("Тест, что метод takeOffNecklace в классе Archer снимает левое кольцо")
    @Test
    void testTakeOffNecklace() {
        testTakeOffRemovesBijouterie("takeOffNecklace", "setNecklace", "necklace", AgilityNecklaceMeta.class);
    }

    @DisplayName("Тест, что метод takeOffNecklace в классе Archer отнимает от соответствующей характиристике количество очков предмета")
    @Test
    void testTakeOffNecklaceDecreasesCharacteristic() {
        testTakeOffDecreasesCharacteristic("takeOffNecklace", "setNecklace", "agility", AgilityNecklaceMeta.class);
    }

    @DisplayName("Тест, что метод getName в классе Archer возвращает имя персонажа")
    @Test
    void testGetName() {
        testGetter("getName", "setName", "test", CONSTRUCTOR_PARAM);
    }

    @DisplayName("Тест, что метод getAgility в классе Archer возвращает силу персонажа")
    @Test
    void testGetStrength() {
        testGetter("getStrength", "setStrength", 8, CONSTRUCTOR_PARAM);
    }

    @DisplayName("Тест, что метод getAgility в классе Archer возвращает ловкость персонажа")
    @Test
    void testGetAgility() {
        testGetter("getAgility", "setAgility", 8, CONSTRUCTOR_PARAM);
    }

    @DisplayName("Тест, что метод getIntelligence в классе Archer возвращает интеллект персонажа")
    @Test
    void testGetIntelligence() {
        testGetter("getIntelligence", "setIntelligence", 8, CONSTRUCTOR_PARAM);
    }

    @DisplayName("Тест, что метод getHp в классе Archer возвращает здоровье персонажа")
    @Test
    void testGetHp() {
        testGetter("getHp", "setHp", 8, CONSTRUCTOR_PARAM);
    }

    @DisplayName("Тест, что метод getMana в классе Archer возвращает ману персонажа")
    @Test
    void testGetMana() {
        testGetter("getMana", "setMana", 8, CONSTRUCTOR_PARAM);
    }

    @DisplayName("Тест, что метод getStamina в классе Archer возвращает выносливость персонажа")
    @Test
    void testGetStamina() {
        testGetter("getStamina", "setStamina", 8, CONSTRUCTOR_PARAM);
    }

    @DisplayName("Тест, что метод getLevel в классе Archer возвращает уровень персонажа")
    @Test
    void testGetLevel() {
        testGetter("getLevel", "setLevel", 8, CONSTRUCTOR_PARAM);
    }

    @DisplayName("Тест, что метод getExperience в классе Archer возвращает опыт персонажа")
    @Test
    void testGetExperience() {
        testGetter("getExperience", "setExperience", 8, CONSTRUCTOR_PARAM);
    }

    @DisplayName("Тест, что метод getHelmet в классе Archer возвращает шлем персонажа")
    @Test
    void testGetHelmet() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(HelmetMeta.class).instantiateObjectWithConstructor("test", 1, 2);
            testGetter("getHelmet", "setHelmet", param, CONSTRUCTOR_PARAM);
        });
    }

    @DisplayName("Тест, что метод getCuirass в классе Archer возвращает кирасу персонажа")
    @Test
    void testGetCuirass() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(CuirassMeta.class).instantiateObjectWithConstructor("test", 1, 2);
            testGetter("getCuirass", "setCuirass", param, CONSTRUCTOR_PARAM);
        });
    }

    @DisplayName("Тест, что метод getGloves в классе Archer возвращает перчатки персонажа")
    @Test
    void testGetGloves() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(GlovesMeta.class).instantiateObjectWithConstructor("test", 1, 2);
            testGetter("getGloves", "setGloves", param, CONSTRUCTOR_PARAM);
        });
    }

    @DisplayName("Тест, что метод getBoots в классе Archer возвращает сапоги персонажа")
    @Test
    void testGetBoots() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(BootsMeta.class).instantiateObjectWithConstructor("test", 1, 2);
            testGetter("getBoots", "setBoots", param, CONSTRUCTOR_PARAM);
        });
    }

    @DisplayName("Тест, что метод getShield в классе Archer возвращает щит персонажа")
    @Test
    void testGetShield() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(ShieldMeta.class).instantiateObjectWithConstructor("test", 1, 2);
            testGetter("getShield", "setShield", param, CONSTRUCTOR_PARAM);
        });
    }

    @DisplayName("Тест, что метод getPoint в классе Archer возвращает точку персонажа")
    @Test
    void testGetPoint() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(PointMeta.class).instantiateObjectWithConstructor(1, 2);
            testGetter("getPoint", "setPoint", param, CONSTRUCTOR_PARAM);
        });
    }

    @DisplayName("Тест, что метод getActiveQuest в классе Archer возвращает задание персонажа")
    @Test
    void testGetActiveQuest() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(QuestMeta.class).instantiateObjectWithConstructor("t", "u", 1, 2, 3);
            testGetter("getActiveQuest", "setActiveQuest", param, CONSTRUCTOR_PARAM);
        });
    }

    @DisplayName("Тест, что метод getBow в классе Archer возвращает оружие персонажа")
    @Test
    void testGetBow() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(BowMeta.class).instantiateObjectWithConstructor("test", 1);
            testGetter("getBow", "setBow", param, CONSTRUCTOR_PARAM);
        });
    }

    @DisplayName("Тест, что метод getLeftRing в классе Archer возвращает левое кольцо персонажа")
    @Test
    void testGetLeftRing() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(AgilityRingMeta.class).instantiateObjectWithConstructor("test", 1);
            testGetter("getLeftRing", "setLeftRing", param, CONSTRUCTOR_PARAM);
        });
    }

    @DisplayName("Тест, что метод getRightRing в классе Archer возвращает правое кольцо персонажа")
    @Test
    void testGetRightRing() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(AgilityRingMeta.class).instantiateObjectWithConstructor("test", 1);
            testGetter("getRightRing", "setRightRing", param, CONSTRUCTOR_PARAM);
        });
    }

    @DisplayName("Тест, что метод getBelt в классе Archer возвращает ремень персонажа")
    @Test
    void testGetBelt() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(AgilityBeltMeta.class).instantiateObjectWithConstructor("test", 1);
            testGetter("getBelt", "setBelt", param, CONSTRUCTOR_PARAM);
        });
    }

    @DisplayName("Тест, что метод getNecklace в классе Archer возвращает ожерелье персонажа")
    @Test
    void testGetNecklace() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(AgilityNecklaceMeta.class).instantiateObjectWithConstructor("test", 1);
            testGetter("getNecklace", "setNecklace", param, CONSTRUCTOR_PARAM);
        });
    }

    @DisplayName("Тест, что метод getSkill в классе Archer возвращает навык персонажа")
    @Test
    void testGetSkill() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(AccurateShotMeta.class).instantiateObjectWithConstructor("test", 1, 2);
            testGetter("getSkill", "setSkill", param, CONSTRUCTOR_PARAM);
        });
    }

    @DisplayName("Тесто, что метод castSkill в классе Archer наносит двойной урон переданному Archer")
    @Test
    void testCastSkill() {
        Safer.runSafe(() -> {
            String methodName = "castSkill";
            Object archer = getMeta().instantiateObjectWithConstructor(CONSTRUCTOR_PARAM);
            setFieldForObjectAndGet(archer, "setBow", BowMeta.class, "test", 10);
            setFieldForObjectAndGet(archer, "setSkill", AccurateShotMeta.class, "test", 15, 1);

            BiConsumer<Object, Object[]> castAssert = (obj, param) -> {
                Object Archer = param[0];
                Safer.runSafe(() -> {
                    String className = getMeta().getClassName();
                    int expectedHp = 80;
                    int expectedMana = 85;
                    String hpFieldName = "hp";
                    String manaFieldName = "mana";
                    Object actualHp = getFieldValue(Archer, hpFieldName);
                    Object actualMana = getFieldValue(archer, manaFieldName);
                    String hpMessage = getFieldValueAssert(className, methodName, hpFieldName, expectedHp, actualHp);
                    String manaMessage = getFieldValueAssert(className, methodName, manaFieldName, expectedMana, actualMana);
                    assertEquals(expectedHp, actualHp, hpMessage);
                    assertEquals(expectedMana, actualMana, manaMessage);
                });
            };

            Object knight = Meta.instantiateObjectFromMeta(KnightMeta.class, CONSTRUCTOR_PARAM);
            testClassMethod(castAssert, archer, methodName, knight);
        });
    }
}