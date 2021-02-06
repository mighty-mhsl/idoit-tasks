package com.idoit.item.common.potion;

import com.idoit.meta.item.common.potion.HpPotionMeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе HpPotion")
class HpPotionTest extends PotionTest {

    @DisplayName("Тест, что класс HpPotion находится в пакете com.idoit.item.common.potion")
    @Test
    void testHpPotionIsInPotionPackage() {
        testPotionIsInPackage(HpPotionMeta.CLASS_NAME);
    }
}
