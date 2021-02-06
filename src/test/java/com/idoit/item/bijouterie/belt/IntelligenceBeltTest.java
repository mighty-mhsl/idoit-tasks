package com.idoit.item.bijouterie.belt;

import com.idoit.AbstractTest;
import com.idoit.meta.item.bijouterie.belt.IntelligenceBeltMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе IntelligenceBelt")
class IntelligenceBeltTest extends AbstractTest {

    @BeforeEach
    void setUp() {
        setMeta(new IntelligenceBeltMeta());
    }

    @DisplayName("Тест, что класс IntelligenceBelt находится в пакете com.idoit.item.bijouterie.belt")
    @Test
    void testStrengthBeltIsInBeltPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс IntelligenceBelt имеет все необходимые поля")
    @Test
    void testIntelligenceBeltHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе IntelligenceBelt есть конструктор принимающий название и добавляемые ремнем очки")
    @Test
    void testIntelligenceBeltHasConstructorWithNameAndPointsParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields(new Object[]{"test", 3});
    }
}
