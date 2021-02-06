package com.idoit.item.bijouterie.necklace;

import com.idoit.AbstractTest;
import com.idoit.meta.item.bijouterie.necklace.IntelligenceNecklaceMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе IntelligenceNecklace")
class IntelligenceNecklaceTest extends AbstractTest {

    @BeforeEach
	void setUp() {
        setMeta(IntelligenceNecklaceMeta.class);
    }

    @DisplayName("Тест, что класс IntelligenceNecklace находится в пакете com.idoit.item.bijouterie.necklace")
    @Test
    void testIntelligenceNecklaceIsInBeltPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс IntelligenceNecklace имеет все необходимые поля")
    @Test
    void testIntelligenceNecklaceHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе IntelligenceNecklace есть конструктор принимающий название и добавляемые ожерельем очки")
    @Test
    void testIntelligenceNecklaceHasConstructorWithNameAndPointsParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields("test", 3);
    }
}
