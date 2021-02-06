package com.idoit.item.bijouterie.belt;

import com.idoit.meta.item.bijouterie.belt.IntelligenceBeltMeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе IntelligenceBelt")
class IntelligenceBeltTest extends BeltTest {

    @DisplayName("Тест, что класс IntelligenceBelt находится в пакете com.idoit.item.bijouterie.belt")
    @Test
    void testStrengthBeltIsInBeltPackage() {
        testBeltIsInPackage(IntelligenceBeltMeta.CLASS_NAME);
    }
}
