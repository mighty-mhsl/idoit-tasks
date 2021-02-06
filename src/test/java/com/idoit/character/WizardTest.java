package com.idoit.character;

import com.idoit.meta.Meta;
import com.idoit.meta.MetaContext;
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

    @DisplayName("Тест, что метод setLeftRing в классе Wizard сохраняет полученный StrengthRing в поле класса")
    @Test
    void testSetLeftRingSavesStrengthRingToField() {
        String methodName = "setLeftRing";
        Meta valueMeta = MetaContext.getMeta(IntelligenceRingMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetBijouterie(valueMeta, methodName, "leftRing", message);
    }

    @DisplayName("Тест, что метод setRightRing в классе Wizard сохраняет полученный StrengthRing в поле класса")
    @Test
    void testSetRightRingSavesStrengthRingToField() {
        String methodName = "setRightRing";
        Meta valueMeta = MetaContext.getMeta(IntelligenceRingMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetBijouterie(valueMeta, methodName, "rightRing", message);
    }

    @DisplayName("Тест, что метод setBelt в классе Wizard сохраняет полученный StrengthBelt в поле класса")
    @Test
    void testSetBeltSavesStrengthBeltToField() {
        String methodName = "setBelt";
        Meta valueMeta = MetaContext.getMeta(IntelligenceBeltMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetBijouterie(valueMeta, methodName, "belt", message);
    }

    @DisplayName("Тест, что метод setNecklace в классе Wizard сохраняет полученный StrengthNecklace в поле класса")
    @Test
    void testSetNecklaceSavesStrengthNecklaceToField() {
        String methodName = "setNecklace";
        Meta valueMeta = MetaContext.getMeta(IntelligenceNecklaceMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetBijouterie(valueMeta, methodName, "necklace", message);
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

    @DisplayName("Тест, что метод castSkill в классе Wizard применяет Heal к переданному Knight")
    @Test
    void testCastSkill() {
        Safer.runSafe(() -> {
            String methodName = "castSkill";
            Object wizard = getMeta().instantiateObjectWithConstructor(CONSTRUCTOR_PARAM);
            setFieldForObjectAndGet(wizard, "setSkill", HealMeta.class, "test", 15, 1);

            BiConsumer<Object, Object[]> castAssert = (obj, params) -> {
                Object knight = params[0];
                Safer.runSafe(() -> {
                    String className = getMeta().getClassName();
                    int expectedHp = 110;
                    int expectedMana = 85;
                    String hpFieldName = "hp";
                    String manaFieldName = "mana";
                    Object actualHp = getFieldValue(knight, hpFieldName);
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
