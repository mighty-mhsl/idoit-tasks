package com.idoit.character.npc;

import com.idoit.meta.character.npc.BlacksmithMeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Blacksmith")
class BlacksmithTest extends NpcTest {

    @DisplayName("Тест, что класс Blacksmith находится в пакете com.idoit.character.npc")
    @Test
    void testBlacksmithIsInNpcPackage() {
        testNpcIsInPackage(BlacksmithMeta.CLASS_NAME);
    }
}
