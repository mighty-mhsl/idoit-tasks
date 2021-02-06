package com.idoit.character.npc;

import com.idoit.meta.character.npc.BijouterieSellerMeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе BijouterieSeller")
class BijouterieSellerTest extends NpcTest {

    @DisplayName("Тест, что класс BijouterieSeller находится в пакете com.idoit.character.npc")
    @Test
    void testBijouterieSellerIsInNpcPackage() {
        testNpcIsInPackage(BijouterieSellerMeta.CLASS_NAME);
    }
}
