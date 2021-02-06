package com.idoit.character.npc.enemy;

import com.idoit.MessageUtil;
import com.idoit.character.AbstractCharacterTest;
import com.idoit.meta.Meta;
import com.idoit.meta.MetaContext;
import com.idoit.meta.character.KnightMeta;
import com.idoit.safe.Safer;

import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class EnemyTest extends AbstractCharacterTest {

    void testHitMethod() {
        Safer.runSafe(() -> {
            int damage = 2;
            Object enemy = getMeta().instantiateObjectWithConstructor(1, damage);

            BiConsumer<Object, Object[]> hitAssert = (obj, params) -> {
                Object knight = params[0];
                Safer.runSafe(() -> {
                    int expectedHp = 100 - damage;
                    Object profile = getFieldValue(knight, "profile");
                    Object actualHp = getFieldValue(profile, "hp");
                    String message = getHitAssertMessage(getMeta().getClassName(), expectedHp, actualHp);
                    assertEquals(expectedHp, actualHp, message);
                });
            };

            Meta knightMeta = MetaContext.getMeta(KnightMeta.class);
            Object knight = knightMeta.instantiateObjectWithConstructor("test");
            testClassMethod(hitAssert, enemy, "hit", knight);
        });
    }

    private String getHitAssertMessage(String className, int expectedHp, Object actualHp) {
        return MessageUtil.formatAssertMessage(
                String.format("После вызова метода hit в классе %s переданный Knight должен иметь %d hp", className, expectedHp),
                String.format("После вызова метода hit в классе %s переданный Knight имеет %d hp", className, actualHp)
        );
    }
}
