package com.idoit.character.npc;

import com.idoit.AbstractTest;
import com.idoit.meta.character.npc.BlacksmithMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Blacksmith")
class BlacksmithTest extends AbstractTest {

    @BeforeEach
    void setUp() {
        setMeta(new BlacksmithMeta());
    }

    @DisplayName("Тест, что класс Blacksmith находится в пакете com.idoit.character.npc")
    @Test
    void testBlacksmithIsInNpcPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Blacksmith имеет все необходимые поля")
    @Test
    void testBlacksmithHasAllFields() {
        testClassHasFields();
    }
}
