package com.idoit.item.special;

import com.idoit.AbstractTest;
import com.idoit.meta.item.special.IgniteHammerMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе IgniteHammer")
class IgniteHammerTest extends AbstractTest {

    @BeforeEach
    void setUp() {
        setMeta(IgniteHammerMeta.class);
    }

    @DisplayName("Тест, что класс IgniteHammer находится в пакете com.idoit.item.special")
    @Test
    void testIgniteHammerIsInSpecialPackage() {
        testClassIsInPackage();
    }
}
