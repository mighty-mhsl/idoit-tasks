package com.idoit.character;

import com.idoit.AbstractTest;
import com.idoit.meta.character.WizardMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Wizard")
class WizardTest extends AbstractTest {

    @BeforeEach
    void setUp() {
        setMetaSafe(WizardMeta::new);
    }

    @DisplayName("Тест, что класс Wizard находится в пакете com.idoit.character")
    @Test
    void testWizardIsInCharacterPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Wizard имеет все необходимые поля")
    @Test
    void testWizardHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе Wizard есть конструктор принимающий имя персонажа")
    @Test
    void testWizardHasConstructorWithNameParam() {
        testClassHasConstructors();
        testConstructorSetsValueToFields(new Object[]{"test"});
    }
}
