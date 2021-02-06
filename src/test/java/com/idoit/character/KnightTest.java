package com.idoit.character;

import com.idoit.MessageUtil;
import com.idoit.meta.MetaContext;
import com.idoit.meta.battlefield.PointMeta;
import com.idoit.meta.character.KnightMeta;
import com.idoit.meta.character.npc.NPCMeta;
import com.idoit.meta.character.npc.seller.BlacksmithMeta;
import com.idoit.meta.item.armor.BootsMeta;
import com.idoit.meta.item.armor.CuirassMeta;
import com.idoit.meta.item.armor.GlovesMeta;
import com.idoit.meta.item.armor.HelmetMeta;
import com.idoit.meta.item.armor.ShieldMeta;
import com.idoit.meta.item.bijouterie.belt.StrengthBeltMeta;
import com.idoit.meta.item.bijouterie.necklace.StrengthNecklaceMeta;
import com.idoit.meta.item.bijouterie.ring.StrengthRingMeta;
import com.idoit.meta.item.common.food.AppleMeta;
import com.idoit.meta.item.common.potion.HpPotionMeta;
import com.idoit.meta.item.weapon.SwordMeta;
import com.idoit.meta.profile.InventoryMeta;
import com.idoit.meta.profile.ProfileMeta;
import com.idoit.meta.quest.QuestMeta;
import com.idoit.meta.skill.RageMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("Тесты логики в классе Knight")
class KnightTest extends CharacterTest {

    private KnightMeta.KnightLook knight;

    @BeforeEach
	void setUp() {
        setMeta(KnightMeta.class);
        KnightMeta meta = (KnightMeta) getMeta();
        meta.setLook(null);
        knight = meta.getLook();
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
        int expectedValue = 90;
        ProfileMeta profile = createProfile();
        KnightMeta enemy = new KnightMeta();
        enemy.getLook().setProfile(profile);
        SwordMeta sword = (SwordMeta) MetaContext.getMeta(SwordMeta.class);
        knight.setProfile(profile);
        knight.setSword(sword);

        knight.hit(enemy);

        int actualValue = profile.getLook().getHp();
        String message = MessageUtil.formatAssertMessage(
                String.format("После вызова метода hit переданная цель должна иметь %d хп", expectedValue),
                String.format("После вызова метода hit переданная цель имеет %d хп", actualValue)
        );
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод hit в классе Knight уменьшает прочность оружия на 1")
    @Test
    void testHitDecreasesWeaponDurability() {
        int expectedValue = 99;
        ProfileMeta profile = createProfile();
        KnightMeta enemy = new KnightMeta();
        enemy.getLook().setProfile(profile);
        SwordMeta sword = (SwordMeta) MetaContext.getMeta(SwordMeta.class);
        sword.refresh();
        knight.setSword(sword);

        knight.hit(enemy);

        int actualValue = sword.getLook().getDurability();
        String message = MessageUtil.formatAssertMessage(
                String.format("После вызова метода hit оружние бьющего должно иметь %d прочности", expectedValue),
                String.format("После вызова метода hit оружние бьющего имеет %d прочности", actualValue)
        );
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод hit в классе Knight уменьшает выносливость персонажа на 10")
    @Test
    void testHitDecreasesStamina() {
        int expectedValue = 90;
        ProfileMeta profile = createProfile();
        KnightMeta enemy = new KnightMeta();
        enemy.getLook().setProfile(profile);
        SwordMeta sword = (SwordMeta) MetaContext.getMeta(SwordMeta.class);
        knight.setSword(sword);
        knight.setProfile(profile);

        knight.hit(enemy);

        int actualValue = profile.getLook().getStamina();
        String message = MessageUtil.formatAssertMessage(
                String.format("После вызова метода hit персонаж должен иметь %d выносливости", expectedValue),
                String.format("После вызова метода hit персонаж имеет %d выносливости", actualValue)
        );
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод go в классе Knight меняет координаты точки персонажа")
    @Test
    void testGoChangesPointCoordinates() {
        int expectedX = 5;
        int expectedY = 6;

        knight.go(expectedX, expectedY);

        int actualX = knight.getPoint().getLook().getX();
        int actualY = knight.getPoint().getLook().getY();
        assertEquals(expectedX, actualX, getGoAssertMessage("x", expectedX, actualX));
        assertEquals(expectedY, actualY, getGoAssertMessage("y", expectedY, actualY));
    }

    @DisplayName("Тест, что метод setSword в классе Knight сохраняет переданный Sword в поле класса")
    @Test
    void testSetSwordSavesSwordToField() {
        SwordMeta expectedValue = (SwordMeta) MetaContext.getMeta(SwordMeta.class);
        knight.setSword(expectedValue);
        String message = getSetterAssertMessage("setSword", "sword", getMeta().getClassName());
        assertEquals(expectedValue, knight.getSword(), message);
    }

    @DisplayName("Тест, что метод setHelmet в классе Knight сохраняет полученный Helmet в инвентарь")
    @Test
    void testSetHelmetSavesHelmetToInventory() {
        HelmetMeta expectedValue = (HelmetMeta) MetaContext.getMeta(HelmetMeta.class);
        InventoryMeta inventory = (InventoryMeta) MetaContext.getMeta(InventoryMeta.class);
        ProfileMeta profile = (ProfileMeta) MetaContext.getMeta(ProfileMeta.class);
        profile.getLook().setInventory(inventory);
        knight.setProfile(profile);

        knight.setHelmet(expectedValue);

        String message = getSetterAssertMessage("setHelmet", "helmet", inventory.getClassName());
        assertEquals(expectedValue, knight.getProfile().getLook().getInventory().getLook().getHelmet(), message);
    }

    @DisplayName("Тест, что метод setCuirass в классе Knight сохраняет полученный Cuirass в инвентарь")
    @Test
    void testSetCuirassSavesCuirassToInventory() {
        CuirassMeta expectedValue = (CuirassMeta) MetaContext.getMeta(CuirassMeta.class);
        InventoryMeta inventory = (InventoryMeta) MetaContext.getMeta(InventoryMeta.class);
        ProfileMeta profile = (ProfileMeta) MetaContext.getMeta(ProfileMeta.class);
        profile.getLook().setInventory(inventory);
        knight.setProfile(profile);

        knight.setCuirass(expectedValue);

        String message = getSetterAssertMessage("setCuirass", "cuirass", inventory.getClassName());
        assertEquals(expectedValue, knight.getProfile().getLook().getInventory().getLook().getCuirass(), message);
    }

    @DisplayName("Тест, что метод setGloves в классе Knight сохраняет полученный Gloves в инвентарь")
    @Test
    void testSetGlovesSavesGlovesToInventory() {
        GlovesMeta expectedValue = (GlovesMeta) MetaContext.getMeta(GlovesMeta.class);
        InventoryMeta inventory = (InventoryMeta) MetaContext.getMeta(InventoryMeta.class);
        ProfileMeta profile = (ProfileMeta) MetaContext.getMeta(ProfileMeta.class);
        profile.getLook().setInventory(inventory);
        knight.setProfile(profile);

        knight.setGloves(expectedValue);

        String message = getSetterAssertMessage("setGloves", "gloves", inventory.getClassName());
        assertEquals(expectedValue, knight.getProfile().getLook().getInventory().getLook().getGloves(), message);
    }

    @DisplayName("Тест, что метод setBoots в классе Knight сохраняет полученный Boots в инвентарь")
    @Test
    void testSetBootsSavesBootsToInventory() {
        BootsMeta expectedValue = (BootsMeta) MetaContext.getMeta(BootsMeta.class);
        InventoryMeta inventory = (InventoryMeta) MetaContext.getMeta(InventoryMeta.class);
        ProfileMeta profile = (ProfileMeta) MetaContext.getMeta(ProfileMeta.class);
        profile.getLook().setInventory(inventory);
        knight.setProfile(profile);

        knight.setBoots(expectedValue);

        String message = getSetterAssertMessage("setBoots", "boots", inventory.getClassName());
        assertEquals(expectedValue, knight.getProfile().getLook().getInventory().getLook().getBoots(), message);
    }

    @DisplayName("Тест, что метод setShield в классе Knight сохраняет полученный Shield в инвентарь")
    @Test
    void testSetShieldSavesShieldToInventory() {
        ShieldMeta expectedValue = (ShieldMeta) MetaContext.getMeta(ShieldMeta.class);
        InventoryMeta inventory = (InventoryMeta) MetaContext.getMeta(InventoryMeta.class);
        ProfileMeta profile = (ProfileMeta) MetaContext.getMeta(ProfileMeta.class);
        profile.getLook().setInventory(inventory);
        knight.setProfile(profile);

        knight.setShield(expectedValue);

        String message = getSetterAssertMessage("setShield", "shield", inventory.getClassName());
        assertEquals(expectedValue, knight.getProfile().getLook().getInventory().getLook().getShield(), message);
    }

    @DisplayName("Тест, что метод setLeftRing в классе Knight сохраняет полученный StrengthRing в поле класса")
    @Test
    void testSetLeftRingSavesStrengthRingToField() {
        StrengthRingMeta expectedValue = (StrengthRingMeta) MetaContext.getMeta(StrengthRingMeta.class);
        knight.setLeftRing(expectedValue);
        String message = getSetterAssertMessage("setLeftRing", "leftRing", getMeta().getClassName());
        assertEquals(expectedValue, knight.getLeftRing(), message);
    }

    @DisplayName("Тест, что метод setLeftRing в классе Knight добавляет очки кольца к соответствующей характеристике персонажа")
    @Test
    void testSetLeftRingAddsPoints() {
        int expectedValue = 8;
        StrengthRingMeta ring = (StrengthRingMeta) MetaContext.getMeta(StrengthRingMeta.class);
        ProfileMeta profile = createProfile();
        knight.setProfile(profile);

        knight.setLeftRing(ring);

        int actualValue = profile.getLook().getStrength();
        String message = getFieldValueAssert(getMeta().getClassName(), "setLeftRing", "strength",
                expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод setRightRing в классе Knight сохраняет полученный StrengthRing в поле класса")
    @Test
    void testSetRightRingSavesStrengthRingToField() {
        StrengthRingMeta expectedValue = (StrengthRingMeta) MetaContext.getMeta(StrengthRingMeta.class);
        knight.setRightRing(expectedValue);
        String message = getSetterAssertMessage("setRightRing", "rightRing", getMeta().getClassName());
        assertEquals(expectedValue, knight.getRightRing(), message);
    }

    @DisplayName("Тест, что метод setRightRing в классе Knight добавляет очки кольца к соответствующей характеристике персонажа")
    @Test
    void testSetRightRingAddsPoints() {
        int expectedValue = 8;
        StrengthRingMeta ring = (StrengthRingMeta) MetaContext.getMeta(StrengthRingMeta.class);
        ProfileMeta profile = createProfile();
        knight.setProfile(profile);

        knight.setRightRing(ring);

        int actualValue = profile.getLook().getStrength();
        String message = getFieldValueAssert(getMeta().getClassName(), "setRightRing", "strength",
                expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод setBelt в классе Knight сохраняет полученный StrengthBelt в поле класса")
    @Test
    void testSetBeltSavesStrengthBeltToField() {
        StrengthBeltMeta expectedValue = (StrengthBeltMeta) MetaContext.getMeta(StrengthBeltMeta.class);
        knight.setBelt(expectedValue);
        String message = getSetterAssertMessage("setBelt", "belt", getMeta().getClassName());
        assertEquals(expectedValue, knight.getBelt(), message);
    }

    @DisplayName("Тест, что метод setBelt в классе Knight добавляет очки кольца к соответствующей характеристике персонажа")
    @Test
    void testSetBeltAddsPoints() {
        int expectedValue = 8;
        StrengthBeltMeta belt = (StrengthBeltMeta) MetaContext.getMeta(StrengthBeltMeta.class);
        ProfileMeta profile = createProfile();
        knight.setProfile(profile);

        knight.setBelt(belt);

        int actualValue = profile.getLook().getStrength();
        String message = getFieldValueAssert(getMeta().getClassName(), "setBelt", "strength",
                expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод setNecklace в классе Knight сохраняет полученный StrengthNecklace в поле класса")
    @Test
    void testSetNecklaceSavesStrengthNecklaceToField() {
        StrengthNecklaceMeta expectedValue = (StrengthNecklaceMeta) MetaContext.getMeta(StrengthNecklaceMeta.class);
        knight.setNecklace(expectedValue);
        String message = getSetterAssertMessage("setNecklace", "belt", getMeta().getClassName());
        assertEquals(expectedValue, knight.getNecklace(), message);
    }

    @DisplayName("Тест, что метод setNecklace в классе Knight добавляет очки кольца к соответствующей характеристике персонажа")
    @Test
    void testSetNecklaceAddsPoints() {
        int expectedValue = 8;
        StrengthNecklaceMeta necklace = (StrengthNecklaceMeta) MetaContext.getMeta(StrengthNecklaceMeta.class);
        ProfileMeta profile = createProfile();
        knight.setProfile(profile);

        knight.setNecklace(necklace);

        int actualValue = profile.getLook().getStrength();
        String message = getFieldValueAssert(getMeta().getClassName(), "setNecklace", "strength",
                expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод setActiveQuest в классе Knight сохраняет переданный Quest в поле класса")
    @Test
    void testSetActiveQuestSavesQuestToField() {
        QuestMeta expectedValue = (QuestMeta) MetaContext.getMeta(QuestMeta.class);
        knight.setActiveQuest(expectedValue);
        String message = getSetterAssertMessage("setActiveQuest", "activeQuest", getMeta().getClassName());
        assertEquals(expectedValue, knight.getActiveQuest(), message);
    }

    @DisplayName("Тест, что метод setSkill в классе Knight сохраняет переданный Rage в поле класса")
    @Test
    void testSetSkillSavesSkillToField() {
        RageMeta expectedValue = (RageMeta) MetaContext.getMeta(RageMeta.class);
        knight.setSkill(expectedValue);
        String message = getSetterAssertMessage("setSkill", "skill", getMeta().getClassName());
        assertEquals(expectedValue, knight.getSkill(), message);
    }

    @DisplayName("Тест, что метод takeOffLeftRing в классе Knight снимает левое кольцо")
    @Test
    void testTakeOffLeftRing() {
        StrengthRingMeta ring = (StrengthRingMeta) MetaContext.getMeta(StrengthRingMeta.class);
        knight.setLeftRing(ring);

        knight.takeOffLeftRing();

        StrengthRingMeta actualValue = knight.getLeftRing();
        String message = getFieldValueAssert(getMeta().getClassName(), "takeOffLeftRing", "leftRing",
                null, actualValue);
        assertNull(actualValue, message);
    }

    @DisplayName("Тест, что метод takeOffLeftRing в классе Knight отнимает от соответствующей характиристики количество очков предмета")
    @Test
    void testTakeOffLeftRingDecreasesCharacteristic() {
        int expectedValue = 7;
        StrengthRingMeta ring = (StrengthRingMeta) MetaContext.getMeta(StrengthRingMeta.class);
        ProfileMeta profile = createProfile();
        knight.setProfile(profile);
        knight.setLeftRing(ring);

        knight.takeOffLeftRing();

        int actualValue = profile.getLook().getStrength();
        String message = getFieldValueAssert(getMeta().getClassName(), "takeOffLeftRing", "leftRing", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод takeOffRightRing в классе Knight снимает правое кольцо")
    @Test
    void testTakeOffRightRing() {
        StrengthRingMeta ring = (StrengthRingMeta) MetaContext.getMeta(StrengthRingMeta.class);
        knight.setRightRing(ring);

        knight.takeOffRightRing();

        StrengthRingMeta actualValue = knight.getRightRing();
        String message = getFieldValueAssert(getMeta().getClassName(), "takeOffRightRing", "rightRing",
                null, actualValue);
        assertNull(actualValue, message);
    }

    @DisplayName("Тест, что метод takeOffRightRing в классе Knight отнимает от соответствующей характиристики количество очков предмета")
    @Test
    void testTakeOffRightRingDecreasesCharacteristic() {
        int expectedValue = 7;
        StrengthRingMeta ring = (StrengthRingMeta) MetaContext.getMeta(StrengthRingMeta.class);
        ProfileMeta profile = createProfile();
        knight.setProfile(profile);
        knight.setRightRing(ring);

        knight.takeOffRightRing();

        int actualValue = profile.getLook().getStrength();
        String message = getFieldValueAssert(getMeta().getClassName(), "takeOffRightRing", "rightRing", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод takeOffBelt в классе Knight снимает ремень")
    @Test
    void testTakeOffBelt() {
        StrengthBeltMeta belt = (StrengthBeltMeta) MetaContext.getMeta(StrengthBeltMeta.class);
        knight.setBelt(belt);

        knight.takeOffBelt();

        StrengthBeltMeta actualValue = knight.getBelt();
        String message = getFieldValueAssert(getMeta().getClassName(), "takeOffBelt", "belt",
                null, actualValue);
        assertNull(actualValue, message);
    }

    @DisplayName("Тест, что метод takeOffBelt в классе Knight отнимает от соответствующей характиристике количество очков предмета")
    @Test
    void testTakeOffBeltDecreasesCharacteristic() {
        int expectedValue = 7;
        StrengthBeltMeta belt = (StrengthBeltMeta) MetaContext.getMeta(StrengthBeltMeta.class);
        ProfileMeta profile = createProfile();
        knight.setProfile(profile);
        knight.setBelt(belt);

        knight.takeOffBelt();

        int actualValue = profile.getLook().getStrength();
        String message = getFieldValueAssert(getMeta().getClassName(), "takeOffBelt", "belt", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод takeOffNecklace в классе Knight снимает левое кольцо")
    @Test
    void testTakeOffNecklace() {
        StrengthNecklaceMeta necklace = (StrengthNecklaceMeta) MetaContext.getMeta(StrengthNecklaceMeta.class);
        knight.setNecklace(necklace);

        knight.takeOffNecklace();

        StrengthNecklaceMeta actualValue = knight.getNecklace();
        String message = getFieldValueAssert(getMeta().getClassName(), "takeOffNecklace", "necklace",
                null, actualValue);
        assertNull(actualValue, message);
    }

    @DisplayName("Тест, что метод takeOffNecklace в классе Knight отнимает от соответствующей характиристике количество очков предмета")
    @Test
    void testTakeOffNecklaceDecreasesCharacteristic() {
        int expectedValue = 7;
        StrengthNecklaceMeta necklace = (StrengthNecklaceMeta) MetaContext.getMeta(StrengthNecklaceMeta.class);
        ProfileMeta profile = createProfile();
        knight.setProfile(profile);
        knight.setNecklace(necklace);

        knight.takeOffNecklace();

        int actualValue = profile.getLook().getStrength();
        String message = getFieldValueAssert(getMeta().getClassName(), "takeOffNecklace", "necklace", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getHelmet в классе Knight возвращает шлем персонажа")
    @Test
    void testGetHelmet() {
        HelmetMeta expectedValue = (HelmetMeta) MetaContext.getMeta(HelmetMeta.class);
        ProfileMeta profile = createProfile();
        knight.setProfile(profile);
        knight.setHelmet(expectedValue);
        HelmetMeta actualValue = knight.getHelmet();
        String message = getMethodReturnResultAssertMessage("getHelmet", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getCuirass в классе Knight возвращает кирасу персонажа")
    @Test
    void testGetCuirass() {
        CuirassMeta expectedValue = (CuirassMeta) MetaContext.getMeta(CuirassMeta.class);
        ProfileMeta profile = createProfile();
        knight.setProfile(profile);
        knight.setCuirass(expectedValue);
        CuirassMeta actualValue = knight.getCuirass();
        String message = getMethodReturnResultAssertMessage("getCuirass", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getGloves в классе Knight возвращает перчатки персонажа")
    @Test
    void testGetGloves() {
        GlovesMeta expectedValue = (GlovesMeta) MetaContext.getMeta(GlovesMeta.class);
        ProfileMeta profile = createProfile();
        knight.setProfile(profile);
        knight.setGloves(expectedValue);
        GlovesMeta actualValue = knight.getGloves();
        String message = getMethodReturnResultAssertMessage("getGloves", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getBoots в классе Knight возвращает сапоги персонажа")
    @Test
    void testGetBoots() {
        BootsMeta expectedValue = (BootsMeta) MetaContext.getMeta(BootsMeta.class);
        ProfileMeta profile = createProfile();
        knight.setProfile(profile);
        knight.setBoots(expectedValue);
        BootsMeta actualValue = knight.getBoots();
        String message = getMethodReturnResultAssertMessage("getBoots", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getShield в классе Knight возвращает щит персонажа")
    @Test
    void testGetShield() {
        ShieldMeta expectedValue = (ShieldMeta) MetaContext.getMeta(ShieldMeta.class);
        ProfileMeta profile = createProfile();
        knight.setProfile(profile);
        knight.setShield(expectedValue);
        ShieldMeta actualValue = knight.getShield();
        String message = getMethodReturnResultAssertMessage("getShield", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getPoint в классе Knight возвращает точку персонажа")
    @Test
    void testGetPoint() {
        int expectedX = 0;
        int expectedY = 0;
        PointMeta point = knight.getPoint();
        int actualX = point.getLook().getX();
        int actualY = point.getLook().getY();
        String messageX = getCoordinatesAssertMessage("x", expectedX, actualX);
        String messageY = getCoordinatesAssertMessage("y", expectedY, actualY);
        assertEquals(expectedX, actualX, messageX);
        assertEquals(expectedY, actualY, messageY);
    }

    @DisplayName("Тест, что метод getActiveQuest в классе Knight возвращает задание персонажа")
    @Test
    void testGetActiveQuest() {
        QuestMeta expectedValue = (QuestMeta) MetaContext.getMeta(QuestMeta.class);
        knight.setActiveQuest(expectedValue);
        QuestMeta actualValue = knight.getActiveQuest();
        String message = getMethodReturnResultAssertMessage("getActiveQuest", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getSword в классе Knight возвращает оружие персонажа")
    @Test
    void testGetSword() {
        SwordMeta expectedValue = (SwordMeta) MetaContext.getMeta(SwordMeta.class);
        knight.setSword(expectedValue);
        SwordMeta actualValue = knight.getSword();
        String message = getMethodReturnResultAssertMessage("getSword", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getLeftRing в классе Knight возвращает левое кольцо персонажа")
    @Test
    void testGetLeftRing() {
        StrengthRingMeta expectedValue = (StrengthRingMeta) MetaContext.getMeta(StrengthRingMeta.class);
        knight.setLeftRing(expectedValue);
        StrengthRingMeta actualValue = knight.getLeftRing();
        String message = getMethodReturnResultAssertMessage("getLeftRing", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getRightRing в классе Knight возвращает правое кольцо персонажа")
    @Test
    void testGetRightRing() {
        StrengthRingMeta expectedValue = (StrengthRingMeta) MetaContext.getMeta(StrengthRingMeta.class);
        knight.setRightRing(expectedValue);
        StrengthRingMeta actualValue = knight.getRightRing();
        String message = getMethodReturnResultAssertMessage("getRightRing", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getBelt в классе Knight возвращает ремень персонажа")
    @Test
    void testGetBelt() {
        StrengthBeltMeta expectedValue = (StrengthBeltMeta) MetaContext.getMeta(StrengthBeltMeta.class);
        knight.setBelt(expectedValue);
        StrengthBeltMeta actualValue = knight.getBelt();
        String message = getMethodReturnResultAssertMessage("getBelt", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getNecklace в классе Knight возвращает ожерелье персонажа")
    @Test
    void testGetNecklace() {
        StrengthNecklaceMeta expectedValue = (StrengthNecklaceMeta) MetaContext.getMeta(StrengthNecklaceMeta.class);
        knight.setNecklace(expectedValue);
        StrengthNecklaceMeta actualValue = knight.getNecklace();
        String message = getMethodReturnResultAssertMessage("getNecklace", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getSkill в классе Knight возвращает навык персонажа")
    @Test
    void testGetSkill() {
        RageMeta expectedValue = (RageMeta) MetaContext.getMeta(RageMeta.class);
        knight.setSkill(expectedValue);
        RageMeta actualValue = knight.getSkill();
        String message = getMethodReturnResultAssertMessage("getSkill", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод setProfile в классе Wizard сохраняет профиль персонажа в поле класса")
    @Test
    void testSetProfile() {
        ProfileMeta expectedValue = (ProfileMeta) MetaContext.getMeta(ProfileMeta.class);
        knight.setProfile(expectedValue);
        String message = getSetterAssertMessage("setProfile", "profile", getMeta().getClassName());
        assertEquals(expectedValue, knight.getProfile(), message);
    }

    @DisplayName("Тест, что метод getProfile в классе Wizard возвращает профиль персонажа")
    @Test
    void testGetProfile() {
        ProfileMeta expectedValue = (ProfileMeta) MetaContext.getMeta(ProfileMeta.class);
        knight.setProfile(expectedValue);
        ProfileMeta actualValue = knight.getProfile();
        String message = getMethodReturnResultAssertMessage("getProfile", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод addGold в классе Knight добавляет переданное количество золота к текущему")
    @Test
    void testAddGold() {
        int expectedValue = 110;
        ProfileMeta profile = createProfile();
        knight.setProfile(profile);

        knight.addGold(10);

        int actualValue = profile.getLook().getGold();
        String message = getFieldValueAssert(getMeta().getClassName(), "addGold", "gold", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод addExperience в классе Knight добавляет переданное количество опыта к текущему")
    @Test
    void testAddExperience() {
        int expectedValue = 110;
        ProfileMeta profile = createProfile();
        knight.setProfile(profile);

        knight.addExperience(10);

        int actualValue = profile.getLook().getExperience();
        String message = getFieldValueAssert(getMeta().getClassName(), "addExperience", "experience", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод talkTo в классе Knight добавляет рыцарю задание от переданного NPC")
    @Test
    void testTalkTo() {
        NPCMeta npc = (NPCMeta) MetaContext.getMeta(NPCMeta.class);
        QuestMeta expectedValue = (QuestMeta) MetaContext.getMeta(QuestMeta.class);
        npc.getLook().setQuest(expectedValue);

        knight.talkTo(npc);

        QuestMeta actualValue = knight.getActiveQuest();
        String message = getFieldValueAssert(getMeta().getClassName(), "talkTo", "activeQuest", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод calculatePhysicalDefence в классе Knight рассчитывает общую защиту для значения поля physicalDefence для всей брони")
    @Test
    void testCalculatePhysicalDefence() {
        int expectedValue = 5;
        ProfileMeta profile = (ProfileMeta) MetaContext.getMeta(ProfileMeta.class);
        InventoryMeta inventory = (InventoryMeta) MetaContext.getMeta(InventoryMeta.class);
        HelmetMeta helmet = (HelmetMeta) MetaContext.getMeta(HelmetMeta.class);
        CuirassMeta cuirass = (CuirassMeta) MetaContext.getMeta(CuirassMeta.class);
        GlovesMeta gloves = (GlovesMeta) MetaContext.getMeta(GlovesMeta.class);
        BootsMeta boots = (BootsMeta) MetaContext.getMeta(BootsMeta.class);
        ShieldMeta shield = (ShieldMeta) MetaContext.getMeta(ShieldMeta.class);
        profile.getLook().setPhysicalDefence(0);
        profile.getLook().setInventory(inventory);
        knight.setProfile(profile);
        knight.setHelmet(helmet);
        knight.setCuirass(cuirass);
        knight.setGloves(gloves);
        knight.setBoots(boots);
        knight.setShield(shield);

        knight.calculatePhysicalDefence();

        int actualValue = profile.getLook().getPhysicalDefence();
        String message = getFieldValueAssert(getMeta().getClassName(), "calculatePhysicalDefence", "physicalDefence", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод calculateMagicDefence в классе Knight рассчитывает общую защиту для значения поля magicDefence для всей брони")
    @Test
    void testCalculateMagicDefence() {
        int expectedValue = 10;
        ProfileMeta profile = (ProfileMeta) MetaContext.getMeta(ProfileMeta.class);
        InventoryMeta inventory = (InventoryMeta) MetaContext.getMeta(InventoryMeta.class);
        HelmetMeta helmet = (HelmetMeta) MetaContext.getMeta(HelmetMeta.class);
        CuirassMeta cuirass = (CuirassMeta) MetaContext.getMeta(CuirassMeta.class);
        GlovesMeta gloves = (GlovesMeta) MetaContext.getMeta(GlovesMeta.class);
        BootsMeta boots = (BootsMeta) MetaContext.getMeta(BootsMeta.class);
        ShieldMeta shield = (ShieldMeta) MetaContext.getMeta(ShieldMeta.class);
        profile.getLook().setMagicDefence(0);
        profile.getLook().setInventory(inventory);
        knight.setProfile(profile);
        knight.setHelmet(helmet);
        knight.setCuirass(cuirass);
        knight.setGloves(gloves);
        knight.setBoots(boots);
        knight.setShield(shield);

        knight.calculateMagicDefence();

        int actualValue = profile.getLook().getMagicDefence();
        String message = getFieldValueAssert(getMeta().getClassName(), "calculateMagicDefence", "magicDefence", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод castSkill в классе Knight применяет Rage к себе")
    @Test
    void testCastSkill() {
        int expectedHp = 85;
        int expectedMana = 99;
        int expectedStrength = 14;
        RageMeta skill = (RageMeta) MetaContext.getMeta(RageMeta.class);
        ProfileMeta profile = createProfile();
        knight.setProfile(profile);
        knight.setSkill(skill);

        knight.castSkill();

        int actualHp = profile.getLook().getHp();
        int actualMana = profile.getLook().getMana();
        int actualStrength = profile.getLook().getStrength();
        String methodName = "castSkill";
        String hpMessage = getFieldValueAssert(getMeta().getClassName(), methodName, "hp", expectedHp, actualHp);
        String manaMessage = getFieldValueAssert(getMeta().getClassName(), methodName, "mana", expectedMana, actualMana);
        String strengthMessage = getFieldValueAssert(getMeta().getClassName(), methodName, "strength", expectedStrength, actualStrength);
        assertEquals(expectedHp, actualHp, hpMessage);
        assertEquals(expectedMana, actualMana, manaMessage);
        assertEquals(expectedStrength, actualStrength, strengthMessage);
    }

    @DisplayName("Тест, что метод calculateDistance в классе Knight вычисляет расстояние между персонажем и переданной точкой")
    @Test
    void testCalculateDistance() {
        double expectedValue = 5.0;
        PointMeta point = new PointMeta();
        point.getLook().setXY(3, 4);
        knight.getPoint().getLook().setXY(0, 0);

        double actualValue = knight.calculateDistance(point);

        String message = getMethodReturnResultAssertMessage("calculateDistance", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, 0.1, message);
    }

    @DisplayName("Тест, что метод drinkHpPotion в классе Knight добавляет к здоровью персонажа количество очков переданного зелья")
    @Test
    void testDrinkHpPotion() {
        int expectedHp = 101;
        HpPotionMeta potion = (HpPotionMeta) MetaContext.getMeta(HpPotionMeta.class);
        ProfileMeta profile = createProfile();
        knight.setProfile(profile);

        knight.drinkHpPotion(potion);

        int actualHp = profile.getLook().getHp();
        String message = getFieldValueAssert(getMeta().getClassName(), "drinkHpPotion", "hp", expectedHp, actualHp);
        assertEquals(expectedHp, actualHp, message);
    }

    @DisplayName("Тест, что метод talkTo в классе Knight отдает оружие рыцаря на починку кузнецу")
    @Test
    void testTalkToBlacksmith() {
        int expectedDurability = 100;
        int expectedGold = 80;
        SwordMeta sword = (SwordMeta) MetaContext.getMeta(SwordMeta.class);
        sword.getLook().setDurability(expectedDurability - 1);
        ProfileMeta profile = createProfile();
        knight.setProfile(profile);
        knight.setSword(sword);
        BlacksmithMeta blacksmith = (BlacksmithMeta) MetaContext.getMeta(BlacksmithMeta.class);

        knight.talkTo(blacksmith);

        int actualDurability = sword.getLook().getDurability();
        int actualGold = profile.getLook().getGold();
        String durabilityMessage = getFieldValueAssert(sword.getClassName(), "talkTo", "durability", expectedDurability, actualDurability);
        String goldMessage = getFieldValueAssert(getMeta().getClassName(), "talkTo", "gold", expectedDurability, actualDurability);
        assertEquals(expectedDurability, actualDurability, durabilityMessage);
        assertEquals(expectedGold, actualGold, goldMessage);
    }

    @DisplayName("Тест, что метод eat в классе Knight добавляет здоровье в количестве очков восстановления яблока")
    @Test
    void testEatMethod() {
        int points = 5;
        int expectedValue = 100 + points;
        AppleMeta apple = (AppleMeta) MetaContext.getMeta(AppleMeta.class);
        apple.getLook().setPointsToRecover(points);
        ProfileMeta profile = createProfile();
        knight.setProfile(profile);

        knight.eat(apple);

        int actualValue = profile.getLook().getHp();
        String message = getFieldValueAssert(getMeta().getClassName(), "eat", "hp", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }
}
