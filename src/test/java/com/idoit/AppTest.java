package com.idoit;

import com.idoit.meta.Meta;
import com.idoit.meta.character.ArcherMeta;
import com.idoit.meta.character.CharacterMeta;
import com.idoit.meta.character.WizardMeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;
import org.reflections8.Reflections;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("Тест логики в классе App")
class AppTest {

    @DisplayName("Тест, что объект Wizard создается в методе main")
    @Test
    void testWizardIsCreatedInMain() {
        testCharacterIsCreatedInMain(WizardMeta.CLASS_NAME, WizardMeta.PACKAGE_NAME);
    }

    @DisplayName("Тест, что объект Archer создается в методе main")
    @Test
    void testArcherIsCreatedInMain() {
        testCharacterIsCreatedInMain(ArcherMeta.CLASS_NAME, ArcherMeta.PACKAGE_NAME);
    }

    private void testCharacterIsCreatedInMain(String className, String packageName) {
        Reflections reflections = TestUtil.getBaseReflections(packageName);
        Optional<Class<?>> archerClassOptional = getClassFromPackage(reflections, className, packageName);
        if (archerClassOptional.isPresent()) {
            Class<?> archerClass = archerClassOptional.get();
            checkObjectConstruction(archerClass, className);
        } else {
            fail(String.format("Класс %s не найден в пакете %s", className, CharacterMeta.PACKAGE_NAME));
        }
    }

    private void checkObjectConstruction(Class<?> clazz, String className) {
        try (MockedConstruction construction = Mockito.mockConstruction(clazz)) {
            App.main(new String[]{});
            String message = MessageUtil.formatAssertMessage(
                    String.format("Объект класса %s создается в методе main в классе App", className),
                    String.format("Объект класса %s не создается в методе main в классе App", className)
            );
            assertTrue(construction.constructed().size() >= 1, message);
        }
    }

    private Optional<Class<?>> getClassFromPackage(Reflections reflections, String className, String packageName) {
        return reflections.getSubTypesOf(Object.class).stream()
                .filter(clazz -> Meta.getFullClassName(className, packageName).equals(clazz.getName()))
                .findFirst();
    }
}
