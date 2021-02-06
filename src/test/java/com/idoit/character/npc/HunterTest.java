package com.idoit.character.npc;

import com.idoit.AbstractTest;
import com.idoit.meta.character.npc.HunterMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Hunter")
class HunterTest extends AbstractTest {

    @BeforeEach
    void setUp() {
        setMeta(new HunterMeta());
    }

    @DisplayName("Тест, что класс Hunter находится в пакете com.idoit.character.npc")
    @Test
    void testHunterIsInNpcPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Hunter имеет все необходимые поля")
    @Test
    void testHunterHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе Hunter есть конструктор принимающий название и уровень нпс")
    @Test
    void testHunterHasConstructorWithNameAndBothDefenceParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields(new Object[]{"test", 3});
    }
}
