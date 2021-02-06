package com.idoit.item.bijouterie.ring;

import com.idoit.meta.item.bijouterie.ring.AgilityRingMeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе AgilityRing")
class AgilityRingTest extends RingTest {

    @DisplayName("Тест, что класс AgilityRing находится в пакете com.idoit.item.bijouterie.ring")
    @Test
    void testAgilityRingIsInBeltPackage() {
        testRingIsInPackage(AgilityRingMeta.CLASS_NAME);
    }
}
