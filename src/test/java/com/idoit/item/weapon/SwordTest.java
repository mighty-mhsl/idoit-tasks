package com.idoit.item.weapon;

import com.idoit.AbstractTest;
import com.idoit.meta.MetaContext;
import com.idoit.meta.item.stone.DamageStoneMeta;
import com.idoit.meta.item.weapon.SwordMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты логики в классе Sword")
class SwordTest extends AbstractTest {

    private SwordMeta.SwordLook sword;

    @BeforeEach
	void setUp() {
        setMeta(SwordMeta.class);
        SwordMeta meta = (SwordMeta) getMeta();
        sword = meta.getLook();
    }

    @DisplayName("Тест, что класс Sword находится в пакете com.idoit.item.weapon")
    @Test
    void testSwordIsInWeaponPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Sword имеет все необходимые поля")
    @Test
    void testSwordHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе Sword есть конструктор принимающий название и урон оружия")
    @Test
    void testSwordHasConstructorWithNameAndDamageParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields("test", 5);
    }

    @DisplayName("Тест, что в классе Sword есть все необходимые методы")
    @Test
    void testSwordHasAllMethods() {
        testClassHasAllMethods();
    }

    @DisplayName("Тест, что метод setDurability в классе Sword сохраняет переданный x в поле класса")
    @Test
    void testSetDurabilitySavesDurabilityToField() {
        int expectedValue = 5;
        sword.setDurability(expectedValue);
        String message = getSetterAssertMessage("setDurability", "durability", getMeta().getClassName());
        assertEquals(expectedValue, sword.getDurability(), message);
    }

    @DisplayName("Тест, что метод setStone в классе Sword сохраняет полученный DamageStone в поле класса")
    @Test
    void testSetStoneSavesStoneToField() {
        DamageStoneMeta damageStone = (DamageStoneMeta) MetaContext.getMeta(DamageStoneMeta.class);
        sword.setStone(damageStone);
        String message = getSetterAssertMessage("setStone", damageStone.getClassName(), getMeta().getClassName());
        assertEquals(damageStone, sword.getStone(), message);
    }

    @DisplayName("Тест, что метод getStone в классе Sword возвращает камень зачаровывания оружия")
    @Test
    void testGetStone() {
        DamageStoneMeta damageStone = (DamageStoneMeta) MetaContext.getMeta(DamageStoneMeta.class);
        sword.setStone(damageStone);
        DamageStoneMeta actualValue = sword.getStone();
        String message = getMethodReturnResultAssertMessage("getStone", damageStone, actualValue);
        assertEquals(damageStone, actualValue, message);
    }
}
