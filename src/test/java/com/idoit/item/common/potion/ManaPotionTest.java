package com.idoit.item.common.potion;

import com.idoit.meta.item.common.potion.ManaPotionMeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе ManaPotion")
class ManaPotionTest extends PotionTest {

    @DisplayName("Тест, что класс ManaPotion находится в пакете com.idoit.item.common.potion")
    @Test
    void testManaPotionIsInPotionPackage() {
        testPotionIsInPackage(ManaPotionMeta.CLASS_NAME);
    }
}
