package com.idoit.character;

import com.idoit.meta.Meta;
import com.idoit.meta.MetaContext;
import com.idoit.meta.character.KnightMeta;
import com.idoit.meta.item.armor.BootsMeta;
import com.idoit.meta.item.armor.CuirassMeta;
import com.idoit.meta.item.armor.GlovesMeta;
import com.idoit.meta.item.armor.HelmetMeta;
import com.idoit.meta.item.armor.ShieldMeta;
import com.idoit.meta.item.bijouterie.belt.StrengthBeltMeta;
import com.idoit.meta.item.bijouterie.necklace.StrengthNecklaceMeta;
import com.idoit.meta.item.bijouterie.ring.StrengthRingMeta;
import com.idoit.meta.item.weapon.SwordMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Knight")
class KnightTest extends CharacterTest {

    @BeforeEach
	void setUp() {
        setMeta(KnightMeta.class);
    }

    @DisplayName("Тест, что класс Knight находится в пакете com.idoit.character")
    @Test
    void testKnightIsInCharacterPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Knight имеет все необходимые поля")
    @Test
    void testKnightHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе Knight есть конструктор принимающий имя персонажа")
    @Test
    void testKnightHasConstructorWithNameParam() {
        testClassHasConstructors();
        testConstructorSetsValueToFields("test");
    }

    @DisplayName("Тест, что в классе Knight есть все необходимые методы")
    @Test
    void testKnightHasAllMethods() {
        testClassHasAllMethods();
    }

    @DisplayName("Тест, что метод hit в классе Knight уменьшает хп противника на 10")
    @Test
    void testHitDecreasesEnemyHp() {
        Meta swordMeta = MetaContext.getMeta(SwordMeta.class);
        testHitDamagesEnemy(swordMeta, "setSword");
    }

    @DisplayName("Тест, что метод hit в классе Knight уменьшает прочность оружия на 1")
    @Test
    void testHitDecreasesWeaponDurability() {
        Meta swordMeta = MetaContext.getMeta(SwordMeta.class);
        testHitDamagesWeapon(swordMeta, "setSword", "sword");
    }

    @DisplayName("Тест, что метод go в классе Knight меняет координаты точки персонажа")
    @Test
    void testGoChangesPointCoordinates() {
        testGo();
    }

    @DisplayName("Тест, что метод setSword в классе Knight сохраняет переданный Sword в поле класса")
    @Test
    void testSetSwordSavesSwordToField() {
        String methodName = "setSword";
        Meta valueMeta = MetaContext.getMeta(SwordMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetWeapon(valueMeta, methodName, "sword", message);
    }

    @DisplayName("Тест, что метод setHelmet в классе Knight сохраняет полученный Helmet в поле класса")
    @Test
    void testSetHelmetSavesHelmetToField() {
        String methodName = "setHelmet";
        Meta valueMeta = MetaContext.getMeta(HelmetMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetArmor(valueMeta, methodName, "helmet", message);
    }

    @DisplayName("Тест, что метод setCuirass в классе Knight сохраняет полученный Cuirass в поле класса")
    @Test
    void testSetCuirassSavesCuirassToField() {
        String methodName = "setCuirass";
        Meta valueMeta = MetaContext.getMeta(CuirassMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetArmor(valueMeta, methodName, "cuirass", message);
    }

    @DisplayName("Тест, что метод setGloves в классе Knight сохраняет полученный Gloves в поле класса")
    @Test
    void testSetGlovesSavesGlovesToField() {
        String methodName = "setGloves";
        Meta valueMeta = MetaContext.getMeta(GlovesMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetArmor(valueMeta, methodName, "gloves", message);
    }

    @DisplayName("Тест, что метод setBoots в классе Knight сохраняет полученный Boots в поле класса")
    @Test
    void testSetBootsSavesBootsToField() {
        String methodName = "setBoots";
        Meta valueMeta = MetaContext.getMeta(BootsMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetArmor(valueMeta, methodName, "boots", message);
    }

    @DisplayName("Тест, что метод setShield в классе Knight сохраняет полученный Shield в поле класса")
    @Test
    void testSetShieldSavesShieldToField() {
        String methodName = "setShield";
        Meta valueMeta = MetaContext.getMeta(ShieldMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetArmor(valueMeta, methodName, "shield", message);
    }

    @DisplayName("Тест, что метод setLeftRing в классе Knight сохраняет полученный StrengthRing в поле класса")
    @Test
    void testSetLeftRingSavesStrengthRingToField() {
        String methodName = "setLeftRing";
        Meta valueMeta = MetaContext.getMeta(StrengthRingMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetBijouterie(valueMeta, methodName, "leftRing", message);
    }

    @DisplayName("Тест, что метод setRightRing в классе Knight сохраняет полученный StrengthRing в поле класса")
    @Test
    void testSetRightRingSavesStrengthRingToField() {
        String methodName = "setRightRing";
        Meta valueMeta = MetaContext.getMeta(StrengthRingMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetBijouterie(valueMeta, methodName, "rightRing", message);
    }

    @DisplayName("Тест, что метод setBelt в классе Knight сохраняет полученный StrengthBelt в поле класса")
    @Test
    void testSetBeltSavesStrengthBeltToField() {
        String methodName = "setBelt";
        Meta valueMeta = MetaContext.getMeta(StrengthBeltMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetBijouterie(valueMeta, methodName, "belt", message);
    }

    @DisplayName("Тест, что метод setNecklace в классе Knight сохраняет полученный StrengthNecklace в поле класса")
    @Test
    void testSetNecklaceSavesStrengthNecklaceToField() {
        String methodName = "setNecklace";
        Meta valueMeta = MetaContext.getMeta(StrengthNecklaceMeta.class);
        String message = getSetterAssertMessage(methodName, valueMeta.getClassName(), getMeta().getClassName());
        testSetBijouterie(valueMeta, methodName, "necklace", message);
    }
}
