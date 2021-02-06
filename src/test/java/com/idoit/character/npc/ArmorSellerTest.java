package com.idoit.character.npc;

import com.idoit.meta.character.npc.ArmorSellerMeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе ArmorSeller")
class ArmorSellerTest extends NpcTest {

    @DisplayName("Тест, что класс ArmorSeller находится в пакете com.idoit.character.npc")
    @Test
    void testArmorSellerIsInNpcPackage() {
        testNpcIsInPackage(ArmorSellerMeta.CLASS_NAME);
    }
}
