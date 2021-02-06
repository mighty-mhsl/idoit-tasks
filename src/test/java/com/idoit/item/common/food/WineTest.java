package com.idoit.item.common.food;

import com.idoit.AbstractTest;
import com.idoit.meta.item.common.food.WineMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Wine")
class WineTest extends AbstractTest {

    @BeforeEach
	void setUp() {
        setMeta(WineMeta.class);
    }

    @DisplayName("Тест, что класс Wine находится в пакете com.idoit.item.common.food")
    @Test
    void testWineIsInFoodPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Beef имеет все необходимые поля")
    @Test
    void testBeefHasAllFields() {
        testClassHasFields();
    }
}
