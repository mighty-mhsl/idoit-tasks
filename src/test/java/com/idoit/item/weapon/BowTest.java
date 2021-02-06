package com.idoit.item.weapon;

import com.idoit.meta.item.weapon.BowMeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Bow")
class BowTest extends WeaponTest {

    @DisplayName("Тест, что класс Bow находится в пакете com.idoit.item.weapon")
    @Test
    void testBowIsInWeaponPackage() {
        testWeaponIsInPackage(BowMeta.CLASS_NAME);
    }
}
