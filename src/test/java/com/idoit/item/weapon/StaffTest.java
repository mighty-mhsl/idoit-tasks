package com.idoit.item.weapon;

import com.idoit.AbstractTest;
import com.idoit.meta.MetaContext;
import com.idoit.meta.item.stone.HealStoneMeta;
import com.idoit.meta.item.weapon.StaffMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты логики в классе Staff")
class StaffTest extends AbstractTest {

    private StaffMeta.StaffLook staff;

    @BeforeEach
	void setUp() {
        setMeta(StaffMeta.class);
        StaffMeta meta = (StaffMeta) getMeta();
        staff = meta.getLook();
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
        int expectedValue = 5;
        staff.setDurability(expectedValue);
        String message = getSetterAssertMessage("setDurability", "durability", getMeta().getClassName());
        assertEquals(expectedValue, staff.getDurability(), message);
    }

    @DisplayName("Тест, что метод setStone в классе Staff сохраняет полученный DamageStone в поле класса")
    @Test
    void testSetStoneSavesStoneToField() {
        HealStoneMeta stone = (HealStoneMeta) MetaContext.getMeta(HealStoneMeta.class);
        staff.setStone(stone);
        String message = getSetterAssertMessage("setStone", stone.getClassName(), getMeta().getClassName());
        assertEquals(stone, staff.getStone(), message);
    }

    @DisplayName("Тест, что метод getStone в классе Staff возвращает камень зачаровывания оружия")
    @Test
    void testGetStone() {
        HealStoneMeta stone = (HealStoneMeta) MetaContext.getMeta(HealStoneMeta.class);
        staff.setStone(stone);
        HealStoneMeta actualValue = staff.getStone();
        String message = getMethodReturnResultAssertMessage("getStone", stone, actualValue);
        assertEquals(stone, actualValue, message);
    }
}
