package com.idoit.character;

import com.idoit.meta.character.ArcherMeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Archer")
class ArcherTest extends CharacterTest {

    @DisplayName("Тест, что класс Archer находится в пакете com.idoit.character")
    @Test
    void testArcherIsInCharacterPackage() {
        testCharacterInPackage(ArcherMeta.CLASS_NAME);
    }
}
