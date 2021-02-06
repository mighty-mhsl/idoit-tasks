package com.idoit.item.weapon;

import com.idoit.AbstractTest;
import com.idoit.meta.item.weapon.BowMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Bow")
class BowTest extends AbstractTest {

    @BeforeEach
    void setUp() {
        setMeta(new BowMeta());
    }

    @DisplayName("Тест, что класс Bow находится в пакете com.idoit.item.weapon")
    @Test
    void testBowIsInWeaponPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Bow имеет все необходимые поля")
    @Test
    void testBowHasAllFields() {
        testClassHasFields();
    }
}
