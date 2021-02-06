package com.idoit.item.weapon;

import com.idoit.meta.item.stone.CriticalHitStoneMeta;
import com.idoit.meta.item.weapon.BowMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Bow")
class BowTest extends WeaponTest {

    @BeforeEach
	void setUp() {
        setMeta(BowMeta.class);
    }

    @DisplayName("Тест, что класс Bow находится в пакете com.idoit.item.weapon")
    @Test
    void testBowIsInWeaponPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Bow имеет все необходимые поля")
    @Test
    void testBowHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе Bow есть конструктор принимающий название и урон оружия")
    @Test
    void testBowHasConstructorWithNameAndDamageParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields("test", 5);
    }

    @DisplayName("Тест, что в классе Bow есть все необходимые методы")
    @Test
    void testBowHasAllMethods() {
        testClassHasAllMethods();
    }

    @DisplayName("Тест, что метод setDurability в классе Bow сохраняет переданный x в поле класса")
    @Test
    void testSetDurabilitySavesDurabilityToField() {
        testSetDurability();
    }

    @DisplayName("Тест, что метод setStone в классе Bow сохраняет полученный DamageStone в поле класса")
    @Test
    void testSetStoneSavesStoneToField() {
        testSetStone(CriticalHitStoneMeta.class);
    }

    @DisplayName("Тест, что метод getStone в классе Bow возвращает камень зачаровывания оружия")
    @Test
    void testGetStone() {
        testGetStone(CriticalHitStoneMeta.class);
    }
}
