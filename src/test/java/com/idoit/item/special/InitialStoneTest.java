package com.idoit.item.special;

import com.idoit.AbstractTest;
import com.idoit.meta.item.special.InitialStoneMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе InitialStone")
class InitialStoneTest extends AbstractTest {

    @BeforeEach
    void setUp() {
        setMeta(InitialStoneMeta.class);
    }

    @DisplayName("Тест, что класс InitialStone находится в пакете com.idoit.item.special")
    @Test
    void testInitialStoneIsInSpecialPackage() {
        testClassIsInPackage();
    }
}
