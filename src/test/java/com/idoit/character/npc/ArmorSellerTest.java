package com.idoit.character.npc;

import com.idoit.AbstractTest;
import com.idoit.meta.character.npc.ArmorSellerMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе ArmorSeller")
class ArmorSellerTest extends AbstractTest {

    @BeforeEach
    void setUp() {
        setMeta(new ArmorSellerMeta());
    }

    @DisplayName("Тест, что класс ArmorSeller находится в пакете com.idoit.character.npc")
    @Test
    void testArmorSellerIsInNpcPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс ArmorSeller имеет все необходимые поля")
    @Test
    void testArmorSellerHasAllFields() {
        testClassHasFields();
    }
}
