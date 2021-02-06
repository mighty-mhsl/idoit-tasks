package com.idoit.item.armor;

import com.idoit.AbstractTest;
import com.idoit.meta.item.armor.HelmetMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты логики в классе Helmet")
class HelmetTest extends AbstractTest {

    private HelmetMeta.ArmorLook helmet;

    @BeforeEach
	void setUp() {
        setMeta(HelmetMeta.class);
        HelmetMeta meta = (HelmetMeta) getMeta();
        helmet = meta.getLook();
    }

    @DisplayName("Тест, что класс Helmet находится в пакете com.idoit.item.armor")
    @Test
    void testHelmetIsInArmorPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Helmet имеет все необходимые поля")
    @Test
    void testHelmetHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе Helmet есть конструктор принимающий название и показатели защиты брони")
    @Test
    void testHelmetHasConstructorWithNameAndBothDefenceParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields("test", 3, 4);
    }

    @DisplayName("Тест, что в классе Helmet есть все необходимые методы")
    @Test
    void testHelmetHasAllMethods() {
        testClassHasAllMethods();
    }

    @DisplayName("Тест, что метод setDurability в классе Helmet сохраняет переданный durability в поле класса")
    @Test
    void testSetDurabilitySavesDurabilityToField() {
        int expectedValue = 5;
        helmet.setDurability(expectedValue);
        String message = getSetterAssertMessage("setDurability", "durability", getMeta().getClassName());
        assertEquals(expectedValue, helmet.getDurability(), message);
    }
}
