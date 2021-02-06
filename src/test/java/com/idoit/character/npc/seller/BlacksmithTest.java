package com.idoit.character.npc.seller;

import com.idoit.meta.MetaContext;
import com.idoit.meta.character.KnightMeta;
import com.idoit.meta.character.WizardMeta;
import com.idoit.meta.character.npc.seller.BlacksmithMeta;
import com.idoit.meta.item.special.IgniteHammerMeta;
import com.idoit.meta.item.stone.CriticalHitStoneMeta;
import com.idoit.meta.item.stone.DamageStoneMeta;
import com.idoit.meta.item.stone.HealStoneMeta;
import com.idoit.meta.item.stone.StoneMeta;
import com.idoit.meta.item.weapon.BowMeta;
import com.idoit.meta.item.weapon.StaffMeta;
import com.idoit.meta.item.weapon.SwordMeta;
import com.idoit.meta.item.weapon.WeaponMeta;
import com.idoit.safe.Safer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты логики в классе Blacksmith")
class BlacksmithTest extends SellerTest {

    @BeforeEach
	void setUp() {
        setMeta(BlacksmithMeta.class);
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

    @DisplayName("Тест, что метод fix в классе Blacksmith восстанавливает прочность мечей до 100")
    @Test
    void testFixIncreasesSwordDurability() {
        testWeaponFix(KnightMeta.class, SwordMeta.class, (swordMeta) -> swordMeta.instantiateObjectWithConstructor("sword", 10));
    }

    @DisplayName("Тест, что метод fix в классе Blacksmith отнимает золото у переданного рыцаря за починку меча")
    @Test
    void testFixDecreasesKnightGold() {
        testFixDecreasesGold(KnightMeta.class, SwordMeta.class, (swordMeta) -> swordMeta.instantiateObjectWithConstructor("sword", 10));
    }

    @DisplayName("Тест, что метод fix в классе Blacksmith восстанавливает прочность посохов до 100")
    @Test
    void testFixIncreasesStaffDurability() {
        testWeaponFix(WizardMeta.class, StaffMeta.class, (staffMeta) -> staffMeta.instantiateObjectWithConstructor("staff", 10));
    }

    @DisplayName("Тест, что метод fix в классе Blacksmith отнимает золото у переданного мага за починку посоха")
    @Test
    void testFixDecreasesWizardGold() {
        testFixDecreasesGold(WizardMeta.class, StaffMeta.class, (staffMeta) -> staffMeta.instantiateObjectWithConstructor("staff", 10));
    }

    @DisplayName("Тест, что метод accept в классе Blacksmith увеличивает уровень кузнеца на 1")
    @Test
    void testAccept() {
        testAccept(IgniteHammerMeta.class);
    }

    @DisplayName("Тест, что метод insertStoneToWeapon в классе Blacksmith вставляет в переданный меч переданный камень урона")
    @Test
    void testInsertStoneToSword() {
        testInsertStoneToWeapon(SwordMeta.class, DamageStoneMeta.class);
    }

    @DisplayName("Тест, что метод insertStoneToWeapon в классе Blacksmith вставляет в переданный посох переданный камень лечения")
    @Test
    void testInsertStoneToStaff() {
        testInsertStoneToWeapon(StaffMeta.class, HealStoneMeta.class);
    }

    @DisplayName("Тест, что метод insertStoneToWeapon в классе Blacksmith вставляет в переданный лук переданный камень критического урона")
    @Test
    void testInsertStoneToBow() {
        testInsertStoneToWeapon(BowMeta.class, CriticalHitStoneMeta.class);
    }

    private void testInsertStoneToWeapon(Class<? extends WeaponMeta> weaponMetaClass, Class<? extends StoneMeta> stoneMetaClass) {
        Safer.runSafe(() -> {
            String methodName = "insertStoneToWeapon";
            Object blacksmith = getMeta().instantiateObjectWithConstructor("test", 1);
            Object weapon = MetaContext.getMeta(weaponMetaClass).instantiateObjectWithConstructor("test", 2);
            Object stone = MetaContext.getMeta(stoneMetaClass).instantiateObjectWithConstructor();

            BiConsumer<Object, Object[]> insertAssert = (obj, params) -> Safer.runSafe(() -> {
                String fieldName = "stone";
                Object actualStone = getFieldValue(weapon, fieldName);
                String message = getFieldValueAssert(getMeta().getClassName(), methodName, fieldName, stone, actualStone);
                assertEquals(stone, actualStone, message);
            });

            testClassMethod(insertAssert, blacksmith, methodName, weapon, stone);
        });
    }
}
