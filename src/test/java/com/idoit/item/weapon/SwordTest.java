package com.idoit.item.weapon;

import com.idoit.meta.item.weapon.SwordMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Sword")
class SwordTest extends WeaponTest {

    @BeforeEach
	void setUp() {
        setMeta(SwordMeta.class);
    }

    @DisplayName("Тест, что класс Sword находится в пакете com.idoit.item.weapon")
    @Test
    void testSwordIsInWeaponPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Sword имеет все необходимые поля")
    @Test
    void testSwordHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе Sword есть конструктор принимающий название и урон оружия")
    @Test
    void testSwordHasConstructorWithNameAndDamageParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields("test", 5);
    }

    @DisplayName("Тест, что в классе Sword есть все необходимые методы")
    @Test
    void testSwordHasAllMethods() {
        testClassHasAllMethods();
    }

    @DisplayName("Тест, что метод setDurability в классе Sword сохраняет переданный x в поле класса")
    @Test
    void testSetDurabilitySavesDurabilityToField() {
        testSetDurability();
    }
}
