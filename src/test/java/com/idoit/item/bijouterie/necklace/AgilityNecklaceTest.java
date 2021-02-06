package com.idoit.item.bijouterie.necklace;

import com.idoit.AbstractTest;
import com.idoit.meta.item.bijouterie.necklace.AgilityNecklaceMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе AgilityNecklace")
class AgilityNecklaceTest extends AbstractTest {

    @BeforeEach
	void setUp() {
        setMeta(AgilityNecklaceMeta.class);
    }

    @DisplayName("Тест, что класс AgilityNecklace находится в пакете com.idoit.item.bijouterie.necklace")
    @Test
    void testAgilityNecklaceIsInBeltPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс AgilityNecklace имеет все необходимые поля")
    @Test
    void testAgilityNecklaceHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе AgilityNecklace есть конструктор принимающий название и добавляемые ожерельем очки")
    @Test
    void testAgilityNecklaceHasConstructorWithNameAndPointsParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields("test", 3);
    }
}