package com.idoit.battlefield;

import com.idoit.AbstractTest;
import com.idoit.meta.battlefield.PointMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты логики в классе Point")
class PointTest extends AbstractTest {

    private PointMeta.PointLook point;

    @BeforeEach
    void setUp() {
        setMeta(PointMeta.class);
        PointMeta meta = (PointMeta) getMeta();
        point = meta.getLook();
//        getMeta().refresh();
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

    @DisplayName("Тест, что класс Point иммет конструктор для двух координат")
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
        int x = 4;
        String message = getSetterAssertMessage("setX", "x", getMeta().getClassName());
        point.setX(x);
        assertEquals(x, point.getX(), message);
    }

    @DisplayName("Тест, что метод setY в классе Point сохраняет переданный y в поле класса")
    @Test
    void testSetYSavesYToField() {
        int y = 5;
        String message = getSetterAssertMessage("setY", "y", getMeta().getClassName());
        point.setY(y);
        assertEquals(y, point.getY(), message);
    }

    @DisplayName("Тест, что метод setXY в классе Point сохраняет переданные x и y в поля класса")
    @Test
    void testSetXYSavesXAndYToFields() {
        int x = 2;
        int y = 3;
        String messageX = getSetterAssertMessage("setXY", "x", getMeta().getClassName());
        String messageY = getSetterAssertMessage("setXY", "y", getMeta().getClassName());
        point.setXY(x, y);
        assertEquals(x, point.getX(), messageX);
        assertEquals(y, point.getY(), messageY);
    }

    @DisplayName("Тест, что метод getX в классе Point возвращает координату х точки")
    @Test
    void testGetX() {
        int expected = 1;
        int actual = point.getX();
        String message = getMethodReturnResultAssertMessage("getX", expected, actual);
        assertEquals(expected, actual, message);
    }

    @DisplayName("Тест, что метод getY в классе Point возвращает координату х точки")
    @Test
    void testGetY() {
        int expected = 2;
        int actual = point.getY();
        String message = getMethodReturnResultAssertMessage("getY", expected, actual);
        assertEquals(expected, point.getY(), message);
    }
}
