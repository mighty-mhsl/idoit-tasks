package com.idoit.item.bijouterie.belt;

import com.idoit.AbstractTest;
import com.idoit.meta.item.bijouterie.belt.AgilityBeltMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе AgilityBelt")
class AgilityBeltTest extends AbstractTest {

    @BeforeEach
	void setUp() {
        setMeta(AgilityBeltMeta.class);
    }

    @DisplayName("Тест, что класс AgilityBelt находится в пакете com.idoit.item.bijouterie.belt")
    @Test
    void testAgilityBeltIsInBeltPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс AgilityBelt имеет все необходимые поля")
    @Test
    void testAgilityBeltHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе AgilityBelt есть конструктор принимающий название и добавляемые ремнем очки")
    @Test
    void testAgilityBeltHasConstructorWithNameAndPointsParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields("test", 3);
    }
}
