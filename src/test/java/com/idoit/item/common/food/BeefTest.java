package com.idoit.item.common.food;

import com.idoit.meta.item.common.food.BeefMeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Beef")
class BeefTest extends FoodTest {

    @DisplayName("Тест, что класс Beef находится в пакете com.idoit.item.common.food")
    @Test
    void testBeefIsInFoodPackage() {
        testFoodIsInPackage(BeefMeta.CLASS_NAME);
    }
}
