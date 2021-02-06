package com.idoit.skill;

import com.idoit.AbstractTest;
import com.idoit.MessageUtil;
import com.idoit.meta.Meta;
import com.idoit.meta.character.KnightMeta;
import com.idoit.meta.character.WizardMeta;
import com.idoit.meta.skill.HealMeta;
import com.idoit.safe.Safer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты логики в классе Heal")
class HealTest extends AbstractTest {

    @BeforeEach
	void setUp() {
        setMeta(HealMeta.class);
    }

    @DisplayName("Тест, что класс Heal находится в пакете com.idoit.skill")
    @Test
    void testHealIsInSkillPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Heal имеет все необходимые поля")
    @Test
    void testHealHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе Heal есть конструктор принимающий название, количетсво расходуемой маны и минимальный уровень навыка")
    @Test
    void testHealHasConstructorWithNameAndManaAndMinLevelParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields("test", 20, 5);
    }

    @DisplayName("Тест, что в классе Heal есть все необходимые методы")
    @Test
    void testHealHasAllMethods() {
        testClassHasAllMethods();
    }

    @DisplayName("Тест, что метод apply в классе Heal увеличивает хп цели на 10")
    @Test
    void testApplyIncreasesPatientsHp() {
        Safer.runSafe(() -> {
            Object heal = getMeta().instantiateObjectWithConstructor("test", 5, 5);

            BiConsumer<Object, Object[]> healAssert = (obj, params) -> {
                Object patient = params[1];
                Safer.runSafe(() -> {
                    Object profile = getFieldValue(patient, "profile");
                    Object patientHpValue = getFieldValue(profile, "hp");
                    int expectedHp = 110;
                    String message = MessageUtil.formatAssertMessage(
                            String.format("После вызова метода apply, переданная цель должна иметь %d хп", expectedHp),
                            String.format("После вызова метода apply, переданная цель имеет %d хп", patientHpValue)
                    );
                    assertEquals(expectedHp, patientHpValue, message);
                });
            };

            Object wizard = Meta.instantiateObjectFromMeta(WizardMeta.class, "test");
            Object patient = Meta.instantiateObjectFromMeta(KnightMeta.class, "test");
            testClassMethod(healAssert, heal, "apply", wizard, patient);
        });
    }

    @DisplayName("Тест, что метод apply в классе Heal уменьшает ману мага")
    @Test
    void testApplyDecreasesMana() {
        Safer.runSafe(() -> {
            Object heal = getMeta().instantiateObjectWithConstructor("test", 5, 5);

            BiConsumer<Object, Object[]> healAssert = (obj, params) -> {
                Object wizard = params[0];
                Safer.runSafe(() -> {
                    Object profile = getFieldValue(wizard, "profile");
                    Object actualMana = getFieldValue(profile, "mana");
                    int expectedMana = 95;
                    String message = MessageUtil.formatAssertMessage(
                            String.format("После вызова метода apply, маг должен иметь %d маны", expectedMana),
                            String.format("После вызова метода apply, маг имеет %d маны", actualMana)
                    );
                    assertEquals(expectedMana, actualMana, message);
                });
            };

            Object wizard = Meta.instantiateObjectFromMeta(WizardMeta.class, "test");
            Object patient = Meta.instantiateObjectFromMeta(KnightMeta.class, "test");
            testClassMethod(healAssert, heal, "apply", wizard, patient);
        });
    }
}
