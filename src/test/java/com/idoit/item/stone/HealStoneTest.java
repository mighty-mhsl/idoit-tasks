package com.idoit.item.stone;

import com.idoit.AbstractTest;
import com.idoit.meta.item.stone.HealStoneMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе HealStone")
class HealStoneTest extends AbstractTest {

    @BeforeEach
    void setUp() {
        setMeta(HealStoneMeta.class);
    }

    @DisplayName("Тест, что класс HealStone находится в пакете com.idoit.item.stone")
    @Test
    void testHealStoneIsInSpecialPackage() {
        testClassIsInPackage();
    }
}
