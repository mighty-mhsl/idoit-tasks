package com.idoit.item.stone;

import com.idoit.AbstractTest;
import com.idoit.meta.item.stone.CriticalHitStoneMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе CriticalHitStone")
class CriticalHitStoneTest extends AbstractTest {

    @BeforeEach
    void setUp() {
        setMeta(CriticalHitStoneMeta.class);
    }

    @DisplayName("Тест, что класс CriticalHitStone находится в пакете com.idoit.item.stone")
    @Test
    void testCriticalHitStoneIsInSpecialPackage() {
        testClassIsInPackage();
    }
}
