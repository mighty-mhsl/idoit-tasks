package com.idoit;

import com.idoit.meta.Meta;
import com.idoit.meta.MetaContext;
import com.idoit.meta.character.ArcherMeta;
import com.idoit.meta.character.KnightMeta;
import com.idoit.meta.character.WizardMeta;
import com.idoit.meta.character.npc.seller.BlacksmithMeta;
import com.idoit.meta.item.armor.HelmetMeta;
import com.idoit.meta.item.bijouterie.ring.StrengthRingMeta;
import com.idoit.meta.item.common.potion.HpPotionMeta;
import com.idoit.meta.item.weapon.BowMeta;
import com.idoit.meta.item.weapon.StaffMeta;
import com.idoit.meta.item.weapon.SwordMeta;
import com.idoit.safe.Safer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.reflections8.Reflections;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("Тест логики в классе App")
class AppTest {

    @DisplayName("Тест, что объект Wizard создается в методе main")
    @Test
    void testWizardIsCreatedInMain() {
        testObjectIsCreatedInMain(MetaContext.getMeta(WizardMeta.class));
    }

    @DisplayName("Тест, что объект Archer создается в методе main")
    @Test
    void testArcherIsCreatedInMain() {
        testObjectIsCreatedInMain(MetaContext.getMeta(ArcherMeta.class));
    }

    @DisplayName("Тест, что объект Sword создается в методе main")
    @Test
    void testSwordIsCreatedInMain() {
        testObjectIsCreatedInMain(MetaContext.getMeta(SwordMeta.class));
    }

    @DisplayName("Тест, что объект Staff создается в методе main")
    @Test
    void testStaffIsCreatedInMain() {
        testObjectIsCreatedInMain(MetaContext.getMeta(StaffMeta.class));
    }

    @DisplayName("Тест, что объект Bow создается в методе main")
    @Test
    void testBowIsCreatedInMain() {
        testObjectIsCreatedInMain(MetaContext.getMeta(BowMeta.class));
    }

    @DisplayName("Тест, что объект Blacksmith создается в методе main")
    @Test
    void testBlacksmithIsCreatedInMain() {
        testObjectIsCreatedInMain(MetaContext.getMeta(BlacksmithMeta.class));
    }

    @DisplayName("Тест, что объект Helmet создается в методе main")
    @Test
    void testHelmetIsCreatedInMain() {
        testObjectIsCreatedInMain(MetaContext.getMeta(HelmetMeta.class));
    }

    @DisplayName("Тест, что объект HpPotion создается в методе main")
    @Test
    void testHpPotionIsCreatedInMain() {
        testObjectIsCreatedInMain(MetaContext.getMeta(HpPotionMeta.class));
    }

    @DisplayName("Тест, что объект StrengthRing создается в методе main")
    @Test
    void testStrengthRingIsCreatedInMain() {
        testObjectIsCreatedInMain(MetaContext.getMeta(StrengthRingMeta.class));
    }

    @DisplayName("Тест, что рыцари получают мечи")
    @Test
    void testKnightsGotSwords() {
        testSetter(2, KnightMeta.class, SwordMeta.class, "setSword");
    }

    @DisplayName("Тест, что маг получает посох")
    @Test
    void testWizardGotStaff() {
        testSetter(1, WizardMeta.class, StaffMeta.class, "setStaff");
    }

    @DisplayName("Тест, что лучник получает лук")
    @Test
    void testArcherGotBow() {
       testSetter(1, ArcherMeta.class, BowMeta.class, "setBow");
    }

    private void testSetter(int expectedCalls, Class<? extends Meta> caller, Class<? extends Meta> param, String methodName) {
        Safer.runClassSafe(() -> {
            Meta meta = MetaContext.getMeta(caller);
            Class<?> paramType = Meta.getClassFromMeta(MetaContext.getMeta(param));
            testMethodCalls(expectedCalls, meta, methodName, paramType);
        });
    }

    private void testMethodCalls(int expectedCalls, Meta meta, String methodName, Class<?>... paramTypes) {
        Safer.runSafe(() -> {
            Class<?> clazz = Meta.getClassFromMeta(meta);
            Method weaponSetter = meta.getMethodFromMeta(methodName, paramTypes);
            List<Method> calls = new ArrayList<>();
            Answer<Object> answer = (invocation) -> {
                if (invocation.getMethod().equals(weaponSetter)) {
                    calls.add(invocation.getMethod());
                }
                return null;
            };
            try (MockedConstruction construction = Mockito.mockConstructionWithAnswer(clazz, answer)) {
                App.main(new String[]{});
                String message = MessageUtil.formatAssertMessage(
                        String.format("В классе %s метод %s вызывается %d раз", clazz.getName(), methodName, expectedCalls),
                        String.format("В классе %s метод %s вызывается %d раз", clazz.getName(), methodName, calls.size())
                );
                assertEquals(expectedCalls, calls.size(), message);
            }
        });
    }

    /*@DisplayName("В методе main должно выводиться на экран: 100 100 7 7 0 0 0")
    @Test
    void testMainPrints() throws IOException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));

        App.main(new String[]{});
        bo.flush();
        String actualLines = new String(bo.toByteArray()).trim();

        String expectedLines = MessageUtil.getExpectedPrint("100", "100", "7", "7", "0", "0", "0");
        String message = MessageUtil.formatAssertMessagePrint(expectedLines, actualLines);
        assertEquals(expectedLines, actualLines, message);
    }*/

    private void testObjectIsCreatedInMain(Meta meta) {
        Reflections reflections = TestUtil.getBaseReflections(meta.getPackageName());
        Optional<Class<?>> objectClassOptional = getClassFromPackage(reflections, meta);
        if (objectClassOptional.isPresent()) {
            Class<?> clazz = objectClassOptional.get();
            checkObjectConstruction(clazz, meta.getClassName());
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
