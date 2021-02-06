package com.idoit.item.armor;

import com.idoit.AbstractTest;
import com.idoit.meta.item.armor.BootsMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Boots")
class BootsTest extends AbstractTest {

    @BeforeEach
    void setUp() {
        setMeta(new BootsMeta());
    }

    @DisplayName("Тест, что класс Boots находится в пакете com.idoit.item.armor")
    @Test
    void testBootsIsInArmorPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Boots имеет все необходимые поля")
    @Test
    void testBootsHasAllFields() {
        testClassHasFields();
    }
}
