package com.idoit.character;

import com.idoit.meta.Meta;
import com.idoit.meta.MetaContext;
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

    @DisplayName("Тест, что метод setLeftRing в классе Archer сохраняет полученный StrengthRing в поле класса")
    @Test
    void testSetLeftRingSavesStrengthRingToField() {
        String methodName = "setLeftRing";
        Meta valueMeta = MetaContext.getMeta(AgilityRingMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetBijouterie(valueMeta, methodName, "leftRing", message);
    }

    @DisplayName("Тест, что метод setRightRing в классе Archer сохраняет полученный StrengthRing в поле класса")
    @Test
    void testSetRightRingSavesStrengthRingToField() {
        String methodName = "setRightRing";
        Meta valueMeta = MetaContext.getMeta(AgilityRingMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetBijouterie(valueMeta, methodName, "rightRing", message);
    }

    @DisplayName("Тест, что метод setBelt в классе Archer сохраняет полученный StrengthBelt в поле класса")
    @Test
    void testSetBeltSavesStrengthBeltToField() {
        String methodName = "setBelt";
        Meta valueMeta = MetaContext.getMeta(AgilityBeltMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetBijouterie(valueMeta, methodName, "belt", message);
    }

    @DisplayName("Тест, что метод setNecklace в классе Archer сохраняет полученный StrengthNecklace в поле класса")
    @Test
    void testSetNecklaceSavesStrengthNecklaceToField() {
        String methodName = "setNecklace";
        Meta valueMeta = MetaContext.getMeta(AgilityNecklaceMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetBijouterie(valueMeta, methodName, "necklace", message);
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

    @DisplayName("Тесто, что метод castSkill в классе Archer наносит двойной урон переданному Knight")
    @Test
    void testCastSkill() {
        Safer.runSafe(() -> {
            String methodName = "castSkill";
            Object archer = getMeta().instantiateObjectWithConstructor(CONSTRUCTOR_PARAM);
            setFieldForObjectAndGet(archer, "setBow", BowMeta.class, "test", 10);
            setFieldForObjectAndGet(archer, "setSkill", AccurateShotMeta.class, "test", 15, 1);

            BiConsumer<Object, Object[]> castAssert = (obj, param) -> {
                Object knight = param[0];
                Safer.runSafe(() -> {
                    String className = getMeta().getClassName();
                    int expectedHp = 80;
                    int expectedMana = 85;
                    String hpFieldName = "hp";
                    String manaFieldName = "mana";
                    Object actualHp = getFieldValue(knight, hpFieldName);
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