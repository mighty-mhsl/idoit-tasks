package com.idoit.item.armor;

import com.idoit.AbstractTest;
import com.idoit.meta.item.armor.ShieldMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Shield")
class ShieldTest extends AbstractTest {

    @BeforeEach
    void setUp() {
        setMeta(new ShieldMeta());
    }

    @DisplayName("Тест, что класс Shield находится в пакете com.idoit.item.armor")
    @Test
    void testShieldIsInArmorPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Shield имеет все необходимые поля")
    @Test
    void testShieldHasAllFields() {
        testClassHasFields();
    }
}