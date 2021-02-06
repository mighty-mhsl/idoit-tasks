package com.idoit.item.armor;

import com.idoit.meta.item.armor.ShieldMeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Shield")
class ShieldTest extends ArmorTest {

    @DisplayName("Тест, что класс Shield находится в пакете com.idoit.item.armor")
    @Test
    void testShieldIsInArmorPackage() {
        testArmorIsInPackage(ShieldMeta.CLASS_NAME);
    }
}