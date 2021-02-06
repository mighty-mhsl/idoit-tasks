package com.idoit.item.weapon;

import com.idoit.AbstractTest;
import com.idoit.meta.MetaContext;
import com.idoit.meta.item.stone.CriticalHitStoneMeta;
import com.idoit.meta.item.weapon.BowMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты логики в классе Bow")
class BowTest extends AbstractTest {

    private BowMeta.BowLook bow;

    @BeforeEach
	void setUp() {
        setMeta(BowMeta.class);
        BowMeta meta = (BowMeta) getMeta();
        bow = meta.getLook();
    }

    @DisplayName("Тест, что класс Bow находится в пакете com.idoit.item.weapon")
    @Test
    void testBowIsInWeaponPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Bow имеет все необходимые поля")
    @Test
    void testBowHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе Bow есть конструктор принимающий название и урон оружия")
    @Test
    void testBowHasConstructorWithNameAndDamageParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields("test", 5);
    }

    @DisplayName("Тест, что в классе Bow есть все необходимые методы")
    @Test
    void testBowHasAllMethods() {
        testClassHasAllMethods();
    }

    @DisplayName("Тест, что метод setDurability в классе Bow сохраняет переданный x в поле класса")
    @Test
    void testSetDurabilitySavesDurabilityToField() {
        int expectedValue = 5;
        bow.setDurability(expectedValue);
        String message = getSetterAssertMessage("setDurability", "durability", getMeta().getClassName());
        assertEquals(expectedValue, bow.getDurability(), message);
    }

    @DisplayName("Тест, что метод setStone в классе Bow сохраняет полученный DamageStone в поле класса")
    @Test
    void testSetStoneSavesStoneToField() {
        CriticalHitStoneMeta stone = (CriticalHitStoneMeta) MetaContext.getMeta(CriticalHitStoneMeta.class);
        bow.setStone(stone);
        String message = getSetterAssertMessage("setStone", stone.getClassName(), getMeta().getClassName());
        assertEquals(stone, bow.getStone(), message);
    }

    @DisplayName("Тест, что метод getStone в классе Bow возвращает камень зачаровывания оружия")
    @Test
    void testGetStone() {
        CriticalHitStoneMeta stone = (CriticalHitStoneMeta) MetaContext.getMeta(CriticalHitStoneMeta.class);
        bow.setStone(stone);
        CriticalHitStoneMeta actualValue = bow.getStone();
        String message = getMethodReturnResultAssertMessage("getStone", stone, actualValue);
        assertEquals(stone, actualValue, message);
    }
}
