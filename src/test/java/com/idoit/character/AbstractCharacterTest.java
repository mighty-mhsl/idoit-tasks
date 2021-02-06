package com.idoit.character;

import com.idoit.AbstractTest;
import com.idoit.MessageUtil;
import com.idoit.safe.Safer;

import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractCharacterTest extends AbstractTest {

    protected void testGo(Object... constructorParams) {
        Safer.runSafe(() -> {
            Object whoGoes = getMeta().instantiateObjectWithConstructor(constructorParams);

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
}
