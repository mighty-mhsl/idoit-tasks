package com.idoit.item.stone;

import com.idoit.AbstractTest;
import com.idoit.meta.item.stone.DamageStoneMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе DamageStone")
class DamageStoneTest extends AbstractTest {

    @BeforeEach
    void setUp() {
        setMeta(DamageStoneMeta.class);
    }

    @DisplayName("Тест, что класс DamageStone находится в пакете com.idoit.item.stone")
    @Test
    void testDamageStoneIsInSpecialPackage() {
        testClassIsInPackage();
    }
}
