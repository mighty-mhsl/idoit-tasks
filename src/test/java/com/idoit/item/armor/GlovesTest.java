package com.idoit.item.armor;

import com.idoit.AbstractTest;
import com.idoit.meta.item.armor.GlovesMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты логики в классе Gloves")
class GlovesTest extends AbstractTest {

    private GlovesMeta.ArmorLook gloves;

    @BeforeEach
	void setUp() {
        setMeta(GlovesMeta.class);
        GlovesMeta meta = (GlovesMeta) getMeta();
        gloves = meta.getLook();
    }

    @DisplayName("Тест, что класс Gloves находится в пакете com.idoit.item.armor")
    @Test
    void testGlovesIsInArmorPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Gloves имеет все необходимые поля")
    @Test
    void testGlovesHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе Gloves есть конструктор принимающий название и показатели защиты брони")
    @Test
    void testGlovesHasConstructorWithNameAndBothDefenceParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields("test", 3, 4);
    }

    @DisplayName("Тест, что в классе Gloves есть все необходимые методы")
    @Test
    void testGlovesHasAllMethods() {
        testClassHasAllMethods();
    }

    @DisplayName("Тест, что метод setDurability в классе Gloves сохраняет переданный durability в поле класса")
    @Test
    void testSetDurabilitySavesDurabilityToField() {
        int expectedValue = 5;
        gloves.setDurability(expectedValue);
        String message = getSetterAssertMessage("setDurability", "durability", getMeta().getClassName());
        assertEquals(expectedValue, gloves.getDurability(), message);
    }
}
