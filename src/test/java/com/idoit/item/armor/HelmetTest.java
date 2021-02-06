package com.idoit.item.armor;

import com.idoit.AbstractTest;
import com.idoit.meta.item.armor.HelmetMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Helmet")
class HelmetTest extends AbstractTest {

    @BeforeEach
    void setUp() {
        setMeta(new HelmetMeta());
    }

    @DisplayName("Тест, что класс Helmet находится в пакете com.idoit.item.armor")
    @Test
    void testHelmetIsInArmorPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Helmet имеет все необходимые поля")
    @Test
    void testHelmetHasAllFields() {
        testClassHasFields();
    }
}
