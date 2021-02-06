package com.idoit.item.common.food;

import com.idoit.AbstractTest;
import com.idoit.meta.item.common.food.BeefMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Beef")
class BeefTest extends AbstractTest {

    @BeforeEach
    void setUp() {
        setMeta(new BeefMeta());
    }

    @DisplayName("Тест, что класс Beef находится в пакете com.idoit.item.common.food")
    @Test
    void testBeefIsInFoodPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Beef имеет все необходимые поля")
    @Test
    void testBeefHasAllFields() {
        testClassHasFields();
    }
}
