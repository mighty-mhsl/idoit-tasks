package com.idoit.item.bijouterie.belt;

import com.idoit.meta.item.bijouterie.belt.AgilityBeltMeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе AgilityBelt")
class AgilityBeltTest extends BeltTest {

    @DisplayName("Тест, что класс AgilityBelt находится в пакете com.idoit.item.bijouterie.belt")
    @Test
    void testAgilityBeltIsInBeltPackage() {
        testBeltIsInPackage(AgilityBeltMeta.CLASS_NAME);
    }
}
