package com.idoit.profile;

import com.idoit.AbstractTest;
import com.idoit.meta.MetaContext;
import com.idoit.meta.item.armor.BootsMeta;
import com.idoit.meta.item.armor.CuirassMeta;
import com.idoit.meta.item.armor.GlovesMeta;
import com.idoit.meta.item.armor.HelmetMeta;
import com.idoit.meta.item.armor.ShieldMeta;
import com.idoit.meta.item.common.BagMeta;
import com.idoit.meta.profile.InventoryMeta;
import com.idoit.safe.Safer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Inventory")
class InventoryTest extends AbstractTest {

    @BeforeEach
    void setUp() {
        setMeta(InventoryMeta.class);
    }

    @DisplayName("Тест, что класс Inventory находится в пакете com.idoit.profile")
    @Test
    void testInventoryIsInCharacterPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Inventory имеет все необходимые поля")
    @Test
    void testInventoryHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе Inventory есть все необходимые методы")
    @Test
    void testInventoryHasAllMethods() {
        testClassHasAllMethods();
    }

    @DisplayName("Тест, что метод setHelmet в классе Inventory сохраняет переданный шлем в поле класса")
    @Test
    void testSetHelmetSavesHelmetToField() {
        Object[] armorConstructor = new Object[]{"test", 1, 2};
        testSetterWithMetaParam(HelmetMeta.class, armorConstructor, "setHelmet", "helmet");
    }

    @DisplayName("Тест, что метод setCuirass в классе Inventory сохраняет переданную кирасу в поле класса")
    @Test
    void testSetCuirassSavesCuirassToField() {
        Object[] armorConstructor = new Object[]{"test", 1, 2};
        testSetterWithMetaParam(CuirassMeta.class, armorConstructor, "setCuirass", "cuirass");
    }

    @DisplayName("Тест, что метод setGloves в классе Inventory сохраняет переданные перчатки в поле класса")
    @Test
    void testSetGlovesSavesGlovesToField() {
        Object[] armorConstructor = new Object[]{"test", 1, 2};
        testSetterWithMetaParam(GlovesMeta.class, armorConstructor, "setGloves", "gloves");
    }

    @DisplayName("Тест, что метод setBoots в классе Inventory сохраняет переданные сапоги в поле класса")
    @Test
    void testSetBootsSavesBootsToField() {
        Object[] armorConstructor = new Object[]{"test", 1, 2};
        testSetterWithMetaParam(BootsMeta.class, armorConstructor, "setBoots", "boots");
    }

    @DisplayName("Тест, что метод setShield в классе Inventory сохраняет переданный щит в поле класса")
    @Test
    void testSetShieldSavesShieldToField() {
        Object[] armorConstructor = new Object[]{"test", 1, 2};
        testSetterWithMetaParam(ShieldMeta.class, armorConstructor, "setShield", "shield");
    }

    @DisplayName("Тест, что метод setBag в классе Inventory сохраняет переданнную сумку в поле класса")
    @Test
    void testSetBagSavesBagToField() {
        Object[] bagConstructor = new Object[]{"test"};
        testSetterWithMetaParam(BagMeta.class, bagConstructor, "setBag", "bag");
    }

    @DisplayName("Тест, что метод getHelmet в классе Inventory возвращает шлем")
    @Test
    void testGetHelmet() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(HelmetMeta.class).instantiateObjectWithConstructor("test", 1, 2);
            testGetter("getHelmet", "setHelmet", param);
        });
    }

    @DisplayName("Тест, что метод getCuirass в классе Inventory возвращает кирасу")
    @Test
    void testGetCuirass() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(CuirassMeta.class).instantiateObjectWithConstructor("test", 1, 2);
            testGetter("getCuirass", "setCuirass", param);
        });
    }

    @DisplayName("Тест, что метод getGloves в классе Inventory возвращает перчатки")
    @Test
    void testGetGloves() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(GlovesMeta.class).instantiateObjectWithConstructor("test", 1, 2);
            testGetter("getGloves", "setGloves", param);
        });
    }
    
    @DisplayName("Тест, что метод getBoots в классе Inventory возвращает сапоги")
    @Test
    void testGetBoots() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(BootsMeta.class).instantiateObjectWithConstructor("test", 1, 2);
            testGetter("getBoots", "setBoots", param);
        });
    }
    
    @DisplayName("Тест, что метод getShield в классе Inventory возвращает щит")
    @Test
    void testGetShield() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(ShieldMeta.class).instantiateObjectWithConstructor("test", 1, 2);
            testGetter("getShield", "setShield", param);
        });
    }

    @DisplayName("Тест, что метод getBag в классе Inventory возвращает щит")
    @Test
    void testGetBag() {
        Safer.runSafe(() -> {
            Object param = MetaContext.getMeta(BagMeta.class).instantiateObjectWithConstructor("test");
            testGetter("getBag", "setBag", param);
        });
    }
}
