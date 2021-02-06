package com.idoit.profile;

import com.idoit.AbstractTest;
import com.idoit.meta.item.armor.BootsMeta;
import com.idoit.meta.item.armor.CuirassMeta;
import com.idoit.meta.item.armor.GlovesMeta;
import com.idoit.meta.item.armor.HelmetMeta;
import com.idoit.meta.item.armor.ShieldMeta;
import com.idoit.meta.item.common.BagMeta;
import com.idoit.meta.profile.InventoryMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты логики в классе Inventory")
class InventoryTest extends AbstractTest {

    private InventoryMeta.InventoryLook inventory;

    @BeforeEach
    void setUp() {
        setMeta(InventoryMeta.class);
        InventoryMeta meta = (InventoryMeta) getMeta();
        inventory = meta.getLook();
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
        HelmetMeta expectedValue = new HelmetMeta();
        inventory.setHelmet(expectedValue);
        String message = getSetterAssertMessage("setHelmet", "helmet", getMeta().getClassName());
        assertEquals(expectedValue, inventory.getHelmet(), message);
    }

    @DisplayName("Тест, что метод setCuirass в классе Inventory сохраняет переданную кирасу в поле класса")
    @Test
    void testSetCuirassSavesCuirassToField() {
        CuirassMeta expectedValue = new CuirassMeta();
        inventory.setCuirass(expectedValue);
        String message = getSetterAssertMessage("setCuirass", "cuirass", getMeta().getClassName());
        assertEquals(expectedValue, inventory.getCuirass(), message);
    }

    @DisplayName("Тест, что метод setGloves в классе Inventory сохраняет переданные перчатки в поле класса")
    @Test
    void testSetGlovesSavesGlovesToField() {
        GlovesMeta expectedValue = new GlovesMeta();
        inventory.setGloves(expectedValue);
        String message = getSetterAssertMessage("setGloves", "gloves", getMeta().getClassName());
        assertEquals(expectedValue, inventory.getGloves(), message);
    }

    @DisplayName("Тест, что метод setBoots в классе Inventory сохраняет переданные сапоги в поле класса")
    @Test
    void testSetBootsSavesBootsToField() {
        BootsMeta expectedValue = new BootsMeta();
        inventory.setBoots(expectedValue);
        String message = getSetterAssertMessage("setBoots", "boots", getMeta().getClassName());
        assertEquals(expectedValue, inventory.getBoots(), message);
    }

    @DisplayName("Тест, что метод setShield в классе Inventory сохраняет переданный щит в поле класса")
    @Test
    void testSetShieldSavesShieldToField() {
        ShieldMeta expectedValue = new ShieldMeta();
        inventory.setShield(expectedValue);
        String message = getSetterAssertMessage("setShield", "helmet", getMeta().getClassName());
        assertEquals(expectedValue, inventory.getShield(), message);
    }

    @DisplayName("Тест, что метод setBag в классе Inventory сохраняет переданнную сумку в поле класса")
    @Test
    void testSetBagSavesBagToField() {
        BagMeta expectedValue = new BagMeta();
        inventory.setBag(expectedValue);
        String message = getSetterAssertMessage("setBag", "bag", getMeta().getClassName());
        assertEquals(expectedValue, inventory.getBag(), message);
    }

    @DisplayName("Тест, что метод getHelmet в классе Inventory возвращает шлем")
    @Test
    void testGetHelmet() {
        HelmetMeta expectedValue = new HelmetMeta();
        inventory.setHelmet(expectedValue);
        HelmetMeta actualValue = inventory.getHelmet();
        String message = getMethodReturnResultAssertMessage("getHelmet", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getCuirass в классе Inventory возвращает кирасу")
    @Test
    void testGetCuirass() {
        CuirassMeta expectedValue = new CuirassMeta();
        inventory.setCuirass(expectedValue);
        CuirassMeta actualValue = inventory.getCuirass();
        String message = getMethodReturnResultAssertMessage("getCuirass", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getGloves в классе Inventory возвращает перчатки")
    @Test
    void testGetGloves() {
        GlovesMeta expectedValue = new GlovesMeta();
        inventory.setGloves(expectedValue);
        GlovesMeta actualValue = inventory.getGloves();
        String message = getMethodReturnResultAssertMessage("getGloves", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }
    
    @DisplayName("Тест, что метод getBoots в классе Inventory возвращает сапоги")
    @Test
    void testGetBoots() {
        BootsMeta expectedValue = new BootsMeta();
        inventory.setBoots(expectedValue);
        BootsMeta actualValue = inventory.getBoots();
        String message = getMethodReturnResultAssertMessage("getBoots", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }
    
    @DisplayName("Тест, что метод getShield в классе Inventory возвращает щит")
    @Test
    void testGetShield() {
        ShieldMeta expectedValue = new ShieldMeta();
        inventory.setShield(expectedValue);
        ShieldMeta actualValue = inventory.getShield();
        String message = getMethodReturnResultAssertMessage("getShield", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getBag в классе Inventory возвращает щит")
    @Test
    void testGetBag() {
        BagMeta expectedValue = new BagMeta();
        inventory.setBag(expectedValue);
        BagMeta actualValue = inventory.getBag();
        String message = getMethodReturnResultAssertMessage("getHelmet", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }
}
