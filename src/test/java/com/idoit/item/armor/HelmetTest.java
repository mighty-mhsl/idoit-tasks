package com.idoit.item.armor;

import com.idoit.meta.item.armor.HelmetMeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Helmet")
class HelmetTest extends ArmorTest {

    @DisplayName("Тест, что класс Helmet находится в пакете com.idoit.item.armor")
    @Test
    void testHelmetIsInArmorPackage() {
        testArmorIsInPackage(HelmetMeta.CLASS_NAME);
    }
}
