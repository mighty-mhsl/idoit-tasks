package com.idoit.character.npc.seller;

import com.idoit.AbstractTest;
import com.idoit.MessageUtil;
import com.idoit.meta.Meta;
import com.idoit.meta.MetaContext;
import com.idoit.safe.SafeFunction;
import com.idoit.safe.Safer;

import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class SellerTest extends AbstractTest {

    void testFix(Class<? extends Meta> itemType, SafeFunction<Meta, Object> itemSupplier) {
        Safer.runSafe(() -> {
            Object npc = getMeta().instantiateObjectWithConstructor("test", 1);

            BiConsumer<Object, Object[]> fixAssert = (obj, params) -> {
                Object armor = params[0];
                Safer.runSafe(() -> {
                    Object durability = getFieldValue(armor, "durability");
                    int expectedDurability = 100;
                    String message = getFixAssertMessage(armor.getClass().getName(), expectedDurability, durability);
                    assertEquals(expectedDurability, durability, message);
                });
            };

            Meta itemMeta = MetaContext.getMeta(itemType);
            Object armor = itemSupplier.apply(itemMeta);
            testClassMethod(fixAssert, npc, "fix", armor);
        });
    }

    private String getFixAssertMessage(String itemType, int expectedDurability, Object actualDurability) {
        return MessageUtil.formatAssertMessage(
                String.format("После вызова метода fix прочность переданного %s должна быть %d", itemType, expectedDurability),
                String.format("После вызова метода fix прочность переданного %s равна %d", itemType, actualDurability)
        );
    }
}
