package com.idoit.item.armor;

import com.idoit.AbstractTest;
import com.idoit.meta.item.armor.CuirassMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Cuirass")
class CuirassTest extends AbstractTest {

    @BeforeEach
    void setUp() {
        setMeta(new CuirassMeta());
    }

    @DisplayName("Тест, что класс Cuirass находится в пакете com.idoit.item.armor")
    @Test
    void testCuirassIsInArmorPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Cuirass имеет все необходимые поля")
    @Test
    void testCuirassHasAllFields() {
        testClassHasFields();
    }
}
