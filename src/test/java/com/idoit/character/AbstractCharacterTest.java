package com.idoit.character;

import com.idoit.AbstractTest;
import com.idoit.MessageUtil;

public abstract class AbstractCharacterTest extends AbstractTest {

    protected String getGoAssertMessage(String fieldName, Object expectedValue, Object actualValue) {
        return MessageUtil.formatAssertMessage(
                String.format("После вызова метода go персонаж должен иметь координату по %s: %d", fieldName, expectedValue),
                String.format("После вызова метода go персонаж имеет координату по %s: %d", fieldName, actualValue)
        );
    }
}
