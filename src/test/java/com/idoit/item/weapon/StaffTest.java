package com.idoit.item.weapon;

import com.idoit.AbstractTest;
import com.idoit.meta.item.weapon.StaffMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Staff")
class StaffTest extends AbstractTest {

    @BeforeEach
    void setUp() {
        setMeta(new StaffMeta());
    }

    @DisplayName("Тест, что класс Staff находится в пакете com.idoit.item.weapon")
    @Test
    void testStaffIsInWeaponPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Staff имеет все необходимые поля")
    @Test
    void testStaffHasAllFields() {
        testClassHasFields();
    }
}
