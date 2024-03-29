package com.idoit.item.armor;

import com.idoit.AbstractTest;
import com.idoit.meta.item.armor.BootsMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты логики в классе Boots")
class BootsTest extends AbstractTest {

    private BootsMeta.ArmorLook boots;

    @BeforeEach
	void setUp() {
        setMeta(BootsMeta.class);
        BootsMeta meta = (BootsMeta) getMeta();
        boots = meta.getLook();
    }

    @DisplayName("Тест, что класс Boots находится в пакете com.idoit.item.armor")
    @Test
    void testBootsIsInArmorPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Boots имеет все необходимые поля")
    @Test
    void testBootsHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе Boots есть конструктор принимающий название и показатели защиты брони")
    @Test
    void testBootsHasConstructorWithNameAndBothDefenceParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields("test", 3, 4);
    }

    @DisplayName("Тест, что в классе Boots есть все необходимые методы")
    @Test
    void testBootsHasAllMethods() {
        testClassHasAllMethods();
    }

    @DisplayName("Тест, что метод setDurability в классе Boots сохраняет переданный durability в поле класса")
    @Test
    void testSetDurabilitySavesDurabilityToField() {
        int expectedValue = 5;
        boots.setDurability(expectedValue);
        String message = getSetterAssertMessage("setDurability", "durability", getMeta().getClassName());
        assertEquals(expectedValue, boots.getDurability(), message);
    }
}
