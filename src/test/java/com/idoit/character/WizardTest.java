package com.idoit.character;

import com.idoit.MessageUtil;
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
import com.idoit.meta.item.common.food.AppleMeta;
import com.idoit.meta.item.weapon.StaffMeta;
import com.idoit.meta.profile.InventoryMeta;
import com.idoit.meta.profile.ProfileMeta;
import com.idoit.meta.quest.QuestMeta;
import com.idoit.meta.skill.HealMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("Тесты логики в классе Wizard")
class WizardTest extends CharacterTest {

    private WizardMeta.WizardLook wizard;

    @BeforeEach
	void setUp() {
        setMeta(WizardMeta.class);
        WizardMeta meta = (WizardMeta) getMeta();
        meta.resetLook();
        wizard = meta.getLook();
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
        testConstructorSetsValuesToProfile();
    }

    @DisplayName("Тест, что в классе Wizard есть все необходимые методы")
    @Test
    void testWizardHasAllMethods() {
        testClassHasAllMethods();
    }

    @DisplayName("Тест, что метод hit в классе Wizard уменьшает хп противника на 10")
    @Test
    void testHitDecreasesEnemyHp() {
        int expectedValue = 90;
        ProfileMeta profile = createProfile();
        KnightMeta enemy = new KnightMeta();
        enemy.getLook().setProfile(profile);
        StaffMeta staff = (StaffMeta) MetaContext.getMeta(StaffMeta.class);
        wizard.setProfile(profile);
        wizard.setStaff(staff);

        wizard.hit(enemy);

        int actualValue = profile.getLook().getHp();
        String message = MessageUtil.formatAssertMessage(
                String.format("После вызова метода hit переданная цель должна иметь %d хп", expectedValue),
                String.format("После вызова метода hit переданная цель имеет %d хп", actualValue)
        );
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод hit в классе Wizard уменьшает прочность оружия на 1")
    @Test
    void testHitDecreasesWeaponDurability() {
        int expectedValue = 99;
        ProfileMeta profile = createProfile();
        KnightMeta enemy = new KnightMeta();
        enemy.getLook().setProfile(profile);
        StaffMeta staff = (StaffMeta) MetaContext.getMeta(StaffMeta.class);
        staff.refresh();
        wizard.setStaff(staff);

        wizard.hit(enemy);

        int actualValue = staff.getLook().getDurability();
        String message = MessageUtil.formatAssertMessage(
                String.format("После вызова метода hit оружние бьющего должно иметь %d прочности", expectedValue),
                String.format("После вызова метода hit оружние бьющего имеет %d прочности", actualValue)
        );
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод hit в классе Wizard уменьшает выносливость персонажа на 10")
    @Test
    void testHitDecreasesStamina() {
        int expectedValue = 90;
        ProfileMeta profile = createProfile();
        KnightMeta enemy = new KnightMeta();
        enemy.getLook().setProfile(profile);
        StaffMeta staff = (StaffMeta) MetaContext.getMeta(StaffMeta.class);
        wizard.setStaff(staff);
        wizard.setProfile(profile);

        wizard.hit(enemy);

        int actualValue = profile.getLook().getStamina();
        String message = MessageUtil.formatAssertMessage(
                String.format("После вызова метода hit персонаж должен иметь %d выносливости", expectedValue),
                String.format("После вызова метода hit персонаж имеет %d выносливости", actualValue)
        );
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод go в классе Wizard меняет координаты точки персонажа")
    @Test
    void testGoChangesPointCoordinates() {
        int expectedX = 5;
        int expectedY = 6;

        wizard.go(expectedX, expectedY);

        int actualX = wizard.getPoint().getLook().getX();
        int actualY = wizard.getPoint().getLook().getY();
        assertEquals(expectedX, actualX, getGoAssertMessage("x", expectedX, actualX));
        assertEquals(expectedY, actualY, getGoAssertMessage("y", expectedY, actualY));
    }

    @DisplayName("Тест, что метод setStuff в классе Wizard сохраняет переданный Stuff в поле класса")
    @Test
    void testSetStuffSavesStuffToField() {
        StaffMeta expectedValue = (StaffMeta) MetaContext.getMeta(StaffMeta.class);
        wizard.setStaff(expectedValue);
        String message = getSetterAssertMessage("setStaff", "staff", getMeta().getClassName());
        assertEquals(expectedValue, wizard.getStaff(), message);
    }

    @DisplayName("Тест, что метод setHelmet в классе Wizard сохраняет полученный Helmet в поле класса")
    @Test
    void testSetHelmetSavesHelmetToField() {
        HelmetMeta expectedValue = (HelmetMeta) MetaContext.getMeta(HelmetMeta.class);
        InventoryMeta inventory = (InventoryMeta) MetaContext.getMeta(InventoryMeta.class);
        ProfileMeta profile = (ProfileMeta) MetaContext.getMeta(ProfileMeta.class);
        profile.getLook().setInventory(inventory);
        wizard.setProfile(profile);

        wizard.setHelmet(expectedValue);

        String message = getSetterAssertMessage("setHelmet", "helmet", inventory.getClassName());
        assertEquals(expectedValue, wizard.getProfile().getLook().getInventory().getLook().getHelmet(), message);
    }

    @DisplayName("Тест, что метод setCuirass в классе Wizard сохраняет полученный Cuirass в поле класса")
    @Test
    void testSetCuirassSavesCuirassToField() {
        CuirassMeta expectedValue = (CuirassMeta) MetaContext.getMeta(CuirassMeta.class);
        InventoryMeta inventory = (InventoryMeta) MetaContext.getMeta(InventoryMeta.class);
        ProfileMeta profile = (ProfileMeta) MetaContext.getMeta(ProfileMeta.class);
        profile.getLook().setInventory(inventory);
        wizard.setProfile(profile);

        wizard.setCuirass(expectedValue);

        String message = getSetterAssertMessage("setCuirass", "cuirass", inventory.getClassName());
        assertEquals(expectedValue, wizard.getProfile().getLook().getInventory().getLook().getCuirass(), message);
    }

    @DisplayName("Тест, что метод setGloves в классе Wizard сохраняет полученный Gloves в поле класса")
    @Test
    void testSetGlovesSavesGlovesToField() {
        GlovesMeta expectedValue = (GlovesMeta) MetaContext.getMeta(GlovesMeta.class);
        InventoryMeta inventory = (InventoryMeta) MetaContext.getMeta(InventoryMeta.class);
        ProfileMeta profile = (ProfileMeta) MetaContext.getMeta(ProfileMeta.class);
        profile.getLook().setInventory(inventory);
        wizard.setProfile(profile);

        wizard.setGloves(expectedValue);

        String message = getSetterAssertMessage("setGloves", "gloves", inventory.getClassName());
        assertEquals(expectedValue, wizard.getProfile().getLook().getInventory().getLook().getGloves(), message);
    }

    @DisplayName("Тест, что метод setBoots в классе Wizard сохраняет полученный Boots в поле класса")
    @Test
    void testSetBootsSavesBootsToField() {
        BootsMeta expectedValue = (BootsMeta) MetaContext.getMeta(BootsMeta.class);
        InventoryMeta inventory = (InventoryMeta) MetaContext.getMeta(InventoryMeta.class);
        ProfileMeta profile = (ProfileMeta) MetaContext.getMeta(ProfileMeta.class);
        profile.getLook().setInventory(inventory);
        wizard.setProfile(profile);

        wizard.setBoots(expectedValue);

        String message = getSetterAssertMessage("setBoots", "boots", inventory.getClassName());
        assertEquals(expectedValue, wizard.getProfile().getLook().getInventory().getLook().getBoots(), message);
    }

    @DisplayName("Тест, что метод setShield в классе Wizard сохраняет полученный Shield в поле класса")
    @Test
    void testSetShieldSavesShieldToField() {
        ShieldMeta expectedValue = (ShieldMeta) MetaContext.getMeta(ShieldMeta.class);
        InventoryMeta inventory = (InventoryMeta) MetaContext.getMeta(InventoryMeta.class);
        ProfileMeta profile = (ProfileMeta) MetaContext.getMeta(ProfileMeta.class);
        profile.getLook().setInventory(inventory);
        wizard.setProfile(profile);

        wizard.setShield(expectedValue);

        String message = getSetterAssertMessage("setShield", "shield", inventory.getClassName());
        assertEquals(expectedValue, wizard.getProfile().getLook().getInventory().getLook().getShield(), message);
    }

    @DisplayName("Тест, что метод setLeftRing в классе Wizard сохраняет полученный IntelligenceRing в поле класса")
    @Test
    void testSetLeftRingSavesIntelligenceRingToField() {
        IntelligenceRingMeta expectedValue = (IntelligenceRingMeta) MetaContext.getMeta(IntelligenceRingMeta.class);
        wizard.setLeftRing(expectedValue);
        String message = getSetterAssertMessage("setLeftRing", "leftRing", getMeta().getClassName());
        assertEquals(expectedValue, wizard.getLeftRing(), message);
    }

    @DisplayName("Тест, что метод setLeftRing в классе Wizard добавляет очки кольца к соответствующей характеристике персонажа")
    @Test
    void testSetLeftRingAddsPoints() {
        int expectedValue = 8;
        IntelligenceRingMeta ring = (IntelligenceRingMeta) MetaContext.getMeta(IntelligenceRingMeta.class);
        ProfileMeta profile = createProfile();
        wizard.setProfile(profile);

        wizard.setLeftRing(ring);

        int actualValue = profile.getLook().getIntelligence();
        String message = getFieldValueAssert(getMeta().getClassName(), "setLeftRing", "intelligence",
                expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод setRightRing в классе Wizard сохраняет полученный IntelligenceRing в поле класса")
    @Test
    void testSetRightRingSavesIntelligenceRingToField() {
        IntelligenceRingMeta expectedValue = (IntelligenceRingMeta) MetaContext.getMeta(IntelligenceRingMeta.class);
        wizard.setRightRing(expectedValue);
        String message = getSetterAssertMessage("setRightRing", "rightRing", getMeta().getClassName());
        assertEquals(expectedValue, wizard.getRightRing(), message);
    }

    @DisplayName("Тест, что метод setRightRing в классе Wizard добавляет очки кольца к соответствующей характеристике персонажа")
    @Test
    void testSetRightRingAddsPoints() {
        int expectedValue = 8;
        IntelligenceRingMeta ring = (IntelligenceRingMeta) MetaContext.getMeta(IntelligenceRingMeta.class);
        ProfileMeta profile = createProfile();
        wizard.setProfile(profile);

        wizard.setRightRing(ring);

        int actualValue = profile.getLook().getIntelligence();
        String message = getFieldValueAssert(getMeta().getClassName(), "setRightRing", "intelligence",
                expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод setBelt в классе Wizard сохраняет полученный IntelligenceBelt в поле класса")
    @Test
    void testSetBeltSavesIntelligenceBeltToField() {
        IntelligenceBeltMeta expectedValue = (IntelligenceBeltMeta) MetaContext.getMeta(IntelligenceBeltMeta.class);
        wizard.setBelt(expectedValue);
        String message = getSetterAssertMessage("setBelt", "belt", getMeta().getClassName());
        assertEquals(expectedValue, wizard.getBelt(), message);
    }

    @DisplayName("Тест, что метод setBelt в классе Wizard добавляет очки кольца к соответствующей характеристике персонажа")
    @Test
    void testSetBeltAddsPoints() {
        int expectedValue = 8;
        IntelligenceBeltMeta belt = (IntelligenceBeltMeta) MetaContext.getMeta(IntelligenceBeltMeta.class);
        ProfileMeta profile = createProfile();
        wizard.setProfile(profile);

        wizard.setBelt(belt);

        int actualValue = profile.getLook().getIntelligence();
        String message = getFieldValueAssert(getMeta().getClassName(), "setBelt", "intelligence",
                expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод setNecklace в классе Wizard сохраняет полученный IntelligenceNecklace в поле класса")
    @Test
    void testSetNecklaceSavesIntelligenceNecklaceToField() {
        IntelligenceNecklaceMeta expectedValue = (IntelligenceNecklaceMeta) MetaContext.getMeta(IntelligenceNecklaceMeta.class);
        wizard.setNecklace(expectedValue);
        String message = getSetterAssertMessage("setNecklace", "belt", getMeta().getClassName());
        assertEquals(expectedValue, wizard.getNecklace(), message);
    }

    @DisplayName("Тест, что метод setNecklace в классе Wizard добавляет очки кольца к соответствующей характеристике персонажа")
    @Test
    void testSetNecklaceAddsPoints() {
        int expectedValue = 8;
        IntelligenceNecklaceMeta necklace = (IntelligenceNecklaceMeta) MetaContext.getMeta(IntelligenceNecklaceMeta.class);
        ProfileMeta profile = createProfile();
        wizard.setProfile(profile);

        wizard.setNecklace(necklace);

        int actualValue = profile.getLook().getIntelligence();
        String message = getFieldValueAssert(getMeta().getClassName(), "setNecklace", "intelligence",
                expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод setActiveQuest в классе Wizard сохраняет переданный Quest в поле класса")
    @Test
    void testSetActiveQuestSavesQuestToField() {
        QuestMeta expectedValue = (QuestMeta) MetaContext.getMeta(QuestMeta.class);
        wizard.setActiveQuest(expectedValue);
        String message = getSetterAssertMessage("setActiveQuest", "activeQuest", getMeta().getClassName());
        assertEquals(expectedValue, wizard.getActiveQuest(), message);
    }

    @DisplayName("Тест, что метод setSkill в классе Wizard сохраняет переданный Heal в поле класса")
    @Test
    void testSetSkillSavesSkillToField() {
        HealMeta expectedValue = (HealMeta) MetaContext.getMeta(HealMeta.class);
        wizard.setSkill(expectedValue);
        String message = getSetterAssertMessage("setSkill", "skill", getMeta().getClassName());
        assertEquals(expectedValue, wizard.getSkill(), message);
    }

    @DisplayName("Тест, что метод takeOffLeftRing в классе Wizard снимает левое кольцо")
    @Test
    void testTakeOffLeftRing() {
        IntelligenceRingMeta ring = (IntelligenceRingMeta) MetaContext.getMeta(IntelligenceRingMeta.class);
        wizard.setLeftRing(ring);

        wizard.takeOffLeftRing();

        IntelligenceRingMeta actualValue = wizard.getLeftRing();
        String message = getFieldValueAssert(getMeta().getClassName(), "takeOffLeftRing", "leftRing",
                null, actualValue);
        assertNull(actualValue, message);
    }

    @DisplayName("Тест, что метод takeOffLeftRing в классе Wizard отнимает от соответствующей характиристике количество очков предмета")
    @Test
    void testTakeOffLeftRingDecreasesCharacteristic() {
        int expectedValue = 7;
        IntelligenceRingMeta ring = (IntelligenceRingMeta) MetaContext.getMeta(IntelligenceRingMeta.class);
        ProfileMeta profile = createProfile();
        wizard.setProfile(profile);
        wizard.setLeftRing(ring);

        wizard.takeOffLeftRing();

        int actualValue = profile.getLook().getStrength();
        String message = getFieldValueAssert(getMeta().getClassName(), "takeOffLeftRing", "leftRing", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод takeOffRightRing в классе Wizard снимает левое кольцо")
    @Test
    void testTakeOffRightRing() {
        IntelligenceRingMeta ring = (IntelligenceRingMeta) MetaContext.getMeta(IntelligenceRingMeta.class);
        wizard.setRightRing(ring);

        wizard.takeOffRightRing();

        IntelligenceRingMeta actualValue = wizard.getRightRing();
        String message = getFieldValueAssert(getMeta().getClassName(), "takeOffRightRing", "rightRing",
                null, actualValue);
        assertNull(actualValue, message);
    }

    @DisplayName("Тест, что метод takeOffRightRing в классе Wizard отнимает от соответствующей характиристике количество очков предмета")
    @Test
    void testTakeOffRightRingDecreasesCharacteristic() {
        int expectedValue = 7;
        IntelligenceRingMeta ring = (IntelligenceRingMeta) MetaContext.getMeta(IntelligenceRingMeta.class);
        ProfileMeta profile = createProfile();
        wizard.setProfile(profile);
        wizard.setRightRing(ring);

        wizard.takeOffRightRing();

        int actualValue = profile.getLook().getStrength();
        String message = getFieldValueAssert(getMeta().getClassName(), "takeOffRightRing", "rightRing", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод takeOffBelt в классе Wizard снимает левое кольцо")
    @Test
    void testTakeOffBelt() {
        IntelligenceBeltMeta belt = (IntelligenceBeltMeta) MetaContext.getMeta(IntelligenceBeltMeta.class);
        wizard.setBelt(belt);

        wizard.takeOffBelt();

        IntelligenceBeltMeta actualValue = wizard.getBelt();
        String message = getFieldValueAssert(getMeta().getClassName(), "takeOffBelt", "belt",
                null, actualValue);
        assertNull(actualValue, message);
    }

    @DisplayName("Тест, что метод takeOffBelt в классе Wizard отнимает от соответствующей характиристике количество очков предмета")
    @Test
    void testTakeOffBeltDecreasesCharacteristic() {
        int expectedValue = 7;
        IntelligenceBeltMeta belt = (IntelligenceBeltMeta) MetaContext.getMeta(IntelligenceBeltMeta.class);
        ProfileMeta profile = createProfile();
        wizard.setProfile(profile);
        wizard.setBelt(belt);

        wizard.takeOffBelt();

        int actualValue = profile.getLook().getStrength();
        String message = getFieldValueAssert(getMeta().getClassName(), "takeOffBelt", "belt", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод takeOffNecklace в классе Wizard снимает левое кольцо")
    @Test
    void testTakeOffNecklace() {
        IntelligenceNecklaceMeta necklace = (IntelligenceNecklaceMeta) MetaContext.getMeta(IntelligenceNecklaceMeta.class);
        wizard.setNecklace(necklace);

        wizard.takeOffNecklace();

        IntelligenceNecklaceMeta actualValue = wizard.getNecklace();
        String message = getFieldValueAssert(getMeta().getClassName(), "takeOffNecklace", "necklace",
                null, actualValue);
        assertNull(actualValue, message);
    }

    @DisplayName("Тест, что метод takeOffNecklace в классе Wizard отнимает от соответствующей характиристике количество очков предмета")
    @Test
    void testTakeOffNecklaceDecreasesCharacteristic() {
        int expectedValue = 7;
        IntelligenceNecklaceMeta necklace = (IntelligenceNecklaceMeta) MetaContext.getMeta(IntelligenceNecklaceMeta.class);
        ProfileMeta profile = createProfile();
        wizard.setProfile(profile);
        wizard.setNecklace(necklace);

        wizard.takeOffNecklace();

        int actualValue = profile.getLook().getStrength();
        String message = getFieldValueAssert(getMeta().getClassName(), "takeOffNecklace", "necklace", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getHelmet в классе Wizard возвращает шлем персонажа")
    @Test
    void testGetHelmet() {
        HelmetMeta expectedValue = (HelmetMeta) MetaContext.getMeta(HelmetMeta.class);
        ProfileMeta profile = createProfile();
        wizard.setProfile(profile);
        wizard.setHelmet(expectedValue);
        HelmetMeta actualValue = wizard.getHelmet();
        String message = getMethodReturnResultAssertMessage("getHelmet", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getCuirass в классе Wizard возвращает кирасу персонажа")
    @Test
    void testGetCuirass() {
        CuirassMeta expectedValue = (CuirassMeta) MetaContext.getMeta(CuirassMeta.class);
        ProfileMeta profile = createProfile();
        wizard.setProfile(profile);
        wizard.setCuirass(expectedValue);
        CuirassMeta actualValue = wizard.getCuirass();
        String message = getMethodReturnResultAssertMessage("getCuirass", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getGloves в классе Wizard возвращает перчатки персонажа")
    @Test
    void testGetGloves() {
        GlovesMeta expectedValue = (GlovesMeta) MetaContext.getMeta(GlovesMeta.class);
        ProfileMeta profile = createProfile();
        wizard.setProfile(profile);
        wizard.setGloves(expectedValue);
        GlovesMeta actualValue = wizard.getGloves();
        String message = getMethodReturnResultAssertMessage("getGloves", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getBoots в классе Wizard возвращает сапоги персонажа")
    @Test
    void testGetBoots() {
        BootsMeta expectedValue = (BootsMeta) MetaContext.getMeta(BootsMeta.class);
        ProfileMeta profile = createProfile();
        wizard.setProfile(profile);
        wizard.setBoots(expectedValue);
        BootsMeta actualValue = wizard.getBoots();
        String message = getMethodReturnResultAssertMessage("getBoots", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getShield в классе Wizard возвращает щит персонажа")
    @Test
    void testGetShield() {
        ShieldMeta expectedValue = (ShieldMeta) MetaContext.getMeta(ShieldMeta.class);
        ProfileMeta profile = createProfile();
        wizard.setProfile(profile);
        wizard.setShield(expectedValue);
        ShieldMeta actualValue = wizard.getShield();
        String message = getMethodReturnResultAssertMessage("getShield", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getPoint в классе Wizard возвращает точку персонажа")
    @Test
    void testGetPoint() {
        int expectedX = 0;
        int expectedY = 0;
        PointMeta point = wizard.getPoint();
        int actualX = point.getLook().getX();
        int actualY = point.getLook().getY();
        String messageX = getCoordinatesAssertMessage("x", expectedX, actualX);
        String messageY = getCoordinatesAssertMessage("y", expectedY, actualY);
        assertEquals(expectedX, actualX, messageX);
        assertEquals(expectedY, actualY, messageY);
    }

    @DisplayName("Тест, что метод getActiveQuest в классе Wizard возвращает задание персонажа")
    @Test
    void testGetActiveQuest() {
        QuestMeta expectedValue = (QuestMeta) MetaContext.getMeta(QuestMeta.class);
        wizard.setActiveQuest(expectedValue);
        QuestMeta actualValue = wizard.getActiveQuest();
        String message = getMethodReturnResultAssertMessage("getActiveQuest", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getStaff в классе Wizard возвращает оружие персонажа")
    @Test
    void testGetStaff() {
        StaffMeta expectedValue = (StaffMeta) MetaContext.getMeta(StaffMeta.class);
        wizard.setStaff(expectedValue);
        StaffMeta actualValue = wizard.getStaff();
        String message = getMethodReturnResultAssertMessage("getStaff", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getLeftRing в классе Wizard возвращает левое кольцо персонажа")
    @Test
    void testGetLeftRing() {
        IntelligenceRingMeta expectedValue = (IntelligenceRingMeta) MetaContext.getMeta(IntelligenceRingMeta.class);
        wizard.setLeftRing(expectedValue);
        IntelligenceRingMeta actualValue = wizard.getLeftRing();
        String message = getMethodReturnResultAssertMessage("getLeftRing", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getRightRing в классе Wizard возвращает правое кольцо персонажа")
    @Test
    void testGetRightRing() {
        IntelligenceRingMeta expectedValue = (IntelligenceRingMeta) MetaContext.getMeta(IntelligenceRingMeta.class);
        wizard.setRightRing(expectedValue);
        IntelligenceRingMeta actualValue = wizard.getRightRing();
        String message = getMethodReturnResultAssertMessage("getRightRing", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getBelt в классе Wizard возвращает ремень персонажа")
    @Test
    void testGetBelt() {
        IntelligenceBeltMeta expectedValue = (IntelligenceBeltMeta) MetaContext.getMeta(IntelligenceBeltMeta.class);
        wizard.setBelt(expectedValue);
        IntelligenceBeltMeta actualValue = wizard.getBelt();
        String message = getMethodReturnResultAssertMessage("getBelt", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getNecklace в классе Wizard возвращает ожерелье персонажа")
    @Test
    void testGetNecklace() {
        IntelligenceNecklaceMeta expectedValue = (IntelligenceNecklaceMeta) MetaContext.getMeta(IntelligenceNecklaceMeta.class);
        wizard.setNecklace(expectedValue);
        IntelligenceNecklaceMeta actualValue = wizard.getNecklace();
        String message = getMethodReturnResultAssertMessage("getNecklace", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getSkill в классе Wizard возвращает навык персонажа")
    @Test
    void testGetSkill() {
        HealMeta expectedValue = (HealMeta) MetaContext.getMeta(HealMeta.class);
        wizard.setSkill(expectedValue);
        HealMeta actualValue = wizard.getSkill();
        String message = getMethodReturnResultAssertMessage("getSkill", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод setProfile в классе Wizard сохраняет профиль персонажа в поле класса")
    @Test
    void testSetProfile() {
        ProfileMeta expectedValue = (ProfileMeta) MetaContext.getMeta(ProfileMeta.class);
        wizard.setProfile(expectedValue);
        String message = getSetterAssertMessage("setProfile", "profile", getMeta().getClassName());
        assertEquals(expectedValue, wizard.getProfile(), message);
    }

    @DisplayName("Тест, что метод getProfile в классе Wizard возвращает профиль персонажа")
    @Test
    void testGetProfile() {
        ProfileMeta expectedValue = (ProfileMeta) MetaContext.getMeta(ProfileMeta.class);
        wizard.setProfile(expectedValue);
        ProfileMeta actualValue = wizard.getProfile();
        String message = getMethodReturnResultAssertMessage("getProfile", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод castSkill в классе Wizard применяет Heal к переданному Wizard")
    @Test
    void testCastSkill() {
        int expectedHp = 110;
        int expectedMana = 99;
        HealMeta skill = (HealMeta) MetaContext.getMeta(HealMeta.class);
        wizard.setSkill(skill);
        ProfileMeta profile = createProfile();
        wizard.setProfile(profile);
        KnightMeta knight = (KnightMeta) MetaContext.getMeta(KnightMeta.class);
        knight.getLook().setProfile(profile);

        wizard.castSkill(knight);

        int actualHp = profile.getLook().getHp();
        int actualMana = profile.getLook().getMana();
        String hpMessage = getFieldValueAssert(knight.getClassName(), "castSkill", "hp", expectedHp, actualHp);
        String manaMessage = getFieldValueAssert(getMeta().getClassName(), "castSkill", "mana", expectedMana, actualMana);
        assertEquals(expectedHp, actualHp, hpMessage);
        assertEquals(expectedMana, actualMana, manaMessage);
    }

    @DisplayName("Тест, что метод eat в классе Wizard добавляет здоровье в количестве очков восстановления яблока")
    @Test
    void testEatMethod() {
        int points = 5;
        int expectedValue = 100 + points;
        AppleMeta apple = (AppleMeta) MetaContext.getMeta(AppleMeta.class);
        apple.getLook().setPointsToRecover(points);
        ProfileMeta profile = createProfile();
        wizard.setProfile(profile);

        wizard.eat(apple);

        int actualValue = profile.getLook().getHp();
        String message = getFieldValueAssert(getMeta().getClassName(), "eat", "hp", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }
}
