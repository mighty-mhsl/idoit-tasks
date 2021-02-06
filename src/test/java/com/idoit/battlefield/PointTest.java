package com.idoit.battlefield;

import com.idoit.AbstractTest;
import com.idoit.meta.battlefield.PointMeta;
import com.idoit.safe.Safer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты логики в классе Point")
class PointTest extends AbstractTest {

    @BeforeEach
    void setUp() {
        setMeta(PointMeta.class);
    }

    @DisplayName("Тест, что класс Point находится в пакете com.idoit.battlefield")
    @Test
    void testPointIsInBattlefieldPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Point имеет все необходимые поля")
    @Test
    void testPointHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("")
    @Test
    void testPointHasConstructorWithXAndYParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields(3, 4);
    }

    @DisplayName("Тест, что в классе Point есть все необходимые методы")
    @Test
    void testPointHasAllMethods() {
        testClassHasAllMethods();
    }

    @DisplayName("Тест, что метод setX в классе Point сохраняет переданный x в поле класса")
    @Test
    void testSetXSavesXToField() {
        String methodName = "setX";
        String message = getSetterAssertMessage(methodName, int.class.getName(), getMeta().getClassName());
        testSetter(5, methodName, "x", message, 0, 0);
    }

    @DisplayName("Тест, что метод setY в классе Point сохраняет переданный y в поле класса")
    @Test
    void testSetYSavesYToField() {
        String methodName = "setY";
        String message = getSetterAssertMessage(methodName, int.class.getName(), getMeta().getClassName());
        testSetter(5, methodName, "y", message, 0, 0);
    }

    @DisplayName("Тест, что метод setXY в классе Point сохраняет переданные x и y в поля класса")
    @Test
    void testSetXYSavesXAndYToFields() {
        Safer.runSafe(() -> {
            String methodName = "setXY";
            Object point = getMeta().instantiateObjectWithConstructor(0, 0);

            BiConsumer<Object, Object[]> xyAssert = (obj, params) -> {
                Object x = params[0];
                Object y = params[1];
                Safer.runSafe(() -> {
                    Object xFieldValue = getFieldValue(obj, "x");
                    Object yFieldValue = getFieldValue(obj, "y");
                    assertEquals(x, xFieldValue, getSetterAssertMessage(methodName, "x", getMeta().getClassName()));
                    assertEquals(y, yFieldValue, getSetterAssertMessage(methodName, "y", getMeta().getClassName()));
                });
            };

            testClassMethod(xyAssert, point, methodName, 1, 2);
        });
    }
}
