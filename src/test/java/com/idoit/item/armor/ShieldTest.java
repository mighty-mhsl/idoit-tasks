package com.idoit.item.armor;

import com.idoit.AbstractTest;
import com.idoit.meta.item.armor.ShieldMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты логики в классе Shield")
class ShieldTest extends AbstractTest {

    private ShieldMeta.ArmorLook shield;

    @BeforeEach
	void setUp() {
        setMeta(ShieldMeta.class);
        ShieldMeta meta = (ShieldMeta) getMeta();
        shield = meta.getLook();
    }

    @DisplayName("Тест, что класс Shield находится в пакете com.idoit.item.armor")
    @Test
    void testShieldIsInArmorPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Shield имеет все необходимые поля")
    @Test
    void testShieldHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе Shield есть конструктор принимающий название и показатели защиты брони")
    @Test
    void testShieldHasConstructorWithNameAndBothDefenceParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields("test", 3, 4);
    }

    @DisplayName("Тест, что в классе Shield есть все необходимые методы")
    @Test
    void testShieldHasAllMethods() {
        testClassHasAllMethods();
    }

    @DisplayName("Тест, что метод setDurability в классе Shield сохраняет переданный durability в поле класса")
    @Test
    void testSetDurabilitySavesDurabilityToField() {
        int expectedValue = 5;
        shield.setDurability(expectedValue);
        String message = getSetterAssertMessage("setDurability", "durability", getMeta().getClassName());
        assertEquals(expectedValue, shield.getDurability(), message);
    }
}