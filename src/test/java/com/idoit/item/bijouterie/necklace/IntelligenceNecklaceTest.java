package com.idoit.item.bijouterie.necklace;

import com.idoit.meta.item.bijouterie.necklace.IntelligenceNecklaceMeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе IntelligenceNecklace")
class IntelligenceNecklaceTest extends NecklaceTest {

    @DisplayName("Тест, что класс IntelligenceNecklace находится в пакете com.idoit.item.bijouterie.necklace")
    @Test
    void testIntelligenceNecklaceIsInBeltPackage() {
        testNecklaceIsInPackage(IntelligenceNecklaceMeta.CLASS_NAME);
    }
}
