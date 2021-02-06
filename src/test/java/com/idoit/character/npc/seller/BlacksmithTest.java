package com.idoit.character.npc.seller;

import com.idoit.AbstractTest;
import com.idoit.meta.MetaContext;
import com.idoit.meta.character.KnightMeta;
import com.idoit.meta.character.WizardMeta;
import com.idoit.meta.character.npc.seller.BlacksmithMeta;
import com.idoit.meta.item.special.IgniteHammerMeta;
import com.idoit.meta.item.stone.CriticalHitStoneMeta;
import com.idoit.meta.item.stone.DamageStoneMeta;
import com.idoit.meta.item.stone.HealStoneMeta;
import com.idoit.meta.item.weapon.BowMeta;
import com.idoit.meta.item.weapon.StaffMeta;
import com.idoit.meta.item.weapon.SwordMeta;
import com.idoit.meta.profile.ProfileMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты логики в классе Blacksmith")
class BlacksmithTest extends AbstractTest {

    private BlacksmithMeta.BlacksmithLook seller;

    @BeforeEach
	void setUp() {
        setMeta(BlacksmithMeta.class);
        BlacksmithMeta meta = (BlacksmithMeta) getMeta();
        seller = meta.getLook();
    }

    @DisplayName("Тест, что класс Blacksmith находится в пакете com.idoit.character.npc.seller")
    @Test
    void testBlacksmithIsInNpcPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Blacksmith имеет все необходимые поля")
    @Test
    void testBlacksmithHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе Blacksmith есть конструктор принимающий название и уровень нпс")
    @Test
    void testBlacksmithHasConstructorWithNameAndBothDefenceParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields("test", 3);
    }

    @DisplayName("Тест, что в классе Blacksmith есть все необходимые методы")
    @Test
    void testBlacksmithHasAllMethods() {
        testClassHasAllMethods();
    }

    private ProfileMeta createProfile() {
        ProfileMeta profile = (ProfileMeta) MetaContext.getMeta(ProfileMeta.class);
        profile.getLook().setGold(100);
        return profile;
    }

    @DisplayName("Тест, что метод fix в классе Blacksmith восстанавливает прочность мечей до 100")
    @Test
    void testFixIncreasesSwordDurability() {
        int expectedDurability = 100;
        SwordMeta weapon = (SwordMeta) MetaContext.getMeta(SwordMeta.class);
        weapon.getLook().setDurability(99);
        KnightMeta buyer = (KnightMeta) MetaContext.getMeta(KnightMeta.class);
        buyer.getLook().setProfile(createProfile());

        seller.fix(buyer, weapon);

        int actualDurability = weapon.getLook().getDurability();
        String message = getFieldValueAssert(weapon.getClassName(), "fix", "durability", expectedDurability, actualDurability);
        assertEquals(expectedDurability, actualDurability, message);
    }

    @DisplayName("Тест, что метод fix в классе Blacksmith отнимает золото у переданного рыцаря за починку меча")
    @Test
    void testFixDecreasesKnightGold() {
        int expectedGold = 80;
        SwordMeta weapon = (SwordMeta) MetaContext.getMeta(SwordMeta.class);
        KnightMeta buyer = (KnightMeta) MetaContext.getMeta(KnightMeta.class);
        buyer.getLook().setProfile(createProfile());

        seller.fix(buyer, weapon);

        int actualGold = buyer.getLook().getProfile().getLook().getGold();
        String message = getFieldValueAssert(buyer.getClassName(), "fix", "gold", expectedGold, actualGold);
        assertEquals(expectedGold, actualGold, message);
    }

    @DisplayName("Тест, что метод fix в классе Blacksmith восстанавливает прочность посохов до 100")
    @Test
    void testFixIncreasesStaffDurability() {
        int expectedDurability = 100;
        StaffMeta weapon = (StaffMeta) MetaContext.getMeta(StaffMeta.class);
        weapon.getLook().setDurability(99);
        WizardMeta buyer = (WizardMeta) MetaContext.getMeta(WizardMeta.class);
        buyer.getLook().setProfile(createProfile());

        seller.fix(buyer, weapon);

        int actualDurability = weapon.getLook().getDurability();
        String message = getFieldValueAssert(weapon.getClassName(), "fix", "durability", expectedDurability, actualDurability);
        assertEquals(expectedDurability, actualDurability, message);
    }

    @DisplayName("Тест, что метод fix в классе Blacksmith отнимает золото у переданного мага за починку посоха")
    @Test
    void testFixDecreasesWizardGold() {
        int expectedGold = 80;
        StaffMeta weapon = (StaffMeta) MetaContext.getMeta(StaffMeta.class);
        WizardMeta buyer = (WizardMeta) MetaContext.getMeta(WizardMeta.class);
        buyer.getLook().setProfile(createProfile());

        seller.fix(buyer, weapon);

        int actualGold = buyer.getLook().getProfile().getLook().getGold();
        String message = getFieldValueAssert(buyer.getClassName(), "fix", "gold", expectedGold, actualGold);
        assertEquals(expectedGold, actualGold, message);
    }

    @DisplayName("Тест, что метод accept в классе Blacksmith увеличивает уровень кузнеца на 1")
    @Test
    void testAccept() {
        int expectedLevel = 2;
        IgniteHammerMeta hammer = (IgniteHammerMeta) MetaContext.getMeta(IgniteHammerMeta.class);

        seller.accept(hammer);

        int actualLevel = seller.getLevel();
        String message = getFieldValueAssert(getMeta().getClassName(), "accept", "level", expectedLevel, actualLevel);
        assertEquals(expectedLevel, actualLevel, message);
    }

    @DisplayName("Тест, что метод insertStoneToWeapon в классе Blacksmith вставляет в переданный меч переданный камень урона")
    @Test
    void testInsertStoneToSword() {
        SwordMeta weapon = (SwordMeta) MetaContext.getMeta(SwordMeta.class);
        DamageStoneMeta stone = (DamageStoneMeta) MetaContext.getMeta(DamageStoneMeta.class);

        seller.insertStoneToWeapon(weapon, stone);

        DamageStoneMeta actualStone = weapon.getLook().getStone();
        String message = getFieldValueAssert(weapon.getClassName(), "insertStone", "stone", stone, actualStone);
        assertEquals(stone, actualStone, message);
    }

    @DisplayName("Тест, что метод insertStoneToWeapon в классе Blacksmith вставляет в переданный посох переданный камень лечения")
    @Test
    void testInsertStoneToStaff() {
        StaffMeta weapon = (StaffMeta) MetaContext.getMeta(StaffMeta.class);
        HealStoneMeta stone = (HealStoneMeta) MetaContext.getMeta(HealStoneMeta.class);

        seller.insertStoneToWeapon(weapon, stone);

        HealStoneMeta actualStone = weapon.getLook().getStone();
        String message = getFieldValueAssert(weapon.getClassName(), "insertStone", "stone", stone, actualStone);
        assertEquals(stone, actualStone, message);
    }

    @DisplayName("Тест, что метод insertStoneToWeapon в классе Blacksmith вставляет в переданный лук переданный камень критического урона")
    @Test
    void testInsertStoneToBow() {
        BowMeta weapon = (BowMeta) MetaContext.getMeta(BowMeta.class);
        CriticalHitStoneMeta stone = (CriticalHitStoneMeta) MetaContext.getMeta(CriticalHitStoneMeta.class);

        seller.insertStoneToWeapon(weapon, stone);

        CriticalHitStoneMeta actualStone = weapon.getLook().getStone();
        String message = getFieldValueAssert(weapon.getClassName(), "insertStone", "stone", stone, actualStone);
        assertEquals(stone, actualStone, message);
    }
}
