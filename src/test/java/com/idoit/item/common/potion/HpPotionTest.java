package com.idoit.item.common.potion;

import com.idoit.AbstractTest;
import com.idoit.meta.item.common.potion.HpPotionMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты логики в классе HpPotion")
class HpPotionTest extends AbstractTest {

    private HpPotionMeta.PotionLook potion;

    @BeforeEach
	void setUp() {
        setMeta(HpPotionMeta.class);
        HpPotionMeta meta = (HpPotionMeta) getMeta();
        potion = meta.getLook();
    }

    @DisplayName("Тест, что класс HpPotion находится в пакете com.idoit.item.common.potion")
    @Test
    void testHpPotionIsInPotionPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс HpPotion имеет все необходимые поля")
    @Test
    void testHpPotionHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе HpPotion есть конструктор принимающий название и очки восстановления зелья")
    @Test
    void testHpPotionHasConstructorWithNameAndPointsParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields("test", 3);
    }

    @DisplayName("Тест, что в классе HpPotion есть все необходимые методы")
    @Test
    void testHpPotionHasAllMethods() {
        testClassHasAllMethods();
    }

    @DisplayName("Тест, что метод getName в классе HpPotion возвращает название зелья")
    @Test
    void testGetName() {
        String expectedValue = "test";
        String actualValue = potion.getName();
        String message = getMethodReturnResultAssertMessage("getName", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getPointsToRecover в классе HpPotion возвращает название зелья")
    @Test
    void testGetPointsToRecover() {
        int expectedValue = 1;
        int actualValue = potion.getPointsToRecover();
        String message = getMethodReturnResultAssertMessage("getName", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }
}
