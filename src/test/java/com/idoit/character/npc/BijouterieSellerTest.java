package com.idoit.character.npc;

import com.idoit.AbstractTest;
import com.idoit.meta.character.npc.BijouterieSellerMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе BijouterieSeller")
class BijouterieSellerTest extends AbstractTest {

    @BeforeEach
    void setUp() {
        setMeta(new BijouterieSellerMeta());
    }

    @DisplayName("Тест, что класс BijouterieSeller находится в пакете com.idoit.character.npc")
    @Test
    void testBijouterieSellerIsInNpcPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс BijouterieSeller имеет все необходимые поля")
    @Test
    void testBijouterieSellerHasAllFields() {
        testClassHasFields();
    }
}
