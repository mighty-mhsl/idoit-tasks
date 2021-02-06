package com.idoit.item.common.potion;

import com.idoit.AbstractTest;
import com.idoit.meta.item.common.potion.HpPotionMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе HpPotion")
class HpPotionTest extends AbstractTest {

    @BeforeEach
	void setUp() {
        setMeta(HpPotionMeta.class);
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
        testGetter("getName", "setName", "test", "test", 10);
    }

    @DisplayName("Тест, что метод getPointsToRecover в классе HpPotion возвращает название зелья")
    @Test
    void testGetPointsToRecover() {
        testGetter("getPointsToRecover", "setPointsToRecover", 10, "test", 10);
    }
}
