package com.idoit.item.weapon;

import com.idoit.meta.item.stone.HealStoneMeta;
import com.idoit.meta.item.weapon.StaffMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Staff")
class StaffTest extends WeaponTest {

    @BeforeEach
	void setUp() {
        setMeta(StaffMeta.class);
    }

    @DisplayName("Тест, что класс Staff находится в пакете com.idoit.item.weapon")
    @Test
    void testStaffIsInWeaponPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Staff имеет все необходимые поля")
    @Test
    void testStaffHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе Staff есть конструктор принимающий название и урон оружия")
    @Test
    void testStaffHasConstructorWithNameAndDamageParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields("test", 5);
    }

    @DisplayName("Тест, что в классе Staff есть все необходимые методы")
    @Test
    void testStaffHasAllMethods() {
        testClassHasAllMethods();
    }

    @DisplayName("Тест, что метод setDurability в классе Staff сохраняет переданный x в поле класса")
    @Test
    void testSetDurabilitySavesDurabilityToField() {
        testSetDurability();
    }

    @DisplayName("Тест, что метод setStone в классе Staff сохраняет полученный DamageStone в поле класса")
    @Test
    void testSetStoneSavesStoneToField() {
        testSetStone(HealStoneMeta.class);
    }

    @DisplayName("Тест, что метод getStone в классе Staff возвращает камень зачаровывания оружия")
    @Test
    void testGetStone() {
        testGetStone(HealStoneMeta.class);
    }
}
