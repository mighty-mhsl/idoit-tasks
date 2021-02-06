package com.idoit.character.npc;

import com.idoit.meta.character.npc.HunterMeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Hunter")
class HunterTest extends NpcTest {

    @DisplayName("Тест, что класс Hunter находится в пакете com.idoit.character.npc")
    @Test
    void testHunterIsInNpcPackage() {
        testNpcIsInPackage(HunterMeta.CLASS_NAME);
    }
}
