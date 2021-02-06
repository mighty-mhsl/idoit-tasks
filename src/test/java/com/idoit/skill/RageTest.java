package com.idoit.skill;

import com.idoit.AbstractTest;
import com.idoit.MessageUtil;
import com.idoit.meta.MetaContext;
import com.idoit.meta.character.KnightMeta;
import com.idoit.meta.skill.RageMeta;
import com.idoit.safe.Safer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты логики в классе Rage")
class RageTest extends AbstractTest {

    @BeforeEach
	void setUp() {
        setMeta(RageMeta.class);
    }

    @DisplayName("Тест, что класс Rage находится в пакете com.idoit.skill")
    @Test
    void testRageIsInSkillPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Rage имеет все необходимые поля")
    @Test
    void testRageHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе Rage есть конструктор принимающий название, количетсво расходуемой маны и минимальный уровень навыка")
    @Test
    void testRageHasConstructorWithNameAndManaAndMinLevelParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields("test", 20, 5);
    }

    @DisplayName("Тест, что в классе Rage есть все необходимые методы")
    @Test
    void testRageHasAllMethods() {
        testClassHasAllMethods();
    }

    @DisplayName("Тест, что метод apply в классе Rage увеличивает силу цели в 2 раза и уменьшает ей хп на 15")
    @Test
    void testRageDoublesStrengthAndDecreasesHp() {
        Safer.runSafe(() -> {
            Object rage = getMeta().instantiateObjectWithConstructor("test", 5, 5);

            BiConsumer<Object, Object[]> rageAssert = (obj, params) -> {
                Object target = params[0];
                Safer.runSafe(() -> {
                    String profileFieldName = "profile";
                    Object profile = getFieldValue(target, profileFieldName);
                    Object targetHpValue = getFieldValue(profile, "hp");
                    int expectedHp = 85;
                    String message = MessageUtil.formatAssertMessage(
                            String.format("После вызова метода apply, переданная цель должен иметь %d хп", expectedHp),
                            String.format("После вызова метода apply, переданная цель имеет %d хп", targetHpValue)
                    );
                    assertEquals(expectedHp, targetHpValue, message);

                    Object targetStrengthValue = getFieldValue(profile, "strength");
                    int expectedStrength = 14;
                    message = MessageUtil.formatAssertMessage(
                            String.format("После вызова метода apply, переданная цель должен иметь %d силы", expectedStrength),
                            String.format("После вызова метода apply, переданная цель имеет %d силы", targetStrengthValue)
                    );
                    assertEquals(expectedHp, targetHpValue, message);
                });
            };

            Object target = MetaContext.getMeta(KnightMeta.class).instantiateObjectWithConstructor("Eugene");
            testClassMethod(rageAssert, rage, "apply", target);
        });
    }
}
