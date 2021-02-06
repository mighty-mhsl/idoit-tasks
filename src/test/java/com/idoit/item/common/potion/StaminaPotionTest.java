package com.idoit.item.common.potion;

import com.idoit.AbstractTest;
import com.idoit.meta.item.common.potion.PotionMeta;
import com.idoit.meta.item.common.potion.StaminaPotionMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты логики в классе StaminaPotion")
class StaminaPotionTest extends AbstractTest {

    private PotionMeta.PotionLook potion;

    @BeforeEach
	void setUp() {
        setMeta(StaminaPotionMeta.class);
        PotionMeta meta = (PotionMeta) getMeta();
        potion = meta.getLook();
    }

    @DisplayName("Тест, что класс StaminaPotion находится в пакете com.idoit.item.common.potion")
    @Test
    void testStaminaPotionIsInPotionPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс StaminaPotion имеет все необходимые поля")
    @Test
    void testStaminaPotionHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе StaminaPotion есть конструктор принимающий название и очки восстановления зелья")
    @Test
    void testStaminaPotionHasConstructorWithNameAndPointsParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields("test", 3);
    }

    @DisplayName("Тест, что в классе StaminaPotion есть все необходимые методы")
    @Test
    void testStaminaPotionHasAllMethods() {
        testClassHasAllMethods();
    }

    @DisplayName("Тест, что метод getName в классе StaminaPotion возвращает название зелья")
    @Test
    void testGetName() {
        String expectedValue = "test";
        String actualValue = potion.getName();
        String message = getMethodReturnResultAssertMessage("getName", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getPointsToRecover в классе StaminaPotion возвращает название зелья")
    @Test
    void testGetPointsToRecover() {
        int expectedValue = 1;
        int actualValue = potion.getPointsToRecover();
        String message = getMethodReturnResultAssertMessage("getName", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }
}
