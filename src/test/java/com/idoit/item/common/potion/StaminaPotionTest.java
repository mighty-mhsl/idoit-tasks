package com.idoit.item.common.potion;

import com.idoit.meta.item.common.potion.StaminaPotionMeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе StaminaPotion")
class StaminaPotionTest extends PotionTest {

    @DisplayName("Тест, что класс StaminaPotion находится в пакете com.idoit.item.common.potion")
    @Test
    void testStaminaPotionIsInPotionPackage() {
        testPotionIsInPackage(StaminaPotionMeta.CLASS_NAME);
    }
}
