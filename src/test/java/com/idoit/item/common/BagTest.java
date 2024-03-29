package com.idoit.item.common;

import com.idoit.AbstractTest;
import com.idoit.meta.item.common.BagMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Bag")
class BagTest extends AbstractTest {

    @BeforeEach
	void setUp() {
        setMeta(BagMeta.class);
    }

    @DisplayName("Тест, что класс Bag находится в пакете com.idoit.item.common")
    @Test
    void testBagIsInCommonPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Bag имеет все необходимые поля")
    @Test
    void testBagHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе Bag есть конструктор принимающий название сумки")
    @Test
    void testBagHasConstructorWithNameAndPointsParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields("test");
    }
}
