package com.idoit.item.bijouterie.ring;

import com.idoit.meta.item.bijouterie.ring.StrengthRingMeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе StrengthRing")
class StrengthRingTest extends RingTest {

    @DisplayName("Тест, что класс StrengthRing находится в пакете com.idoit.item.bijouterie.ring")
    @Test
    void testStrengthRingIsInBeltPackage() {
        testRingIsInPackage(StrengthRingMeta.CLASS_NAME);
    }
}
