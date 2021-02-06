package com.idoit.item.armor;

import com.idoit.meta.item.armor.CuirassMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Cuirass")
class CuirassTest extends ArmorTest {

    @BeforeEach
	void setUp() {
        setMeta(CuirassMeta.class);
    }

    @DisplayName("Тест, что класс Cuirass находится в пакете com.idoit.item.armor")
    @Test
    void testCuirassIsInArmorPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Cuirass имеет все необходимые поля")
    @Test
    void testCuirassHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе Cuirass есть конструктор принимающий название и показатели защиты брони")
    @Test
    void testCuirassHasConstructorWithNameAndBothDefenceParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields("test", 3, 4);
    }

    @DisplayName("Тест, что в классе Cuirass есть все необходимые методы")
    @Test
    void testCuirassHasAllMethods() {
        testClassHasAllMethods();
    }

    @DisplayName("Тест, что метод setDurability в классе Cuirass сохраняет переданный durability в поле класса")
    @Test
    void testSetDurabilitySavesDurabilityToField() {
        testSetDurability();
    }
}
