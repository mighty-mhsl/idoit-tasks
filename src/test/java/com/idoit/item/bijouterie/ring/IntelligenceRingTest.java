package com.idoit.item.bijouterie.ring;

import com.idoit.meta.item.bijouterie.ring.IntelligenceRingMeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе IntelligenceRing")
class IntelligenceTest extends RingTest {

    @DisplayName("Тест, что класс IntelligenceRing находится в пакете com.idoit.item.bijouterie.ring")
    @Test
    void testIntelligenceRingIsInBeltPackage() {
        testRingIsInPackage(IntelligenceRingMeta.CLASS_NAME);
    }
}
