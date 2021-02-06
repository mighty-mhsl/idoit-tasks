package com.idoit.character.npc.seller;

import com.idoit.AbstractTest;
import com.idoit.MessageUtil;
import com.idoit.meta.Meta;
import com.idoit.meta.MetaContext;
import com.idoit.meta.character.CharacterMeta;
import com.idoit.meta.item.special.SpecialMeta;
import com.idoit.meta.item.weapon.WeaponMeta;
import com.idoit.safe.SafeFunction;
import com.idoit.safe.Safer;

import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class SellerTest extends AbstractTest {

    void testFix(Class<? extends Meta> itemType, SafeFunction<Meta, Object> itemSupplier) {
        Safer.runSafe(() -> {
            Object npc = getMeta().instantiateObjectWithConstructor("test", 1);

            BiConsumer<Object, Object[]> fixAssert = (obj, params) -> {
                Object item = params[0];
                Safer.runSafe(() -> {
                    Object durability = getFieldValue(item, "durability");
                    int expectedDurability = 100;
                    String message = getFixAssertMessage(item.getClass().getName(), expectedDurability, durability);
                    assertEquals(expectedDurability, durability, message);
                });
            };

            Meta itemMeta = MetaContext.getMeta(itemType);
            Object item = itemSupplier.apply(itemMeta);
            testClassMethod(fixAssert, npc, "fix", item);
        });
    }

    void testWeaponFix(Class<? extends CharacterMeta> ownerType, Class<? extends WeaponMeta> weaponType,
                       SafeFunction<Meta, Object> itemSupplier) {
        BiConsumer<Object, Object[]> fixAssert = (obj, params) -> {
            Object item = params[1];
            Safer.runSafe(() -> {
                Object durability = getFieldValue(item, "durability");
                int expectedDurability = 100;
                String message = getFixAssertMessage(item.getClass().getName(), expectedDurability, durability);
                assertEquals(expectedDurability, durability, message);
            });
        };
        testWeaponFix(ownerType, weaponType, itemSupplier, fixAssert);
    }

    void testFixDecreasesGold(Class<? extends CharacterMeta> ownerType, Class<? extends WeaponMeta> weaponType,
                              SafeFunction<Meta, Object> itemSupplier) {
        String methodName = "fix";
        BiConsumer<Object, Object[]> fixAssert = (obj, params) -> {
            Object character = params[0];
            Safer.runSafe(() -> {
                String fieldName = "gold";
                Object durability = getFieldValue(character, fieldName);
                int expectedDurability = 80;
                String message = getFieldValueAssert(character.getClass().getName(), methodName, fieldName, expectedDurability, durability);
                assertEquals(expectedDurability, durability, message);
            });
        };
        testWeaponFix(ownerType, weaponType, itemSupplier, fixAssert);
    }

    void testAccept(Class<? extends SpecialMeta> specialMetaClass) {
        Safer.runSafe(() -> {
            String methodName = "accept";
            Object seller = getMeta().instantiateObjectWithConstructor("test", 1);
            Object item = MetaContext.getMeta(specialMetaClass).instantiateObjectWithConstructor();
            int expectedLevel = 2;

            BiConsumer<Object, Object[]> acceptAssert = (obj, params) -> Safer.runSafe(() -> {
                String fieldName = "level";
                Object actualLevel = getFieldValue(obj, fieldName);
                String message = getFieldValueAssert(getMeta().getClassName(), methodName, fieldName, expectedLevel, actualLevel);
                assertEquals(expectedLevel, actualLevel, message);
            });

            testClassMethod(acceptAssert, seller, methodName, item);
        });
    }

    private void testWeaponFix(Class<? extends CharacterMeta> ownerType, Class<? extends WeaponMeta> weaponType,
                               SafeFunction<Meta, Object> itemSupplier, BiConsumer<Object, Object[]> fixAssert) {
        Safer.runSafe(() -> {
            String methodName = "fix";
            Object npc = getMeta().instantiateObjectWithConstructor("test", 1);
            Meta ownerMeta = MetaContext.getMeta(ownerType);
            Object owner = ownerMeta.instantiateObjectWithConstructor("test");
            Meta itemMeta = MetaContext.getMeta(weaponType);
            Object item = itemSupplier.apply(itemMeta);
            testClassMethod(fixAssert, npc, methodName, owner, item);
        });
    }

    private String getFixAssertMessage(String itemType, int expectedDurability, Object actualDurability) {
        return MessageUtil.formatAssertMessage(
                String.format("После вызова метода fix прочность переданного %s должна быть %d", itemType, expectedDurability),
                String.format("После вызова метода fix прочность переданного %s равна %d", itemType, actualDurability)
        );
    }
}
