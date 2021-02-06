package com.idoit.item.weapon;

import com.idoit.meta.item.weapon.SwordMeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Sword")
class SwordTest extends WeaponTest {

    @DisplayName("Тест, что класс Sword находится в пакете com.idoit.item.weapon")
    @Test
    void testSwordIsInWeaponPackage() {
        testWeaponIsInPackage(SwordMeta.CLASS_NAME);
    }
}
