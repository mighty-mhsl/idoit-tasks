package com.idoit.character;

import com.idoit.MessageUtil;
import com.idoit.meta.Meta;
import com.idoit.meta.MetaContext;
import com.idoit.meta.character.KnightMeta;
import com.idoit.meta.item.bijouterie.BijouterieMeta;
import com.idoit.safe.Safer;

import java.lang.reflect.Method;
import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

abstract class CharacterTest extends AbstractCharacterTest {

    static final String CONSTRUCTOR_PARAM = "Max";

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

    void testHitDecreasesStamina(Meta weaponMeta, String weaponSetterName) {
        Safer.runSafe(() -> {
            Object hitter = getMeta().instantiateObjectWithConstructor(CONSTRUCTOR_PARAM);
            BiConsumer<Object, Object[]> hitAssert = (obj, params) -> Safer.runSafe(() -> {
                Object actualStamina = getFieldValue(obj, "stamina");
                int expectedStamina = 90;
                String message = MessageUtil.formatAssertMessage(
                        String.format("После вызова метода hit персонаж должен иметь %d выносливости", expectedStamina),
                        String.format("После вызова метода hit персонаж имеет %d выносливости", actualStamina)
                );
                assertEquals(expectedStamina, actualStamina, message);
            });
            testHit(hitter, weaponMeta, weaponSetterName, hitAssert);
        });
    }

    void testBijouterieAddsPoints(String methodName, String fieldName, Class<? extends BijouterieMeta> bijouterieMeta) {
        Safer.runSafe(() -> {
            Object character = getMeta().instantiateObjectWithConstructor(CONSTRUCTOR_PARAM);
            int pointsToAdd = 1;

            BiConsumer<Object, Object[]> addPointsAssert = (obj, params) -> Safer.runSafe(() -> {
                int expectedValue = 7 + pointsToAdd;
                Object actualValue = getFieldValue(obj, fieldName);
                String message = getFieldValueAssert(getMeta().getClassName(), methodName, fieldName, expectedValue, actualValue);
                assertEquals(expectedValue, actualValue, message);
            });

            Meta ringMeta = MetaContext.getMeta(bijouterieMeta);
            Object ring = ringMeta.instantiateObjectWithConstructor("test", pointsToAdd);
            testClassMethod(addPointsAssert, character, methodName, ring);
        });
    }

    void testTakeOffRemovesBijouterie(String methodName, String setterName, String fieldName,
                                      Class<? extends BijouterieMeta> metaClass) {
        Safer.runSafe(() -> {
            Object knight = getMeta().instantiateObjectWithConstructor(CONSTRUCTOR_PARAM);
            setFieldForObjectAndGet(knight, setterName, metaClass, "test", 1);

            BiConsumer<Object, Object[]> takeOffAssert = (obj, params) -> Safer.runSafe(() -> {
                Object actualValue = getFieldValue(obj, fieldName);
                String message = getFieldValueAssert(getMeta().getClassName(), methodName, fieldName, null, actualValue);
                assertNull(actualValue, message);
            });

            testClassMethod(takeOffAssert, knight, methodName);
        });
    }

    void testTakeOffDecreasesCharacteristic(String methodName, String setterName, String fieldName,
                                            Class<? extends BijouterieMeta> metaClass) {
        Safer.runSafe(() -> {
            Object knight = getMeta().instantiateObjectWithConstructor(CONSTRUCTOR_PARAM);
            int pointsToAdd = 1;
            setFieldForObjectAndGet(knight, setterName, metaClass, "test", pointsToAdd);

            BiConsumer<Object, Object[]> takeOffAssert = (obj, params) -> Safer.runSafe(() -> {
                int expectedValue = 7 - pointsToAdd;
                Object actualValue = getFieldValue(obj, fieldName);
                String message = getFieldValueAssert(getMeta().getClassName(), methodName, fieldName, expectedValue, actualValue);
                assertEquals(expectedValue, actualValue, message);
            });

            testClassMethod(takeOffAssert, knight, methodName);
        });
    }

    private void testHit(Object hitter, Meta weaponMeta, String weaponSetterName, BiConsumer<Object, Object[]> assertConsumer) throws Exception {
        Method weaponSetter = getMeta().getMethodFromMeta(weaponSetterName, weaponMeta.getClassFromMeta()); //because sword's durability is decreased in hit
        weaponSetter.invoke(hitter, weaponMeta.instantiateObjectWithConstructor("test", 5));
        Object enemy = MetaContext.getMeta(KnightMeta.class).instantiateObjectWithConstructor("Eugene");
        testClassMethod(assertConsumer, hitter, "hit", enemy);
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
