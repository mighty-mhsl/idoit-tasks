package com.idoit.item.common.food;

import com.idoit.AbstractTest;
import com.idoit.meta.item.common.food.AppleMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Apple")
class AppleTest extends AbstractTest {

    @BeforeEach
	void setUp() {
        setMeta(AppleMeta.class);
    }

    @DisplayName("Тест, что класс Apple находится в пакете com.idoit.item.common.food")
    @Test
    void testAppleIsInFoodPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Apple имеет все необходимые поля")
    @Test
    void testAppleHasAllFields() {
        testClassHasFields();
    }
}
