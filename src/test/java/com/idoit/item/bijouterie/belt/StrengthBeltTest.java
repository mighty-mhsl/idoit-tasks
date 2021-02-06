package com.idoit.item.bijouterie.belt;

import com.idoit.meta.item.bijouterie.belt.StrengthBeltMeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе StrengthBelt")
class StrengthBeltTest extends BeltTest {

    @DisplayName("Тест, что класс StrengthBelt находится в пакете com.idoit.item.bijouterie.belt")
    @Test
    void testStrengthBeltIsInBeltPackage() {
        testBeltIsInPackage(StrengthBeltMeta.CLASS_NAME);
    }
}
