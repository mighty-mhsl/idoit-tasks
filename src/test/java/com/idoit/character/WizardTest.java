package com.idoit.character;

import com.idoit.meta.character.WizardMeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Wizard")
class WizardTest extends CharacterTest {

    @DisplayName("Тест, что класс Wizard находится в пакете com.idoit.character")
    @Test
    void testWizardIsInCharacterPackage() {
        testCharacterInPackage(WizardMeta.CLASS_NAME);
    }
}
