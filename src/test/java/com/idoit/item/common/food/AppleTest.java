package com.idoit.item.common.food;

import com.idoit.meta.item.common.food.AppleMeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Apple")
class AppleTest extends FoodTest {

    @DisplayName("Тест, что класс Apple находится в пакете com.idoit.item.common.food")
    @Test
    void testAppleIsInFoodPackage() {
        testFoodIsInPackage(AppleMeta.CLASS_NAME);
    }
}
