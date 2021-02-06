package com.idoit.profile;

import com.idoit.AbstractTest;
import com.idoit.meta.profile.InventoryMeta;
import com.idoit.meta.profile.ProfileMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты логики в классе Profile")
class ProfileTest extends AbstractTest {

    private ProfileMeta.ProfileLook profile;
    
    @BeforeEach
    void setUp() {
        setMeta(ProfileMeta.class);
        ProfileMeta meta = (ProfileMeta) getMeta();
        profile = meta.getLook();
    }

    @DisplayName("Тест, что класс Profile находится в пакете com.idoit.profile")
    @Test
    void testProfileIsInCharacterPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Profile имеет все необходимые поля")
    @Test
    void testProfileHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе Profile есть все необходимые методы")
    @Test
    void testProfileHasAllMethods() {
        testClassHasAllMethods();
    }

    @DisplayName("Тест, что метод setName в классе Profile сохраняет имя персонажа в поле класса")
    @Test
    void testSetName() {
        String expectedValue = "test";
        profile.setName(expectedValue);
        String message = getSetterAssertMessage("setName", "name", getMeta().getClassName());
        assertEquals(expectedValue, profile.getName(), message);
    }

    @DisplayName("Тест, что метод setStrength в классе Profile сохраняет силу персонажа в поле класса")
    @Test
    void testSetStrength() {
        int expectedValue = 5;
        profile.setStrength(expectedValue);
        String message = getSetterAssertMessage("setStrength", "strength", getMeta().getClassName());
        assertEquals(expectedValue, profile.getStrength(), message);
    }

    @DisplayName("Тест, что метод setAgility в классе Profile сохраняет ловкость персонажа в поле класса")
    @Test
    void testSetAgility() {
        int expectedValue = 5;
        profile.setAgility(expectedValue);
        String message = getSetterAssertMessage("setAgility", "agility", getMeta().getClassName());
        assertEquals(expectedValue, profile.getAgility(), message);
    }

    @DisplayName("Тест, что метод setIntelligence в классе Profile сохраняет интеллект персонажа в поле класса")
    @Test
    void testSetIntelligence() {
        int expectedValue = 5;
        profile.setIntelligence(expectedValue);
        String message = getSetterAssertMessage("setIntelligence", "intelligence", getMeta().getClassName());
        assertEquals(expectedValue, profile.getIntelligence(), message);
    }

    @DisplayName("Тест, что метод setHp в классе Profile сохраняет хп персонажа в поле класса")
    @Test
    void testSetHp() {
        int expectedValue = 5;
        profile.setHp(expectedValue);
        String message = getSetterAssertMessage("setHp", "hp", getMeta().getClassName());
        assertEquals(expectedValue, profile.getHp(), message);
    }

    @DisplayName("Тест, что метод setMana в классе Profile сохраняет ману персонажа в поле класса")
    @Test
    void testSetMana() {
        int expectedValue = 5;
        profile.setMana(expectedValue);
        String message = getSetterAssertMessage("setMana", "mana", getMeta().getClassName());
        assertEquals(expectedValue, profile.getMana(), message);
    }

    @DisplayName("Тест, что метод setStamina в классе Profile сохраняет выносливость персонажа в поле класса")
    @Test
    void testSetStamina() {
        int expectedValue = 5;
        profile.setStamina(expectedValue);
        String message = getSetterAssertMessage("setStamina", "stamina", getMeta().getClassName());
        assertEquals(expectedValue, profile.getStamina(), message);
    }

    @DisplayName("Тест, что метод setLevel в классе Profile сохраняет уровень персонажа в поле класса")
    @Test
    void testSetLevel() {
        int expectedValue = 5;
        profile.setLevel(expectedValue);
        String message = getSetterAssertMessage("setLevel", "level", getMeta().getClassName());
        assertEquals(expectedValue, profile.getLevel(), message);
    }

    @DisplayName("Тест, что метод setExperience в классе Profile сохраняет опыт персонажа в поле класса")
    @Test
    void testSetExperience() {
        int expectedValue = 5;
        profile.setExperience(expectedValue);
        String message = getSetterAssertMessage("setExperience", "experience", getMeta().getClassName());
        assertEquals(expectedValue, profile.getExperience(), message);
    }

    @DisplayName("Тест, что метод setGold в классе Profile сохраняет золото персонажа в поле класса")
    @Test
    void testSetGold() {
        int expectedValue = 5;
        profile.setGold(expectedValue);
        String message = getSetterAssertMessage("setGold", "gold", getMeta().getClassName());
        assertEquals(expectedValue, profile.getGold(), message);
    }

    @DisplayName("Тест, что метод setPhysicalDefence в классе Profile сохраняет физическую защиту персонажа в поле класса")
    @Test
    void testSetPhysicalDefence() {
        int expectedValue = 5;
        profile.setPhysicalDefence(expectedValue);
        String message = getSetterAssertMessage("setPhysicalDefence", "physicalDefence", getMeta().getClassName());
        assertEquals(expectedValue, profile.getPhysicalDefence(), message);
    }

    @DisplayName("Тест, что метод setMagicDefence в классе Profile сохраняет магическую защиту персонажа в поле класса")
    @Test
    void testSetMagicDefence() {
        int expectedValue = 5;
        profile.setMagicDefence(expectedValue);
        String message = getSetterAssertMessage("setMagicDefence", "magicDefence", getMeta().getClassName());
        assertEquals(expectedValue, profile.getMagicDefence(), message);
    }

    @DisplayName("Тест, что метод setInventory в классе Profile сохраняет инвентарь персонажа в поле класса")
    @Test
    void testSetInventory() {
        InventoryMeta expectedValue = new InventoryMeta();
        profile.setInventory(expectedValue);
        String message = getSetterAssertMessage("setInventory", "inventory", getMeta().getClassName());
        assertEquals(expectedValue, profile.getInventory(), message);
    }

    @DisplayName("Тест, что метод getName в классе Profile возвращает имя персонажа")
    @Test
    void testGetName() {
        String expectedValue = "test";
        profile.setName(expectedValue);
        String actualValue = profile.getName();
        String message = getMethodReturnResultAssertMessage("getName", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getStrength в классе Profile возвращает силу персонажа")
    @Test
    void testGetStrength() {
        int expectedValue = 5;
        profile.setStrength(expectedValue);
        int actualValue = profile.getStrength();
        String message = getMethodReturnResultAssertMessage("getStrength", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getAgility в классе Profile возвращает ловкость персонажа")
    @Test
    void testGetAgility() {
        int expectedValue = 5;
        profile.setAgility(expectedValue);
        int actualValue = profile.getAgility();
        String message = getMethodReturnResultAssertMessage("getAgility", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getIntelligence в классе Profile возвращает интеллект персонажа")
    @Test
    void testGetIntelligence() {
        int expectedValue = 5;
        profile.setIntelligence(expectedValue);
        int actualValue = profile.getIntelligence();
        String message = getMethodReturnResultAssertMessage("getIntelligence", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getHp в классе Profile возвращает здоровье персонажа")
    @Test
    void testGetHp() {
        int expectedValue = 5;
        profile.setHp(expectedValue);
        int actualValue = profile.getHp();
        String message = getMethodReturnResultAssertMessage("getHp", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getMana в классе Profile возвращает ману персонажа")
    @Test
    void testGetMana() {
        int expectedValue = 5;
        profile.setMana(expectedValue);
        int actualValue = profile.getMana();
        String message = getMethodReturnResultAssertMessage("getMana", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getStamina в классе Profile возвращает выносливость персонажа")
    @Test
    void testGetStamina() {
        int expectedValue = 5;
        profile.setStamina(expectedValue);
        int actualValue = profile.getStamina();
        String message = getMethodReturnResultAssertMessage("getStamina", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getLevel в классе Profile возвращает уровень персонажа")
    @Test
    void testGetLevel() {
        int expectedValue = 5;
        profile.setLevel(expectedValue);
        int actualValue = profile.getLevel();
        String message = getMethodReturnResultAssertMessage("getLevel", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getExperience в классе Profile возвращает опыт персонажа")
    @Test
    void testGetExperience() {
        int expectedValue = 5;
        profile.setExperience(expectedValue);
        int actualValue = profile.getExperience();
        String message = getMethodReturnResultAssertMessage("getExperience", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getPhysicalDefence в классе Profile возвращает физическую защиту персонажа")
    @Test
    void testGetPhysicalDefence() {
        int expectedValue = 5;
        profile.setPhysicalDefence(expectedValue);
        int actualValue = profile.getPhysicalDefence();
        String message = getMethodReturnResultAssertMessage("getPhysicalDefence", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getMagicDefence в классе Profile возвращает магическую защиту персонажа")
    @Test
    void testGetMagicDefence() {
        int expectedValue = 5;
        profile.setMagicDefence(expectedValue);
        int actualValue = profile.getMagicDefence();
        String message = getMethodReturnResultAssertMessage("getMagicDefence", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }

    @DisplayName("Тест, что метод getInventory в классе Profile возвращает инвентарь персонажа")
    @Test
    void testGetInventory() {
        InventoryMeta expectedValue = new InventoryMeta();
        profile.setInventory(expectedValue);
        InventoryMeta actualValue = profile.getInventory();
        String message = getMethodReturnResultAssertMessage("getInventory", expectedValue, actualValue);
        assertEquals(expectedValue, actualValue, message);
    }
}
