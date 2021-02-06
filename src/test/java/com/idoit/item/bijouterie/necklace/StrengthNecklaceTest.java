package com.idoit.item.bijouterie.necklace;

import com.idoit.AbstractTest;
import com.idoit.meta.item.bijouterie.necklace.StrengthNecklaceMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе StrengthNecklace")
class StrengthNecklaceTest extends AbstractTest {

    @BeforeEach
    void setUp() {
        setMeta(new StrengthNecklaceMeta());
    }

    @DisplayName("Тест, что класс StrengthNecklace находится в пакете com.idoit.item.bijouterie.necklace")
    @Test
    void testStrengthNecklaceIsInBeltPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс StrengthNecklace имеет все необходимые поля")
    @Test
    void testStrengthNecklaceHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе StrengthNecklace есть конструктор принимающий название и добавляемые ожерельем очки")
    @Test
    void testStrengthNecklaceHasConstructorWithNameAndPointsParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields(new Object[]{"test", 3});
    }
}
