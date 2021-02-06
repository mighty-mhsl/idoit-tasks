package com.idoit.item.armor;

import com.idoit.meta.item.armor.GlovesMeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Gloves")
class GlovesTest extends ArmorTest {

    @DisplayName("Тест, что класс Gloves находится в пакете com.idoit.item.armor")
    @Test
    void testGlovesIsInArmorPackage() {
        testArmorIsInPackage(GlovesMeta.CLASS_NAME);
    }
}
