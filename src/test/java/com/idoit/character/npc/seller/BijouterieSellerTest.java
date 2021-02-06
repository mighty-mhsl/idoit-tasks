package com.idoit.character.npc.seller;

import com.idoit.AbstractTest;
import com.idoit.meta.character.npc.seller.BijouterieSellerMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе BijouterieSeller")
class BijouterieSellerTest extends AbstractTest {

    @BeforeEach
	void setUp() {
        setMeta(BijouterieSellerMeta.class);
    }

    @DisplayName("Тест, что класс BijouterieSeller находится в пакете com.idoit.character.npc.seller")
    @Test
    void testBijouterieSellerIsInNpcPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс BijouterieSeller имеет все необходимые поля")
    @Test
    void testBijouterieSellerHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе BijouterieSeller есть конструктор принимающий название и уровень нпс")
    @Test
    void testBijouterieSellerHasConstructorWithNameAndBothDefenceParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields("test", 3);
    }
}
