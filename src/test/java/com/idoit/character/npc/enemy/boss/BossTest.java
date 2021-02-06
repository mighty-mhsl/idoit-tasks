package com.idoit.character.npc.enemy.boss;

import com.idoit.AbstractTest;
import com.idoit.MessageUtil;
import com.idoit.meta.MetaContext;
import com.idoit.meta.battlefield.PointMeta;
import com.idoit.meta.character.KnightMeta;
import com.idoit.meta.profile.ProfileMeta;
import com.idoit.safe.Safer;

import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class BossTest extends AbstractTest {

    static final Object[] CONSTRUCTOR_PARAMS = new Object[]{1, 2};

    void testHit() {
        Safer.runSafe(() -> {
            String methodName = "hit";
            int damage = 2;
            Object boss = getMeta().instantiateObjectWithConstructor(1, damage);
            Object knight = MetaContext.getMeta(KnightMeta.class).instantiateObjectWithConstructor("test");
            setFieldForObjectAndGet(knight, "setProfile", ProfileMeta.class);

            BiConsumer<Object, Object[]> hitAssert = (obj, params) -> Safer.runSafe(() -> {
                String profileFieldName = "profile";
                Object profile = getFieldValue(knight, profileFieldName);
                String fieldName = "hp";
                Object actualHp = getFieldValue(profile, fieldName);
                int expectedHp = 100 - damage;
                String message = getHitAssertMessage(getMeta().getClassName(), methodName, expectedHp, actualHp);
                assertEquals(expectedHp, actualHp, message);
            });

            testClassMethod(hitAssert, boss, methodName, knight);
        });
    }

    void testGo() {
        Safer.runSafe(() -> {
            String methodName = "go";
            Object boss = getMeta().instantiateObjectWithConstructor(CONSTRUCTOR_PARAMS);
            setFieldForObjectAndGet(boss, "setPoint", PointMeta.class, 0, 0);
            int x = 1;
            int y = 2;

            BiConsumer<Object, Object[]> goAssert = (obj, params) -> Safer.runSafe(() -> {
                String pointFieldName = "point";
                String xFieldName = "x";
                String yFieldName = "y";
                Object point = getFieldValue(boss, pointFieldName);
                Object actualX = getFieldValue(point, xFieldName);
                Object actualY = getFieldValue(point, yFieldName);
                String xMessage = getGoAssertMessage(getMeta().getClassName(), methodName, xFieldName, x, actualX);
                String yMessage = getGoAssertMessage(getMeta().getClassName(), methodName, yFieldName, y, actualY);
                assertEquals(x, actualX, xMessage);
                assertEquals(y, actualY, yMessage);
            });

            testClassMethod(goAssert, boss, methodName, x, y);
        });
    }

    private String getHitAssertMessage(String className, String methodName, int expectedValue, Object actualValue) {
        return MessageUtil.formatAssertMessage(
                String.format("После вызова метод %s в классе %s хп переданного рыцаря должно быть равно %d", methodName, className, expectedValue),
                String.format("После вызова метод %s в классе %s хп переданного рыцаря равно %d", methodName, className, actualValue)
        );
    }

    private String getGoAssertMessage(String className, String methodName, String fieldName, int expectedValue, Object actualValue) {
        return MessageUtil.formatAssertMessage(
                String.format("После вызова метод %s в классе %s поле %s точки босса должно быть равно %d",
                        methodName, className, fieldName, expectedValue),
                String.format("После вызова метод %s в классе %s поле %s точки босса равно %d", methodName, className,
                        fieldName, actualValue)
        );
    }
}
