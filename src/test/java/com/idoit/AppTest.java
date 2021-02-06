package com.idoit;

import com.idoit.meta.Meta;
import com.idoit.meta.character.ArcherMeta;
import com.idoit.meta.character.WizardMeta;
import com.idoit.meta.item.weapon.BowMeta;
import com.idoit.meta.item.weapon.StaffMeta;
import com.idoit.meta.item.weapon.SwordMeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;
import org.reflections8.Reflections;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("Тест логики в классе App")
class AppTest {

    @DisplayName("Тест, что объект Wizard создается в методе main")
    @Test
    void testWizardIsCreatedInMain() {
        testObjectIsCreatedInMain(Objects.requireNonNull(TestUtil.supplyMetaSafe(WizardMeta::new)));
    }

    @DisplayName("Тест, что объект Archer создается в методе main")
    @Test
    void testArcherIsCreatedInMain() {
        testObjectIsCreatedInMain(Objects.requireNonNull(TestUtil.supplyMetaSafe(ArcherMeta::new)));
    }

    @DisplayName("Тест, что объект Sword создается в методе main")
    @Test
    void testSwordIsCreatedInMain() {
        testObjectIsCreatedInMain(new SwordMeta());
    }

    @DisplayName("Тест, что объект Staff создается в методе main")
    @Test
    void testStaffIsCreatedInMain() {
        testObjectIsCreatedInMain(new StaffMeta());
    }

    @DisplayName("Тест, что объект Bow создается в методе main")
    @Test
    void testBowIsCreatedInMain() {
        testObjectIsCreatedInMain(new BowMeta());
    }

    @DisplayName("В методе main должно выводиться на экран: 100 100 7 7 0 0 0")
    @Test
    void testMainPrints() throws IOException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));

        App.main(new String[]{});
        bo.flush();
        String actualLines = bo.toString().trim();

        String expectedLines = MessageUtil.getExpectedPrint("100", "100", "7", "7", "0", "0", "0");
        String message = MessageUtil.formatAssertMessagePrint(expectedLines, actualLines);
        assertEquals(expectedLines, actualLines, message);
    }

    private void testObjectIsCreatedInMain(Meta meta) {
        Reflections reflections = TestUtil.getBaseReflections(meta.getPackageName());
        Optional<Class<?>> objectClassOptional = getClassFromPackage(reflections, meta);
        if (objectClassOptional.isPresent()) {
            Class<?> archerClass = objectClassOptional.get();
            checkObjectConstruction(archerClass, meta.getClassName());
        } else {
            fail(String.format("Класс %s не найден в пакете %s", meta.getClassName(), meta.getPackageName()));
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

    private Optional<Class<?>> getClassFromPackage(Reflections reflections, Meta meta) {
        return reflections.getSubTypesOf(Object.class).stream()
                .filter(clazz -> meta.getFullClassName().equals(clazz.getName()))
                .findFirst();
    }
}
