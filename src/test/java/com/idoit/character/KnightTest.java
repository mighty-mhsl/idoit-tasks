package com.idoit.character;

import com.idoit.AbstractTest;
import com.idoit.meta.character.KnightMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Knight")
class KnightTest extends AbstractTest {

    @BeforeEach
    void setUp() {
        setMetaSafe(KnightMeta::new);
    }

    @DisplayName("Тест, что класс Knight находится в пакете com.idoit.character")
    @Test
    void testKnightIsInCharacterPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Knight имеет все необходимые поля")
    @Test
    void testKnightHasAllFields() {
        testClassHasFields();
    }
}
