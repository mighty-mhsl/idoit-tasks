package com.idoit.item.bijouterie.necklace;

import com.idoit.meta.item.bijouterie.necklace.AgilityNecklaceMeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе AgilityNecklace")
class AgilityNecklaceTest extends NecklaceTest {

    @DisplayName("Тест, что класс AgilityNecklace находится в пакете com.idoit.item.bijouterie.necklace")
    @Test
    void testAgilityNecklaceIsInBeltPackage() {
        testNecklaceIsInPackage(AgilityNecklaceMeta.CLASS_NAME);
    }
}