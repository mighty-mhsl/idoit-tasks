package com.idoit.item.bijouterie.ring;

import com.idoit.AbstractTest;
import com.idoit.meta.item.bijouterie.ring.StrengthRingMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе StrengthRing")
class StrengthRingTest extends AbstractTest {

    @BeforeEach
    void setUp() {
        setMeta(new StrengthRingMeta());
    }

    @DisplayName("Тест, что класс StrengthRing находится в пакете com.idoit.item.bijouterie.ring")
    @Test
    void testStrengthRingIsInBeltPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс StrengthRing имеет все необходимые поля")
    @Test
    void testStrengthRingHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе StrengthRing есть конструктор принимающий название и добавляемые кольцом очки")
    @Test
    void testStrengthRingHasConstructorWithNameAndPointsParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields(new Object[]{"test", 3});
    }
}
