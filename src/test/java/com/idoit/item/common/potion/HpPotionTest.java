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
        setMeta(new HpPotionMeta());
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
        testConstructorSetsValueToFields(new Object[]{"test", 3});
    }
}
