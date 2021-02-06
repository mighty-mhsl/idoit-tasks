package com.idoit.item.common.food;

import com.idoit.meta.item.common.food.WineMeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Wine")
class WineTest extends FoodTest {

    @DisplayName("Тест, что класс Wine находится в пакете com.idoit.item.common.food")
    @Test
    void testWineIsInFoodPackage() {
        testFoodIsInPackage(WineMeta.CLASS_NAME);
    }
}
