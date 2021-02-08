package com.idoit.character;

import com.idoit.MessageUtil;
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
import com.idoit.meta.item.common.food.AppleMeta;
import com.idoit.meta.item.weapon.BowMeta;
import com.idoit.meta.profile.InventoryMeta;
import com.idoit.meta.profile.ProfileMeta;
import com.idoit.meta.quest.QuestMeta;
import com.idoit.meta.skill.AccurateShotMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("Тесты логики в классе Archer")
class ArcherTest extends CharacterTest {

    private ArcherMeta.ArcherLook archer;

    @BeforeEach
	void setUp() {
        setMeta(ArcherMeta.class);
        ArcherMeta meta = (ArcherMeta) getMeta();
        archer = meta.getLook();
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
        testConstructorSetsValuesToProfile();
    }

    @DisplayName("Тест, что в классе Archer есть все необходимые методы")
    @Test
    void testArcherHasAllMethods() {
        testClassHasAllMethods();
    }

    @DisplayName("Тест, что метод hit в классе Archer уменьшает хп противника на 10")
    @Test
    void testHitDecreasesEnemyHp() {
        int expectedValue = 90;
        ProfileMeta profile = createProfile();
        KnightMeta knight = createKnightWith(profile);
        BowMeta bow = (BowMeta) MetaContext.getMeta(BowMeta.class);
        archer.setBow(bow);

        archer.hit(knight);

        int actualValue = profile.getLook().getHp();
        String message = MessageUtil.formatAssertMessage(
                String.format("После вызова метода hit переданная цель должна иметь %d хп", expectedValue),
                String.format("После вызова метода hit переданная цель имеет %d хп", actualValue)
        );
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод hit в классе Archer уменьшает прочность оружия на 1")
    @Test
    void testHitDecreasesWeaponDurability() {
        int expectedValue = 99;
        ProfileMeta profile = createProfile();
        KnightMeta knight = createKnightWith(profile);
        BowMeta bow = (BowMeta) MetaContext.getMeta(BowMeta.class);
        bow.refresh();
        archer.setBow(bow);

        archer.hit(knight);

        int actualValue = bow.getLook().getDurability();
        String message = MessageUtil.formatAssertMessage(
                String.format("После вызова метода hit оружние бьющего должно иметь %d прочности", expectedValue),
                String.format("После вызова метода hit оружние бьющего имеет %d прочности", actualValue)
        );
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод hit в классе Archer уменьшает выносливость персонажа на 10")
    @Test
    void testHitDecreasesStamina() {
        int expectedValue = 90;
        ProfileMeta profile = createProfile();
        KnightMeta knight = createKnightWith(profile);
        BowMeta bow = (BowMeta) MetaContext.getMeta(BowMeta.class);
        archer.setBow(bow);
        archer.setProfile(profile);

        archer.hit(knight);

        int actualValue = profile.getLook().getStamina();
        String message = MessageUtil.formatAssertMessage(
                String.format("После вызова метода hit персонаж должен иметь %d выносливости", expectedValue),
                String.format("После вызова метода hit персонаж имеет %d выносливости", actualValue)
        );
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод go в классе Archer меняет координаты точки персонажа")
    @Test
    void testGoChangesPointCoordinates() {
        int expectedX = 5;
        int expectedY = 6;

        archer.go(expectedX, expectedY);

        int actualX = archer.getPoint().getLook().getX();
        int actualY = archer.getPoint().getLook().getY();
        assertEquals(expectedX, actualX, getGoAssertMessage("x", expectedX, actualX));
        assertEquals(expectedY, actualY, getGoAssertMessage("y", expectedY, actualY));
    }

    @DisplayName("Тест, что метод setBow в классе Archer сохраняет переданный Bow в поле класса")
    @Test
    void testSetBowSavesBowToField() {
        BowMeta expectedValue = (BowMeta) MetaContext.getMeta(BowMeta.class);
        archer.setBow(expectedValue);
        String message = getSetterAssertMessage("setBow", "bow", getMeta().getClassName());
        assertEquals(expectedValue, archer.getBow(), message);
    }

    @DisplayName("Тест, что метод setHelmet в классе Archer сохраняет полученный Helmet в поле класса")
    @Test
    void testSetHelmetSavesHelmetToField() {
        HelmetMeta expectedValue = (HelmetMeta) MetaContext.getMeta(HelmetMeta.class);
        InventoryMeta inventory = (InventoryMeta) MetaContext.getMeta(InventoryMeta.class);
        ProfileMeta profile = (ProfileMeta) MetaContext.getMeta(ProfileMeta.class);
        profile.getLook().setInventory(inventory);

        archer.setHelmet(expectedValue);

        String message = getSetterAssertMessage("setHelmet", "helmet", inventory.getClassName());
        assertEquals(expectedValue, archer.getProfile().getLook().getInventory().getLook().getHelmet(), message);
    }

    @DisplayName("Тест, что метод setCuirass в классе Archer сохраняет полученный Cuirass в поле класса")
    @Test
    void testSetCuirassSavesCuirassToField() {
        CuirassMeta expectedValue = (CuirassMeta) MetaContext.getMeta(CuirassMeta.class);
        InventoryMeta inventory = (InventoryMeta) MetaContext.getMeta(InventoryMeta.class);
        ProfileMeta profile = (ProfileMeta) MetaContext.getMeta(ProfileMeta.class);
        profile.getLook().setInventory(inventory);

        archer.setCuirass(expectedValue);

        String message = getSetterAssertMessage("setCuirass", "cuirass", inventory.getClassName());
        assertEquals(expectedValue, archer.getProfile().getLook().getInventory().getLook().getCuirass(), message);
    }

    @DisplayName("Тест, что метод setGloves в классе Archer сохраняет полученный Gloves в поле класса")
    @Test
    void testSetGlovesSavesGlovesToField() {
        GlovesMeta expectedValue = (GlovesMeta) MetaContext.getMeta(GlovesMeta.class);
        InventoryMeta inventory = (InventoryMeta) MetaContext.getMeta(InventoryMeta.class);
        ProfileMeta profile = (ProfileMeta) MetaContext.getMeta(ProfileMeta.class);
        profile.getLook().setInventory(inventory);

        archer.setGloves(expectedValue);

        String message = getSetterAssertMessage("setGloves", "gloves", inventory.getClassName());
        assertEquals(expectedValue, archer.getProfile().getLook().getInventory().getLook().getGloves(), message);
    }

    @DisplayName("Тест, что метод setBoots в классе Archer сохраняет полученный Boots в поле класса")
    @Test
    void testSetBootsSavesBootsToField() {
        BootsMeta expectedValue = (BootsMeta) MetaContext.getMeta(BootsMeta.class);
        InventoryMeta inventory = (InventoryMeta) MetaContext.getMeta(InventoryMeta.class);
        ProfileMeta profile = (ProfileMeta) MetaContext.getMeta(ProfileMeta.class);
        profile.getLook().setInventory(inventory);

        archer.setBoots(expectedValue);

        String message = getSetterAssertMessage("setBoots", "boots", inventory.getClassName());
        assertEquals(expectedValue, archer.getProfile().getLook().getInventory().getLook().getBoots(), message);
    }

    @DisplayName("Тест, что метод setShield в классе Archer сохраняет полученный Shield в поле класса")
    @Test
    void testSetShieldSavesShieldToField() {
        ShieldMeta expectedValue = (ShieldMeta) MetaContext.getMeta(ShieldMeta.class);
        InventoryMeta inventory = (InventoryMeta) MetaContext.getMeta(InventoryMeta.class);
        ProfileMeta profile = (ProfileMeta) MetaContext.getMeta(ProfileMeta.class);
        profile.getLook().setInventory(inventory);

        archer.setShield(expectedValue);

        String message = getSetterAssertMessage("setShield", "shield", inventory.getClassName());
        assertEquals(expectedValue, archer.getProfile().getLook().getInventory().getLook().getShield(), message);
    }

    @DisplayName("Тест, что метод setLeftRing в классе Archer сохраняет полученный AgilityRing в поле класса")
    @Test
    void testSetLeftRingSavesAgilityRingToField() {
        AgilityRingMeta expectedValue = (AgilityRingMeta) MetaContext.getMeta(AgilityRingMeta.class);
        archer.setLeftRing(expectedValue);
        String message = getSetterAssertMessage("setLeftRing", "leftRing", getMeta().getClassName());
        assertEquals(expectedValue, archer.getLeftRing(), message);
    }

    @DisplayName("Тест, что метод setLeftRing в классе Archer добавляет очки кольца к соответствующей характеристике персонажа")
    @Test
    void testSetLeftRingAddsPoints() {
        int expectedValue = 8;
        AgilityRingMeta ring = (AgilityRingMeta) MetaContext.getMeta(AgilityRingMeta.class);
        ProfileMeta profile = createProfile();
        archer.setProfile(profile);

        archer.setLeftRing(ring);

        int actualValue = profile.getLook().getAgility();
        String message = getFieldValueAssert(getMeta().getClassName(), "setLeftRing", "agility",
                expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод setRightRing в классе Archer сохраняет полученный AgilityRing в поле класса")
    @Test
    void testSetRightRingSavesAgilityRingToField() {
        AgilityRingMeta expectedValue = (AgilityRingMeta) MetaContext.getMeta(AgilityRingMeta.class);
        archer.setRightRing(expectedValue);
        String message = getSetterAssertMessage("setRightRing", "rightRing", getMeta().getClassName());
        assertEquals(expectedValue, archer.getRightRing(), message);
    }

    @DisplayName("Тест, что метод setRightRing в классе Archer добавляет очки кольца к соответствующей характеристике персонажа")
    @Test
    void testSetRightRingAddsPoints() {
        int expectedValue = 8;
        AgilityRingMeta ring = (AgilityRingMeta) MetaContext.getMeta(AgilityRingMeta.class);
        ProfileMeta profile = createProfile();
        archer.setProfile(profile);

        archer.setRightRing(ring);

        int actualValue = profile.getLook().getAgility();
        String message = getFieldValueAssert(getMeta().getClassName(), "setRightRing", "agility",
                expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод setBelt в классе Archer сохраняет полученный AgilityBelt в поле класса")
    @Test
    void testSetBeltSavesAgilityBeltToField() {
        AgilityBeltMeta expectedValue = (AgilityBeltMeta) MetaContext.getMeta(AgilityBeltMeta.class);
        archer.setBelt(expectedValue);
        String message = getSetterAssertMessage("setBelt", "belt", getMeta().getClassName());
        assertEquals(expectedValue, archer.getBelt(), message);
    }

    @DisplayName("Тест, что метод setBelt в классе Archer добавляет очки кольца к соответствующей характеристике персонажа")
    @Test
    void testSetBeltAddsPoints() {
        int expectedValue = 8;
        AgilityBeltMeta belt = (AgilityBeltMeta) MetaContext.getMeta(AgilityBeltMeta.class);
        ProfileMeta profile = createProfile();
        archer.setProfile(profile);

        archer.setBelt(belt);

        int actualValue = profile.getLook().getAgility();
        String message = getFieldValueAssert(getMeta().getClassName(), "setBelt", "agility",
                expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод setNecklace в классе Archer сохраняет полученный AgilityNecklace в поле класса")
    @Test
    void testSetNecklaceSavesAgilityNecklaceToField() {
        AgilityNecklaceMeta expectedValue = (AgilityNecklaceMeta) MetaContext.getMeta(AgilityNecklaceMeta.class);
        archer.setNecklace(expectedValue);
        String message = getSetterAssertMessage("setNecklace", "necklace", getMeta().getClassName());
        assertEquals(expectedValue, archer.getNecklace(), message);
    }

    @DisplayName("Тест, что метод setNecklace в классе Archer добавляет очки кольца к соответствующей характеристике персонажа")
    @Test
    void testSetNecklaceAddsPoints() {
        int expectedValue = 8;
        AgilityNecklaceMeta necklace = (AgilityNecklaceMeta) MetaContext.getMeta(AgilityNecklaceMeta.class);
        ProfileMeta profile = createProfile();
        archer.setProfile(profile);

        archer.setNecklace(necklace);

        int actualValue = profile.getLook().getAgility();
        String message = getFieldValueAssert(getMeta().getClassName(), "setNecklace", "agility",
                expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод setActiveQuest в классе Archer сохраняет переданный Quest в поле класса")
    @Test
    void testSetActiveQuestSavesQuestToField() {
        QuestMeta expectedValue = (QuestMeta) MetaContext.getMeta(QuestMeta.class);
        archer.setActiveQuest(expectedValue);
        String message = getSetterAssertMessage("setActiveQuest", "activeQuest", getMeta().getClassName());
        assertEquals(expectedValue, archer.getActiveQuest(), message);
    }

    @DisplayName("Тест, что метод setSkill в классе Archer сохраняет переданный AccurateShot в поле класса")
    @Test
    void testSetSkillSavesSkillToField() {
        AccurateShotMeta expectedValue = (AccurateShotMeta) MetaContext.getMeta(AccurateShotMeta.class);
        archer.setSkill(expectedValue);
        String message = getSetterAssertMessage("setSkill", "skill", getMeta().getClassName());
        assertEquals(expectedValue, archer.getSkill(), message);
    }

    @DisplayName("Тест, что метод takeOffLeftRing в классе Archer снимает левое кольцо")
    @Test
    void testTakeOffLeftRing() {
        AgilityRingMeta ring = (AgilityRingMeta) MetaContext.getMeta(AgilityRingMeta.class);
        archer.setLeftRing(ring);

        archer.takeOffLeftRing();

        AgilityRingMeta actualValue = archer.getLeftRing();
        String message = getFieldValueAssert(getMeta().getClassName(), "takeOffLeftRing", "leftRing",
                null, actualValue);
        assertNull(actualValue, message);
    }

    @DisplayName("Тест, что метод takeOffLeftRing в классе Archer отнимает от соответствующей характиристике количество очков предмета")
    @Test
    void testTakeOffLeftRingDecreasesCharacteristic() {
        int expectedValue = 7;
        AgilityRingMeta ring = (AgilityRingMeta) MetaContext.getMeta(AgilityRingMeta.class);
        ProfileMeta profile = createProfile();
        archer.setProfile(profile);
        archer.setLeftRing(ring);

        archer.takeOffLeftRing();

        int actualValue = profile.getLook().getAgility();
        String message = getFieldValueAssert(getMeta().getClassName(), "takeOffLeftRing", "leftRing", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод takeOffRightRing в классе Archer снимает левое кольцо")
    @Test
    void testTakeOffRightRing() {
        AgilityRingMeta ring = (AgilityRingMeta) MetaContext.getMeta(AgilityRingMeta.class);
        archer.setRightRing(ring);

        archer.takeOffRightRing();

        AgilityRingMeta actualValue = archer.getRightRing();
        String message = getFieldValueAssert(getMeta().getClassName(), "takeOffRightRing", "rightRing",
                null, actualValue);
        assertNull(actualValue, message);
    }

    @DisplayName("Тест, что метод takeOffRightRing в классе Archer отнимает от соответствующей характиристике количество очков предмета")
    @Test
    void testTakeOffRightRingDecreasesCharacteristic() {
        int expectedValue = 7;
        AgilityRingMeta ring = (AgilityRingMeta) MetaContext.getMeta(AgilityRingMeta.class);
        ProfileMeta profile = createProfile();
        archer.setProfile(profile);
        archer.setRightRing(ring);

        archer.takeOffRightRing();

        int actualValue = profile.getLook().getAgility();
        String message = getFieldValueAssert(getMeta().getClassName(), "takeOffRightRing", "rightRing", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод takeOffBelt в классе Archer снимает левое кольцо")
    @Test
    void testTakeOffBelt() {
        AgilityBeltMeta belt = (AgilityBeltMeta) MetaContext.getMeta(AgilityBeltMeta.class);
        archer.setBelt(belt);

        archer.takeOffBelt();

        AgilityBeltMeta actualValue = archer.getBelt();
        String message = getFieldValueAssert(getMeta().getClassName(), "takeOffBelt", "belt",
                null, actualValue);
        assertNull(actualValue, message);
    }

    @DisplayName("Тест, что метод takeOffBelt в классе Archer отнимает от соответствующей характиристике количество очков предмета")
    @Test
    void testTakeOffBeltDecreasesCharacteristic() {
        int expectedValue = 7;
        AgilityBeltMeta belt = (AgilityBeltMeta) MetaContext.getMeta(AgilityBeltMeta.class);
        ProfileMeta profile = createProfile();
        archer.setProfile(profile);
        archer.setBelt(belt);

        archer.takeOffBelt();

        int actualValue = profile.getLook().getAgility();
        String message = getFieldValueAssert(getMeta().getClassName(), "takeOffBelt", "belt", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод takeOffNecklace в классе Archer снимает левое кольцо")
    @Test
    void testTakeOffNecklace() {
        AgilityNecklaceMeta necklace = (AgilityNecklaceMeta) MetaContext.getMeta(AgilityNecklaceMeta.class);
        archer.setNecklace(necklace);

        archer.takeOffNecklace();

        AgilityNecklaceMeta actualValue = archer.getNecklace();
        String message = getFieldValueAssert(getMeta().getClassName(), "takeOffNecklace", "necklace",
                null, actualValue);
        assertNull(actualValue, message);
    }

    @DisplayName("Тест, что метод takeOffNecklace в классе Archer отнимает от соответствующей характиристике количество очков предмета")
    @Test
    void testTakeOffNecklaceDecreasesCharacteristic() {
        int expectedValue = 7;
        AgilityNecklaceMeta necklace = (AgilityNecklaceMeta) MetaContext.getMeta(AgilityNecklaceMeta.class);
        ProfileMeta profile = createProfile();
        archer.setProfile(profile);
        archer.setNecklace(necklace);

        archer.takeOffNecklace();

        int actualValue = profile.getLook().getAgility();
        String message = getFieldValueAssert(getMeta().getClassName(), "takeOffNecklace", "necklace", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getHelmet в классе Archer возвращает шлем персонажа")
    @Test
    void testGetHelmet() {
        HelmetMeta expectedValue = (HelmetMeta) MetaContext.getMeta(HelmetMeta.class);
        archer.setHelmet(expectedValue);
        HelmetMeta actualValue = archer.getHelmet();
        String message = getMethodReturnResultAssertMessage("getHelmet", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getCuirass в классе Archer возвращает кирасу персонажа")
    @Test
    void testGetCuirass() {
        CuirassMeta expectedValue = (CuirassMeta) MetaContext.getMeta(CuirassMeta.class);
        archer.setCuirass(expectedValue);
        CuirassMeta actualValue = archer.getCuirass();
        String message = getMethodReturnResultAssertMessage("getCuirass", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getGloves в классе Archer возвращает перчатки персонажа")
    @Test
    void testGetGloves() {
        GlovesMeta expectedValue = (GlovesMeta) MetaContext.getMeta(GlovesMeta.class);
        archer.setGloves(expectedValue);
        GlovesMeta actualValue = archer.getGloves();
        String message = getMethodReturnResultAssertMessage("getGloves", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getBoots в классе Archer возвращает сапоги персонажа")
    @Test
    void testGetBoots() {
        ProfileMeta profile = (ProfileMeta) MetaContext.getMeta(ProfileMeta.class);
        InventoryMeta inventory = (InventoryMeta) MetaContext.getMeta(InventoryMeta.class);
        profile.getLook().setInventory(inventory);
        archer.setProfile(profile);
        BootsMeta expectedValue = (BootsMeta) MetaContext.getMeta(BootsMeta.class);
        archer.setBoots(expectedValue);
        BootsMeta actualValue = archer.getBoots();
        String message = getMethodReturnResultAssertMessage("getBoots", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getShield в классе Archer возвращает щит персонажа")
    @Test
    void testGetShield() {
        ShieldMeta expectedValue = (ShieldMeta) MetaContext.getMeta(ShieldMeta.class);
        archer.setShield(expectedValue);
        ShieldMeta actualValue = archer.getShield();
        String message = getMethodReturnResultAssertMessage("getShield", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getPoint в классе Archer возвращает точку персонажа")
    @Test
    void testGetPoint() {
        int expectedX = 0;
        int expectedY = 0;
        PointMeta point = archer.getPoint();
        int actualX = point.getLook().getX();
        int actualY = point.getLook().getY();
        String messageX = getCoordinatesAssertMessage("x", expectedX, actualX);
        String messageY = getCoordinatesAssertMessage("y", expectedY, actualY);
        assertEquals(expectedX, actualX, messageX);
        assertEquals(expectedY, actualY, messageY);
    }

    @DisplayName("Тест, что метод getActiveQuest в классе Archer возвращает задание персонажа")
    @Test
    void testGetActiveQuest() {
        QuestMeta expectedValue = (QuestMeta) MetaContext.getMeta(QuestMeta.class);
        archer.setActiveQuest(expectedValue);
        QuestMeta actualValue = archer.getActiveQuest();
        String message = getMethodReturnResultAssertMessage("getActiveQuest", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getBow в классе Archer возвращает оружие персонажа")
    @Test
    void testGetBow() {
        BowMeta expectedValue = (BowMeta) MetaContext.getMeta(BowMeta.class);
        archer.setBow(expectedValue);
        BowMeta actualValue = archer.getBow();
        String message = getMethodReturnResultAssertMessage("getBow", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getLeftRing в классе Archer возвращает левое кольцо персонажа")
    @Test
    void testGetLeftRing() {
        AgilityRingMeta expectedValue = (AgilityRingMeta) MetaContext.getMeta(AgilityRingMeta.class);
        archer.setLeftRing(expectedValue);
        AgilityRingMeta actualValue = archer.getLeftRing();
        String message = getMethodReturnResultAssertMessage("getLeftRing", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getRightRing в классе Archer возвращает правое кольцо персонажа")
    @Test
    void testGetRightRing() {
        AgilityRingMeta expectedValue = (AgilityRingMeta) MetaContext.getMeta(AgilityRingMeta.class);
        archer.setRightRing(expectedValue);
        AgilityRingMeta actualValue = archer.getRightRing();
        String message = getMethodReturnResultAssertMessage("getRightRing", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getBelt в классе Archer возвращает ремень персонажа")
    @Test
    void testGetBelt() {
        AgilityBeltMeta expectedValue = (AgilityBeltMeta) MetaContext.getMeta(AgilityBeltMeta.class);
        archer.setBelt(expectedValue);
        AgilityBeltMeta actualValue = archer.getBelt();
        String message = getMethodReturnResultAssertMessage("getBelt", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getNecklace в классе Archer возвращает ожерелье персонажа")
    @Test
    void testGetNecklace() {
        AgilityNecklaceMeta expectedValue = (AgilityNecklaceMeta) MetaContext.getMeta(AgilityNecklaceMeta.class);
        archer.setNecklace(expectedValue);
        AgilityNecklaceMeta actualValue = archer.getNecklace();
        String message = getMethodReturnResultAssertMessage("getNecklace", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getSkill в классе Archer возвращает навык персонажа")
    @Test
    void testGetSkill() {
        AccurateShotMeta expectedValue = (AccurateShotMeta) MetaContext.getMeta(AccurateShotMeta.class);
        archer.setSkill(expectedValue);
        AccurateShotMeta actualValue = archer.getSkill();
        String message = getMethodReturnResultAssertMessage("getSkill", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод setProfile в классе Archer сохраняет профиль персонажа в поле класса")
    @Test
    void testSetProfile() {
        ProfileMeta expectedValue = (ProfileMeta) MetaContext.getMeta(ProfileMeta.class);
        archer.setProfile(expectedValue);
        String message = getSetterAssertMessage("setProfile", "profile", getMeta().getClassName());
        assertEquals(expectedValue, archer.getProfile(), message);
    }

    @DisplayName("Тест, что метод getProfile в классе Archer возвращает профиль персонажа")
    @Test
    void testGetProfile() {
        ProfileMeta expectedValue = (ProfileMeta) MetaContext.getMeta(ProfileMeta.class);
        archer.setProfile(expectedValue);
        ProfileMeta actualValue = archer.getProfile();
        String message = getMethodReturnResultAssertMessage("getProfile", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод castSkill в классе Archer наносит двойной урон переданному Archer")
    @Test
    void testCastSkill() {
        int expectedHp = 98;
        int expectedMana = 99;
        AccurateShotMeta skill = (AccurateShotMeta) MetaContext.getMeta(AccurateShotMeta.class);
        archer.setSkill(skill);
        ProfileMeta profile = createProfile();
        KnightMeta knight = (KnightMeta) MetaContext.getMeta(KnightMeta.class);
        knight.getLook().setProfile(profile);
        BowMeta bow = (BowMeta) MetaContext.getMeta(BowMeta.class);
        archer.setBow(bow);
        archer.setProfile(profile);

        archer.castSkill(knight);

        int actualHp = profile.getLook().getHp();
        int actualMana = profile.getLook().getMana();
        String hpMessage = getFieldValueAssert(knight.getClassName(), "castSkill", "hp", expectedHp, actualHp);
        String manaMessage = getFieldValueAssert(getMeta().getClassName(), "castSkill", "mana", expectedMana, actualMana);
        assertEquals(expectedHp, actualHp, hpMessage);
        assertEquals(expectedMana, actualMana, manaMessage);
    }

    @DisplayName("Тест, что метод eat в классе Archer добавляет здоровье в количестве очков восстановления яблока")
    @Test
    void testEatMethod() {
        int points = 5;
        int expectedValue = 100 + points;
        AppleMeta apple = (AppleMeta) MetaContext.getMeta(AppleMeta.class);
        apple.getLook().setPointsToRecover(points);
        ProfileMeta profile = createProfile();
        archer.setProfile(profile);

        archer.eat(apple);

        int actualValue = profile.getLook().getHp();
        String message = getFieldValueAssert(getMeta().getClassName(), "eat", "hp", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }
}