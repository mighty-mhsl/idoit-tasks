package com.idoit.character;

import com.idoit.meta.Meta;
import com.idoit.meta.MetaContext;
import com.idoit.meta.battlefield.PointMeta;
import com.idoit.meta.character.KnightMeta;
import com.idoit.meta.character.WizardMeta;
import com.idoit.meta.item.armor.BootsMeta;
import com.idoit.meta.item.armor.CuirassMeta;
import com.idoit.meta.item.armor.GlovesMeta;
import com.idoit.meta.item.armor.HelmetMeta;
import com.idoit.meta.item.armor.ShieldMeta;
import com.idoit.meta.item.bijouterie.belt.IntelligenceBeltMeta;
import com.idoit.meta.item.bijouterie.necklace.IntelligenceNecklaceMeta;
import com.idoit.meta.item.bijouterie.ring.IntelligenceRingMeta;
import com.idoit.meta.item.weapon.StaffMeta;
import com.idoit.meta.quest.QuestMeta;
import com.idoit.meta.skill.HealMeta;
import com.idoit.safe.Safer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты логики в классе Wizard")
class WizardTest extends CharacterTest {

    @BeforeEach
	void setUp() {
        setMeta(WizardMeta.class);
    }

    @DisplayName("Тест, что класс Wizard находится в пакете com.idoit.character")
    @Test
    void testWizardIsInCharacterPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Wizard имеет все необходимые поля")
    @Test
    void testWizardHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе Wizard есть конструктор принимающий имя персонажа")
    @Test
    void testWizardHasConstructorWithNameParam() {
        testClassHasConstructors();
        testConstructorSetsValueToFields("test");
    }

    @DisplayName("Тест, что в классе Wizard есть все необходимые методы")
    @Test
    void testWizardHasAllMethods() {
        testClassHasAllMethods();
    }

    @DisplayName("Тест, что метод hit в классе Wizard уменьшает хп противника на 10")
    @Test
    void testHitDecreasesEnemyHp() {
        Meta staffMeta = MetaContext.getMeta(StaffMeta.class);
        testHitDamagesEnemy(staffMeta, "setStaff");
    }

    @DisplayName("Тест, что метод hit в классе Wizard уменьшает прочность оружия на 1")
    @Test
    void testHitDecreasesWeaponDurability() {
        Meta staffMeta = MetaContext.getMeta(StaffMeta.class);
        testHitDamagesWeapon(staffMeta, "setStaff", "staff");
    }

    @DisplayName("Тест, что метод hit в классе Wizard уменьшает выносливость персонажа на 10")
    @Test
    void testHitDecreasesStamina() {
        Meta staffMeta = MetaContext.getMeta(StaffMeta.class);
        testHitDecreasesStamina(staffMeta, "setStaff");
    }

    @DisplayName("Тест, что метод go в классе Wizard меняет координаты точки персонажа")
    @Test
    void testGoChangesPointCoordinates() {
        testGo(CONSTRUCTOR_PARAM);
    }

    @DisplayName("Тест, что метод setStuff в классе Wizard сохраняет переданный Stuff в поле класса")
    @Test
    void testSetStuffSavesStuffToField() {
        String methodName = "setStaff";
        Meta valueMeta = MetaContext.getMeta(StaffMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetWeapon(valueMeta, methodName, "staff", message);
    }

    @DisplayName("Тест, что метод setHelmet в классе Wizard сохраняет полученный Helmet в поле класса")
    @Test
    void testSetHelmetSavesHelmetToField() {
        String methodName = "setHelmet";
        Meta valueMeta = MetaContext.getMeta(HelmetMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetArmor(valueMeta, methodName, "helmet", message);
    }

    @DisplayName("Тест, что метод setCuirass в классе Wizard сохраняет полученный Cuirass в поле класса")
    @Test
    void testSetCuirassSavesCuirassToField() {
        String methodName = "setCuirass";
        Meta valueMeta = MetaContext.getMeta(CuirassMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetArmor(valueMeta, methodName, "cuirass", message);
    }

    @DisplayName("Тест, что метод setGloves в классе Wizard сохраняет полученный Gloves в поле класса")
    @Test
    void testSetGlovesSavesGlovesToField() {
        String methodName = "setGloves";
        Meta valueMeta = MetaContext.getMeta(GlovesMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetArmor(valueMeta, methodName, "gloves", message);
    }

    @DisplayName("Тест, что метод setBoots в классе Wizard сохраняет полученный Boots в поле класса")
    @Test
    void testSetBootsSavesBootsToField() {
        String methodName = "setBoots";
        Meta valueMeta = MetaContext.getMeta(BootsMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetArmor(valueMeta, methodName, "boots", message);
    }

    @DisplayName("Тест, что метод setShield в классе Wizard сохраняет полученный Shield в поле класса")
    @Test
    void testSetShieldSavesShieldToField() {
        String methodName = "setShield";
        Meta valueMeta = MetaContext.getMeta(ShieldMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetArmor(valueMeta, methodName, "shield", message);
    }

    @DisplayName("Тест, что метод setLeftRing в классе Wizard сохраняет полученный IntelligenceRing в поле класса")
    @Test
    void testSetLeftRingSavesIntelligenceRingToField() {
        String methodName = "setLeftRing";
        Meta valueMeta = MetaContext.getMeta(IntelligenceRingMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetBijouterie(valueMeta, methodName, "leftRing", message);
    }

    @DisplayName("Тест, что метод setLeftRing в классе Wizard добавляет очки кольца к соответствующей характеристике персонажа")
    @Test
    void testSetLeftRingAddsPoints() {
        testBijouterieAddsPoints("setLeftRing", "intelligence", IntelligenceRingMeta.class);
    }

    @DisplayName("Тест, что метод setRightRing в классе Wizard сохраняет полученный IntelligenceRing в поле класса")
    @Test
    void testSetRightRingSavesIntelligenceRingToField() {
        String methodName = "setRightRing";
        Meta valueMeta = MetaContext.getMeta(IntelligenceRingMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetBijouterie(valueMeta, methodName, "rightRing", message);
    }

    @DisplayName("Тест, что метод setRightRing в классе Wizard добавляет очки кольца к соответствующей характеристике персонажа")
    @Test
    void testSetRightRingAddsPoints() {
        testBijouterieAddsPoints("setRightRing", "intelligence", IntelligenceRingMeta.class);
    }

    @DisplayName("Тест, что метод setBelt в классе Wizard сохраняет полученный IntelligenceBelt в поле класса")
    @Test
    void testSetBeltSavesIntelligenceBeltToField() {
        String methodName = "setBelt";
        Meta valueMeta = MetaContext.getMeta(IntelligenceBeltMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetBijouterie(valueMeta, methodName, "belt", message);
    }

    @DisplayName("Тест, что метод setBelt в классе Wizard добавляет очки кольца к соответствующей характеристике персонажа")
    @Test
    void testSetBeltAddsPoints() {
        testBijouterieAddsPoints("setBelt", "intelligence", IntelligenceBeltMeta.class);
    }

    @DisplayName("Тест, что метод setNecklace в классе Wizard сохраняет полученный IntelligenceNecklace в поле класса")
    @Test
    void testSetNecklaceSavesIntelligenceNecklaceToField() {
        String methodName = "setNecklace";
        Meta valueMeta = MetaContext.getMeta(IntelligenceNecklaceMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetBijouterie(valueMeta, methodName, "necklace", message);
    }

    @DisplayName("Тест, что метод setNecklace в классе Wizard добавляет очки кольца к соответствующей характеристике персонажа")
    @Test
    void testSetNecklaceAddsPoints() {
        testBijouterieAddsPoints("setNecklace", "intelligence", IntelligenceNecklaceMeta.class);
    }

    @DisplayName("Тест, что метод setActiveQuest в классе Wizard сохраняет переданный Quest в поле класса")
    @Test
    void testSetActiveQuestSavesQuestToField() {
        Object[] questConstructor = new Object[] {"test1", "test2", 1, 2, 3};
        testSetterWithMetaParam(QuestMeta.class, questConstructor, "setActiveQuest", "activeQuest", "test");
    }

    @DisplayName("Тест, что метод setSkill в классе Wizard сохраняет переданный Heal в поле класса")
    @Test
    void testSetSkillSavesSkillToField() {
        Object[] healConstructor = new Object[]{"test", 1, 1};
        testSetterWithMetaParam(HealMeta.class, healConstructor, "setSkill", "skill", CONSTRUCTOR_PARAM);
    }

    @DisplayName("Тест, что метод takeOffLeftRing в классе Wizard снимает левое кольцо")
    @Test
    void testTakeOffLeftRing() {
        testTakeOffRemovesBijouterie("takeOffLeftRing", "setLeftRing", "leftRing", IntelligenceRingMeta.class);
    }

    @DisplayName("Тест, что метод takeOffLeftRing в классе Wizard отнимает от соответствующей характиристике количество очков предмета")
    @Test
    void testTakeOffLeftRingDecreasesCharacteristic() {
        testTakeOffDecreasesCharacteristic("takeOffLeftRing", "setLeftRing", "intelligence", IntelligenceRingMeta.class);
    }

    @DisplayName("Тест, что метод takeOffRightRing в классе Wizard снимает левое кольцо")
    @Test
    void testTakeOffRightRing() {
        testTakeOffRemovesBijouterie("takeOffRightRing", "setRightRing", "rightRing", IntelligenceRingMeta.class);
    }

    @DisplayName("Тест, что метод takeOffRightRing в классе Wizard отнимает от соответствующей характиристике количество очков предмета")
    @Test
    void testTakeOffRightRingDecreasesCharacteristic() {
        testTakeOffDecreasesCharacteristic("takeOffRightRing", "setRightRing", "intelligence", IntelligenceRingMeta.class);
    }

    @DisplayName("Тест, что метод takeOffBelt в классе Wizard снимает левое кольцо")
    @Test
    void testTakeOffBelt() {
        testTakeOffRemovesBijouterie("takeOffBelt", "setBelt", "belt", IntelligenceBeltMeta.class);
    }

    @DisplayName("Тест, что метод takeOffBelt в классе Wizard отнимает от соответствующей характиристике количество очков предмета")
    @Test
    void testTakeOffBeltDecreasesCharacteristic() {
        testTakeOffDecreasesCharacteristic("takeOffBelt", "setBelt", "intelligence", IntelligenceBeltMeta.class);
    }

    @DisplayName("Тест, что метод takeOffNecklace в классе Wizard снимает левое кольцо")
    @Test
    void testTakeOffNecklace() {
        testTakeOffRemovesBijouterie("takeOffNecklace", "setNecklace", "necklace", IntelligenceNecklaceMeta.class);
    }

    @DisplayName("Тест, что метод takeOffNecklace в классе Wizard отнимает от соответствующей характиристике количество очков предмета")
    @Test
    void testTakeOffNecklaceDecreasesCharacteristic() {
        testTakeOffDecreasesCharacteristic("takeOffNecklace", "setNecklace", "intelligence", IntelligenceNecklaceMeta.class);
    }

    @DisplayName("Тест, что метод getName в классе Wizard возвращает имя персонажа")
    @Test
    void testGetName() {
        testGetter("getName", "setName", "test", CONSTRUCTOR_PARAM);
    }

    @DisplayName("Тест, что метод getStrength в классе Wizard возвращает силу персонажа")
    @Test
    void testGetStrength() {
        testGetter("getStrength", "setStrength", 8, CONSTRUCTOR_PARAM);
    }

    @DisplayName("Тест, что метод getAgility в классе Wizard возвращает ловкость персонажа")
    @Test
    void testGetAgility() {
        testGetter("getAgility", "setAgility", 8, CONSTRUCTOR_PARAM);
    }

    @DisplayName("Тест, что метод getIntelligence в классе Wizard возвращает интеллект персонажа")
    @Test
    void testGetIntelligence() {
        testGetter("getIntelligence", "setIntelligence", 8, CONSTRUCTOR_PARAM);
    }

    @DisplayName("Тест, что метод getHp в классе Wizard возвращает здоровье персонажа")
    @Test
    void testGetHp() {
        testGetter("getHp", "setHp", 8, CONSTRUCTOR_PARAM);
    }

    @DisplayName("Тест, что метод getMana в классе Wizard возвращает ману персонажа")
    @Test
    void testGetMana() {
        testGetter("getMana", "setMana", 8, CONSTRUCTOR_PARAM);
    }

    @DisplayName("Тест, что метод getStamina в классе Wizard возвращает выносливость персонажа")
    @Test
    void testGetStamina() {
        testGetter("getStamina", "setStamina", 8, CONSTRUCTOR_PARAM);
    }

    @DisplayName("Тест, что метод getLevel в классе Wizard возвращает уровень персонажа")
    @Test
    void testGetLevel() {
        testGetter("getLevel", "setLevel", 8, CONSTRUCTOR_PARAM);
    }

    @DisplayName("Тест, что метод getExperience в классе Wizard возвращает опыт персонажа")
    @Test
    void testGetExperience() {
        testGetter("getExperience", "setExperience", 8, CONSTRUCTOR_PARAM);
    }

    @DisplayName("Тест, что метод getHelmet в классе Wizard возвращает шлем персонажа")
    @Test
    void testGetHelmet() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(HelmetMeta.class).instantiateObjectWithConstructor("test", 1, 2);
            testGetter("getHelmet", "setHelmet", param, CONSTRUCTOR_PARAM);
        });
    }

    @DisplayName("Тест, что метод getCuirass в классе Wizard возвращает кирасу персонажа")
    @Test
    void testGetCuirass() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(CuirassMeta.class).instantiateObjectWithConstructor("test", 1, 2);
            testGetter("getCuirass", "setCuirass", param, CONSTRUCTOR_PARAM);
        });
    }

    @DisplayName("Тест, что метод getGloves в классе Wizard возвращает перчатки персонажа")
    @Test
    void testGetGloves() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(GlovesMeta.class).instantiateObjectWithConstructor("test", 1, 2);
            testGetter("getGloves", "setGloves", param, CONSTRUCTOR_PARAM);
        });
    }

    @DisplayName("Тест, что метод getBoots в классе Wizard возвращает сапоги персонажа")
    @Test
    void testGetBoots() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(BootsMeta.class).instantiateObjectWithConstructor("test", 1, 2);
            testGetter("getBoots", "setBoots", param, CONSTRUCTOR_PARAM);
        });
    }

    @DisplayName("Тест, что метод getShield в классе Wizard возвращает щит персонажа")
    @Test
    void testGetShield() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(ShieldMeta.class).instantiateObjectWithConstructor("test", 1, 2);
            testGetter("getShield", "setShield", param, CONSTRUCTOR_PARAM);
        });
    }

    @DisplayName("Тест, что метод getPoint в классе Wizard возвращает точку персонажа")
    @Test
    void testGetPoint() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(PointMeta.class).instantiateObjectWithConstructor(1, 2);
            testGetter("getPoint", "setPoint", param, CONSTRUCTOR_PARAM);
        });
    }

    @DisplayName("Тест, что метод getActiveQuest в классе Wizard возвращает задание персонажа")
    @Test
    void testGetActiveQuest() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(QuestMeta.class).instantiateObjectWithConstructor("t", "u", 1, 2, 3);
            testGetter("getActiveQuest", "setActiveQuest", param, CONSTRUCTOR_PARAM);
        });
    }

    @DisplayName("Тест, что метод getStaff в классе Wizard возвращает оружие персонажа")
    @Test
    void testGetStaff() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(StaffMeta.class).instantiateObjectWithConstructor("test", 1);
            testGetter("getStaff", "setStaff", param, CONSTRUCTOR_PARAM);
        });
    }

    @DisplayName("Тест, что метод getLeftRing в классе Wizard возвращает левое кольцо персонажа")
    @Test
    void testGetLeftRing() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(IntelligenceRingMeta.class).instantiateObjectWithConstructor("test", 1);
            testGetter("getLeftRing", "setLeftRing", param, CONSTRUCTOR_PARAM);
        });
    }

    @DisplayName("Тест, что метод getRightRing в классе Wizard возвращает правое кольцо персонажа")
    @Test
    void testGetRightRing() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(IntelligenceRingMeta.class).instantiateObjectWithConstructor("test", 1);
            testGetter("getRightRing", "setRightRing", param, CONSTRUCTOR_PARAM);
        });
    }

    @DisplayName("Тест, что метод getBelt в классе Wizard возвращает ремень персонажа")
    @Test
    void testGetBelt() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(IntelligenceBeltMeta.class).instantiateObjectWithConstructor("test", 1);
            testGetter("getBelt", "setBelt", param, CONSTRUCTOR_PARAM);
        });
    }

    @DisplayName("Тест, что метод getNecklace в классе Wizard возвращает ожерелье персонажа")
    @Test
    void testGetNecklace() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(IntelligenceNecklaceMeta.class).instantiateObjectWithConstructor("test", 1);
            testGetter("getNecklace", "setNecklace", param, CONSTRUCTOR_PARAM);
        });
    }

    @DisplayName("Тест, что метод getSkill в классе Wizard возвращает навык персонажа")
    @Test
    void testGetSkill() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(HealMeta.class).instantiateObjectWithConstructor("test", 1, 2);
            testGetter("getSkill", "setSkill", param, CONSTRUCTOR_PARAM);
        });
    }

    @DisplayName("Тест, что метод castSkill в классе Wizard применяет Heal к переданному Wizard")
    @Test
    void testCastSkill() {
        Safer.runSafe(() -> {
            String methodName = "castSkill";
            Object wizard = getMeta().instantiateObjectWithConstructor(CONSTRUCTOR_PARAM);
            setFieldForObjectAndGet(wizard, "setSkill", HealMeta.class, "test", 15, 1);

            BiConsumer<Object, Object[]> castAssert = (obj, params) -> {
                Object Wizard = params[0];
                Safer.runSafe(() -> {
                    String className = getMeta().getClassName();
                    int expectedHp = 110;
                    int expectedMana = 85;
                    String hpFieldName = "hp";
                    String manaFieldName = "mana";
                    Object actualHp = getFieldValue(Wizard, hpFieldName);
                    Object actualMana = getFieldValue(wizard, manaFieldName);
                    String hpMessage = getFieldValueAssert(className, methodName, hpFieldName, expectedHp, actualHp);
                    String manaMessage = getFieldValueAssert(className, methodName, manaFieldName, expectedMana, actualMana);
                    assertEquals(expectedHp, actualHp, hpMessage);
                    assertEquals(expectedMana, actualMana, manaMessage);
                });
            };

            Object knight = Meta.instantiateObjectFromMeta(KnightMeta.class, CONSTRUCTOR_PARAM);
            testClassMethod(castAssert, wizard, methodName, knight);
        });
    }
}
