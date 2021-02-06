package com.idoit.skill;

import com.idoit.AbstractTest;
import com.idoit.MessageUtil;
import com.idoit.meta.Meta;
import com.idoit.meta.MetaContext;
import com.idoit.meta.character.ArcherMeta;
import com.idoit.meta.character.KnightMeta;
import com.idoit.meta.item.weapon.BowMeta;
import com.idoit.meta.skill.AccurateShotMeta;
import com.idoit.safe.Safer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты логики в классе AccurateShot")
class AccurateShotTest extends AbstractTest {

    @BeforeEach
	void setUp() {
        setMeta(AccurateShotMeta.class);
    }

    @DisplayName("Тест, что класс AccurateShot находится в пакете com.idoit.skill")
    @Test
    void testAccurateShotIsInSkillPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс AccurateShot имеет все необходимые поля")
    @Test
    void testAccurateShotHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе AccurateShot есть конструктор принимающий название, количетсво расходуемой маны и минимальный уровень навыка")
    @Test
    void testAccurateShotHasConstructorWithNameAndManaAndMinLevelParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields("test", 20, 5);
    }

    @DisplayName("Тест, что в классе AccurateShot есть все необходимые методы")
    @Test
    void testAccurateShotHasAllMethods() {
        testClassHasAllMethods();
    }

    @DisplayName("Тест, что метод apply в классе AccurateShot отнимает хп цели в двойном размере")
    @Test
    void testApplyDamagesTargetTwiceMore() {
        Safer.runSafe(() -> {
            Object shot = getMeta().instantiateObjectWithConstructor("test", 5, 5);

            BiConsumer<Object, Object[]> healAssert = (obj, params) -> {
                Object shooter = params[1];
                Safer.runSafe(() -> {
                    Object targetHpValue = getFieldValue(shooter, "hp");
                    int expectedHp = 90;
                    String message = MessageUtil.formatAssertMessage(
                            String.format("После вызова метода apply, переданная цель должен иметь %d хп", expectedHp),
                            String.format("После вызова метода apply, переданная цель имеет %d хп", targetHpValue)
                    );
                    assertEquals(expectedHp, targetHpValue, message);
                });
            };

            Meta meta = MetaContext.getMeta(ArcherMeta.class);
            Meta weaponMeta = MetaContext.getMeta(BowMeta.class);
            Object shooter = meta.instantiateObjectWithConstructor("Max");
            Method weaponSetter = meta.getMethodFromMeta("setBow", weaponMeta.getClassFromMeta());
            weaponSetter.invoke(shooter, weaponMeta.instantiateObjectWithConstructor("test", 5));
            Object target = MetaContext.getMeta(KnightMeta.class).instantiateObjectWithConstructor("Eugene");

            testClassMethod(healAssert, shot, "apply", shooter, target);
        });
    }
}
