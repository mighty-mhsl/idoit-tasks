package com.idoit.character;

import com.idoit.AbstractTest;
import com.idoit.MessageUtil;
import com.idoit.meta.Meta;
import com.idoit.meta.MetaContext;
import com.idoit.meta.character.KnightMeta;
import com.idoit.safe.Safer;

import java.lang.reflect.Method;
import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class CharacterTest extends AbstractTest {

    private static final String CONSTRUCTOR_PARAM = "Max";

    void testHitDamagesEnemy(Meta weaponMeta, String weaponSetterName) {
        Safer.runSafe(() -> {
            Object hitter = getMeta().instantiateObjectWithConstructor(CONSTRUCTOR_PARAM);
            BiConsumer<Object, Object[]> hitAssert = (obj, params) -> {
                Object enemy = params[0];
                Safer.runSafe(() -> {
                    Object enemyHpValue = getFieldValue(enemy, "hp");
                    int expectedHp = 90;
                    String message = MessageUtil.formatAssertMessage(
                            String.format("После вызова метода hit переданная цель должна иметь %d хп", expectedHp),
                            String.format("После вызова метода hit переданная цель имеет %d хп", enemyHpValue)
                    );
                    assertEquals(expectedHp, enemyHpValue, message);
                });
            };
            testHit(hitter, weaponMeta, weaponSetterName, hitAssert);
        });
    }

    void testHitDamagesWeapon(Meta weaponMeta, String weaponSetterName, String weaponFieldName) {
        Safer.runSafe(() -> {
            Object hitter = getMeta().instantiateObjectWithConstructor(CONSTRUCTOR_PARAM);
            BiConsumer<Object, Object[]> hitAssert = (obj, params) -> {
                Safer.runSafe(() -> {
                    Object sword = getFieldValue(hitter, weaponFieldName);
                    Object durability = getFieldValue(sword, "durability");
                    int expectedDurability = 99;
                    String message = MessageUtil.formatAssertMessage(
                            String.format("После вызова метода hit оружние бьющего должно иметь %d прочности", expectedDurability),
                            String.format("После вызова метода hit оружние бьющего имеет %d прочности", durability)
                    );
                    assertEquals(expectedDurability, durability, message);
                });
            };
            testHit(hitter, weaponMeta, weaponSetterName, hitAssert);
        });

    }

    private void testHit(Object hitter, Meta weaponMeta, String weaponSetterName, BiConsumer<Object, Object[]> assertConsumer) throws Exception {
        Method weaponSetter = getMeta().getMethodFromMeta(weaponSetterName, weaponMeta.getClassFromMeta()); //because sword's durability is decreased in hit
        weaponSetter.invoke(hitter, weaponMeta.instantiateObjectWithConstructor("test", 5));
        Object enemy = MetaContext.getMeta(KnightMeta.class).instantiateObjectWithConstructor("Eugene");
        testClassMethod(assertConsumer, hitter, "hit", enemy);
    }

    void testGo() {
        Safer.runSafe(() -> {
            Object whoGoes = getMeta().instantiateObjectWithConstructor(CONSTRUCTOR_PARAM);

            BiConsumer<Object, Object[]> goAssert = (obj, params) -> {
                Object x = params[0];
                Object y = params[1];
                Safer.runSafe(() -> {
                    Object point = getFieldValue(whoGoes, "point");
                    Object actualX = getFieldValue(point, "x");
                    Object actualY = getFieldValue(point, "y");
                    assertEquals(x, actualX, getGoAssertMessage("x", x, actualX));
                    assertEquals(x, actualX, getGoAssertMessage("y", y, actualY));
                });
            };

            testClassMethod(goAssert, whoGoes, "go", 1, 2);
        });
    }

    private String getGoAssertMessage(String fieldName, Object expectedValue, Object actualValue) {
        return MessageUtil.formatAssertMessage(
                String.format("После вызова метода go персонаж должен иметь координату по %s: %d", fieldName, expectedValue),
                String.format("После вызова метода go персонаж имеет координату по %s: %d", fieldName, actualValue)
        );
    }

    void testSetWeapon(Meta weaponMeta, String methodName, String fieldName, String assertMessage) {
        Safer.runSafe(() -> {
            Object weapon = weaponMeta.instantiateObjectWithConstructor("test", 5);
            testSetter(weapon, methodName, fieldName, assertMessage, CONSTRUCTOR_PARAM);
        });
    }

    void testSetArmor(Meta armorMeta, String methodName, String fieldName, String assertMessage) {
        Safer.runSafe(() -> {
            Object armor = armorMeta.instantiateObjectWithConstructor("test", 5, 5);
            testSetter(armor, methodName, fieldName, assertMessage, CONSTRUCTOR_PARAM);
        });
    }

    void testSetBijouterie(Meta bijMeta, String methodName, String fieldName, String assertMessage) {
        Safer.runSafe(() -> {
            Object bijouterie = bijMeta.instantiateObjectWithConstructor("test", 5);
            testSetter(bijouterie, methodName, fieldName, assertMessage, CONSTRUCTOR_PARAM);
        });
    }
}
