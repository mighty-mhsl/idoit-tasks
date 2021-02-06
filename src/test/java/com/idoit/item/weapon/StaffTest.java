package com.idoit.item.weapon;

import com.idoit.meta.item.weapon.StaffMeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Staff")
class StaffTest extends WeaponTest {

    @DisplayName("Тест, что класс Staff находится в пакете com.idoit.item.weapon")
    @Test
    void testStaffIsInWeaponPackage() {
        testWeaponIsInPackage(StaffMeta.CLASS_NAME);
    }
}
