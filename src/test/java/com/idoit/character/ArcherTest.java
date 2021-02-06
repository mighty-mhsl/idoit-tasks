package com.idoit.character;

import com.idoit.AbstractTest;
import com.idoit.meta.character.ArcherMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Archer")
class ArcherTest extends AbstractTest {

    @BeforeEach
    void setUp() {
        setMetaSafe(ArcherMeta::new);
    }

    @DisplayName("Тест, что класс Archer находится в пакете com.idoit.character")
    @Test
    void testArcherIsInCharacterPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Archer имеет все необходимые поля")
    @Test
    void testArcherHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе Archer есть конструктор принимающий имя персонажа")
    @Test
    void testArcherHasConstructorWithNameParam() {
        testClassHasConstructors();
        testConstructorSetsValueToFields(new Object[]{"test"});
    }
}
