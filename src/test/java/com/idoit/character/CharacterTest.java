package com.idoit.character;

import com.idoit.MessageUtil;
import com.idoit.meta.Meta;
import com.idoit.meta.MetaContext;
import com.idoit.meta.character.KnightMeta;
import com.idoit.meta.item.bijouterie.BijouterieMeta;
import com.idoit.meta.item.common.food.AppleMeta;
import com.idoit.safe.Safer;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

abstract class CharacterTest extends AbstractCharacterTest {

    static final String CONSTRUCTOR_PARAM = "Max";

    void testConstructorSetsValuesToProfile() {
        Safer.runSafe(() -> {
            Object character = getMeta().instantiateObjectWithConstructor(CONSTRUCTOR_PARAM);
            Object profile = getProfile(character);
            String nameFieldName = "name";
            Object actualName = getFieldValue(profile, nameFieldName);
            String message = getConstructorAssertMessage(profile, nameFieldName);
            assertEquals(CONSTRUCTOR_PARAM, actualName, message);
        });
    }

    void testHitDamagesEnemy(Meta weaponMeta, String weaponSetterName) {
        Safer.runSafe(() -> {
            Object hitter = getMeta().instantiateObjectWithConstructor(CONSTRUCTOR_PARAM);
            BiConsumer<Object, Object[]> hitAssert = (obj, params) -> {
                Object enemy = params[0];
                Safer.runSafe(() -> {
                    Object profile = getProfile(enemy);
                    Object enemyHpValue = getFieldValue(profile, "hp");
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
                Object profile = getProfile(obj);
                Object actualStamina = getFieldValue(profile, "stamina");
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
                Object profile = getProfile(obj);
                Object actualValue = getFieldValue(profile, fieldName);
                String message = getFieldValueAssert(getMeta().getClassName(), methodName, fieldName, pointsToAdd, actualValue);
                assertEquals(pointsToAdd, actualValue, message);
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
                Object profile = getProfile(obj);
                int expectedValue = 0;
                Object actualValue = getFieldValue(profile, fieldName);
                String message = getFieldValueAssert(getMeta().getClassName(), methodName, fieldName, expectedValue, actualValue);
                assertEquals(expectedValue, actualValue, message);
            });

            testClassMethod(takeOffAssert, knight, methodName);
        });
    }

    Object getProfile(Object obj) throws NoSuchFieldException, IllegalAccessException {
        String profileFieldName = "profile";
        return getFieldValue(obj, profileFieldName);
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

    void testSetArmor(Meta armorMeta, String methodName, String fieldName) {
        Safer.runSafe(() -> {
            Object character = getMeta().instantiateObjectWithConstructor(CONSTRUCTOR_PARAM);
            Object armor = armorMeta.instantiateObjectWithConstructor("test", 5, 5);

            BiConsumer<Object, Object[]> setArmorAssert = (obj, params) -> Safer.runSafe(() -> {
                String profileFieldName = "profile";
                Object profile = getFieldValue(character, profileFieldName);
                String inventoryFieldName = "inventory";
                Object inventory = getFieldValue(profile, inventoryFieldName);
                Object actualArmor = getFieldValue(inventory, fieldName);
                String message = getInventorySetterAssertMessage(methodName, fieldName, armor, actualArmor);
                assertEquals(armor, actualArmor, message);
            });

            testClassMethod(setArmorAssert, character, methodName, armor);
        });
    }

    void testSetBijouterie(Meta bijMeta, String methodName, String fieldName, String assertMessage) {
        Safer.runSafe(() -> {
            Object bijouterie = bijMeta.instantiateObjectWithConstructor("test", 5);
            testSetter(bijouterie, methodName, fieldName, assertMessage, CONSTRUCTOR_PARAM);
        });
    }

    void testEat() {
        Safer.runSafe(() -> {
            String methodName = "eat";
            Object character = getMeta().instantiateObjectWithConstructor(CONSTRUCTOR_PARAM);
            Object apple = MetaContext.getMeta(AppleMeta.class).instantiateObjectWithConstructor();
            int points = 5;
            Field pointsField = apple.getClass().getField("pointsToRecover");
            pointsField.set(apple, points);

            BiConsumer<Object, Object[]> eatAssert = (obj, params) -> Safer.runSafe(() -> {
                String profileFieldName = "profile";
                Object profile = getFieldValue(character, profileFieldName);
                String hpFieldName = "hp";
                Object actualHp = getFieldValue(profile, hpFieldName);
                int expectedHp = 100 + points;
                String message = getFieldValueAssert(getMeta().getClassName(), methodName, hpFieldName, expectedHp, actualHp);
                assertEquals(expectedHp, actualHp, message);
            });

            testClassMethod(eatAssert, character, methodName, apple);
        });
    }

    private String getInventorySetterAssertMessage(String methodName, String fieldName, Object expectedValue, Object actualValue) {
        return MessageUtil.formatAssertMessage(
                String.format("После вызова метода %s в классе %s, в поле %s его инвентаря должно храниться %s",
                        methodName, getMeta().getClassName(), fieldName, expectedValue),
                String.format("После вызова метода %s в классе %s, в поле %s его инвентаря хранится %s",
                        methodName, getMeta().getClassName(), fieldName, actualValue)
        );
    }

    private String getConstructorAssertMessage(Object profile, String nameFieldName) {
        return MessageUtil.formatAssertMessage(
                String.format("В классе %s полю %s в конструкторе должно выставляться значение параметра",
                        profile.getClass().getName(), nameFieldName),
                String.format("В классе %s полю %s в конструкторе не выставляется значение параметра",
                        profile.getClass().getName(), nameFieldName)
        );
    }
}
