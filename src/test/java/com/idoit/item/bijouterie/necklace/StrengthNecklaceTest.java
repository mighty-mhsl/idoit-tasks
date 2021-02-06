package com.idoit.item.bijouterie.necklace;

import com.idoit.meta.item.bijouterie.necklace.StrengthNecklaceMeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе StrengthNecklace")
class StrengthNecklaceTest extends NecklaceTest {

    @DisplayName("Тест, что класс StrengthNecklace находится в пакете com.idoit.item.bijouterie.necklace")
    @Test
    void testStrengthNecklaceIsInBeltPackage() {
        testNecklaceIsInPackage(StrengthNecklaceMeta.CLASS_NAME);
    }
}
