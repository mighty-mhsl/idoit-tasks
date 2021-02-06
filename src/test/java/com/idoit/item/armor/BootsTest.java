package com.idoit.item.armor;

import com.idoit.meta.item.armor.BootsMeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Boots")
class BootsTest extends ArmorTest {

    @DisplayName("Тест, что класс Boots находится в пакете com.idoit.item.armor")
    @Test
    void testBootsIsInArmorPackage() {
        testArmorIsInPackage(BootsMeta.CLASS_NAME);
    }
}
