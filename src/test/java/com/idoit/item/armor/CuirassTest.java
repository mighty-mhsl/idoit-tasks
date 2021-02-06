package com.idoit.item.armor;

import com.idoit.meta.item.armor.CuirassMeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Cuirass")
class CuirassTest extends ArmorTest {

    @DisplayName("Тест, что класс Cuirass находится в пакете com.idoit.item.armor")
    @Test
    void testCuirassIsInArmorPackage() {
        testArmorIsInPackage(CuirassMeta.CLASS_NAME);
    }
}
