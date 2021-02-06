package com.idoit.item.bijouterie.ring;

import com.idoit.AbstractTest;
import com.idoit.meta.item.bijouterie.ring.AgilityRingMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе AgilityRing")
class AgilityRingTest extends AbstractTest {

    @BeforeEach
	void setUp() {
        setMeta(AgilityRingMeta.class);
    }

    @DisplayName("Тест, что класс AgilityRing находится в пакете com.idoit.item.bijouterie.ring")
    @Test
    void testAgilityRingIsInBeltPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс AgilityRing имеет все необходимые поля")
    @Test
    void testAgilityRingHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе AgilityRing есть конструктор принимающий название и добавляемые кольцом очки")
    @Test
    void testAgilityRingHasConstructorWithNameAndPointsParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields("test", 3);
    }
}
