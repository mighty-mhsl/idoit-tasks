package com.idoit.item.common.potion;

import com.idoit.AbstractTest;
import com.idoit.meta.item.common.potion.ManaPotionMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты логики в классе ManaPotion")
class ManaPotionTest extends AbstractTest {

    private ManaPotionMeta.PotionLook potion;

    @BeforeEach
	void setUp() {
        setMeta(ManaPotionMeta.class);
        ManaPotionMeta meta = (ManaPotionMeta) getMeta();
        potion = meta.getLook();
    }

    @DisplayName("Тест, что класс ManaPotion находится в пакете com.idoit.item.common.potion")
    @Test
    void testManaPotionIsInPotionPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс ManaPotion имеет все необходимые поля")
    @Test
    void testManaPotionHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе ManaPotion есть конструктор принимающий название и очки восстановления зелья")
    @Test
    void testManaPotionHasConstructorWithNameAndPointsParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields("test", 3);
    }

    @DisplayName("Тест, что в классе ManaPotion есть все необходимые методы")
    @Test
    void testManaPotionHasAllMethods() {
        testClassHasAllMethods();
    }

    @DisplayName("Тест, что метод getName в классе ManaPotion возвращает название зелья")
    @Test
    void testGetName() {
        String expectedValue = "test";
        String actualValue = potion.getName();
        String message = getMethodReturnResultAssertMessage("getName", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getPointsToRecover в классе ManaPotion возвращает очки восстановления зелья")
    @Test
    void testGetPointsToRecover() {
        int expectedValue = 1;
        int actualValue = potion.getPointsToRecover();
        String message = getMethodReturnResultAssertMessage("getPointsToRecover", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }
}
