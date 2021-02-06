package com.idoit.item.armor;

import com.idoit.AbstractTest;
import com.idoit.meta.item.armor.CuirassMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты логики в классе Cuirass")
class CuirassTest extends AbstractTest {

    private CuirassMeta.ArmorLook cuirass;

    @BeforeEach
	void setUp() {
        setMeta(CuirassMeta.class);
        CuirassMeta meta = (CuirassMeta) getMeta();
        cuirass = meta.getLook();
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
        int expectedValue = 5;
        cuirass.setDurability(expectedValue);
        String message = getSetterAssertMessage("setDurability", "durability", getMeta().getClassName());
        assertEquals(expectedValue, cuirass.getDurability(), message);
    }
}
