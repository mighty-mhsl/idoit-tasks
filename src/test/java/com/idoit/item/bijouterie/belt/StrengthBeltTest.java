package com.idoit.item.bijouterie.belt;

import com.idoit.AbstractTest;
import com.idoit.meta.item.bijouterie.belt.StrengthBeltMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе StrengthBelt")
class StrengthBeltTest extends AbstractTest {

    @BeforeEach
	void setUp() {
        setMeta(StrengthBeltMeta.class);
    }

    @DisplayName("Тест, что класс StrengthBelt находится в пакете com.idoit.item.bijouterie.belt")
    @Test
    void testStrengthBeltIsInBeltPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс StrengthBelt имеет все необходимые поля")
    @Test
    void testStrengthBeltHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе StrengthBelt есть конструктор принимающий название и добавляемые ремнем очки")
    @Test
    void testStrengthBeltHasConstructorWithNameAndPointsParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields("test", 3);
    }
}
