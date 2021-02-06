package com.idoit.item.weapon;

import com.idoit.AbstractTest;
import com.idoit.meta.item.weapon.SwordMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Sword")
class SwordTest extends AbstractTest {

    @BeforeEach
    void setUp() {
        setMeta(new SwordMeta());
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
        testConstructorSetsValueToFields(new Object[]{"test", 5});
    }
}
