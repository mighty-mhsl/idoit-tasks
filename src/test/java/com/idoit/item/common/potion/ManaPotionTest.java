package com.idoit.item.common.potion;

import com.idoit.AbstractTest;
import com.idoit.meta.item.common.potion.ManaPotionMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе ManaPotion")
class ManaPotionTest extends AbstractTest {

    @BeforeEach
	void setUp() {
        setMeta(ManaPotionMeta.class);
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
        testGetter("getName", "setName", "test", "test", 10);
    }

    @DisplayName("Тест, что метод getPointsToRecover в классе ManaPotion возвращает название зелья")
    @Test
    void testGetPointsToRecover() {
        testGetter("getPointsToRecover", "setPointsToRecover", 10, "test", 10);
    }
}
