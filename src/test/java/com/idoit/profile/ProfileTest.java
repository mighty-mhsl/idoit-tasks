package com.idoit.profile;

import com.idoit.AbstractTest;
import com.idoit.meta.profile.InventoryMeta;
import com.idoit.meta.profile.ProfileMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Profile")
class ProfileTest extends AbstractTest {
    
    @BeforeEach
    void setUp() {
        setMeta(ProfileMeta.class);
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
        testSetter("test", "setName", "name");
    }

    @DisplayName("Тест, что метод setStrength в классе Profile сохраняет силу персонажа в поле класса")
    @Test
    void testSetStrength() {
        testSetter(5, "setStrength", "strength");
    }

    @DisplayName("Тест, что метод setAgility в классе Profile сохраняет ловкость персонажа в поле класса")
    @Test
    void testSetAgility() {
        testSetter(5, "setAgility", "agility");
    }

    @DisplayName("Тест, что метод setIntelligence в классе Profile сохраняет интеллект персонажа в поле класса")
    @Test
    void testSetIntelligence() {
        testSetter(5, "setIntelligence", "intelligence");
    }

    @DisplayName("Тест, что метод setHp в классе Profile сохраняет хп персонажа в поле класса")
    @Test
    void testSetHp() {
        testSetter(5, "setHp", "hp");
    }

    @DisplayName("Тест, что метод setMana в классе Profile сохраняет ману персонажа в поле класса")
    @Test
    void testSetMana() {
        testSetter(5, "setMana", "mana");
    }

    @DisplayName("Тест, что метод setStamina в классе Profile сохраняет выносливость персонажа в поле класса")
    @Test
    void testSetStamina() {
        testSetter(5, "setStamina", "stamina");
    }

    @DisplayName("Тест, что метод setLevel в классе Profile сохраняет уровень персонажа в поле класса")
    @Test
    void testSetLevel() {
        testSetter(5, "setLevel", "level");
    }

    @DisplayName("Тест, что метод setExperience в классе Profile сохраняет опыт персонажа в поле класса")
    @Test
    void testSetExperience() {
        testSetter(5, "setExperience", "experience");
    }

    @DisplayName("Тест, что метод setGold в классе Profile сохраняет золото персонажа в поле класса")
    @Test
    void testSetGold() {
        testSetter(5, "setGold", "gold");
    }

    @DisplayName("Тест, что метод setPhysicalDefence в классе Profile сохраняет физическую защиту персонажа в поле класса")
    @Test
    void testSetPhysicalDefence() {
        testSetter(5, "setPhysicalDefence", "physicalDefence");
    }

    @DisplayName("Тест, что метод setMagicDefence в классе Profile сохраняет магическую защиту персонажа в поле класса")
    @Test
    void testSetMagicDefence() {
        testSetter(5, "setMagicDefence", "magicDefence");
    }

    @DisplayName("Тест, что метод setInventory в классе Profile сохраняет инвентарь персонажа в поле класса")
    @Test
    void testSetInventory() {
        testSetterWithMetaParam(InventoryMeta.class, new Object[]{}, "setInventory", "inventory");
    }

    @DisplayName("Тест, что метод getName в классе Profile возвращает имя персонажа")
    @Test
    void testGetName() {
        testGetter("getName", "setName", "test");
    }

    @DisplayName("Тест, что метод getStrength в классе Profile возвращает силу персонажа")
    @Test
    void testGetStrength() {
        testGetter("getStrength", "setStrength", 8);
    }

    @DisplayName("Тест, что метод getAgility в классе Profile возвращает ловкость персонажа")
    @Test
    void testGetAgility() {
        testGetter("getAgility", "setAgility", 8);
    }

    @DisplayName("Тест, что метод getIntelligence в классе Profile возвращает интеллект персонажа")
    @Test
    void testGetIntelligence() {
        testGetter("getIntelligence", "setIntelligence", 8);
    }

    @DisplayName("Тест, что метод getHp в классе Profile возвращает здоровье персонажа")
    @Test
    void testGetHp() {
        testGetter("getHp", "setHp", 8);
    }

    @DisplayName("Тест, что метод getMana в классе Profile возвращает ману персонажа")
    @Test
    void testGetMana() {
        testGetter("getMana", "setMana", 8);
    }

    @DisplayName("Тест, что метод getStamina в классе Profile возвращает выносливость персонажа")
    @Test
    void testGetStamina() {
        testGetter("getStamina", "setStamina", 8);
    }

    @DisplayName("Тест, что метод getLevel в классе Profile возвращает уровень персонажа")
    @Test
    void testGetLevel() {
        testGetter("getLevel", "setLevel", 8);
    }

    @DisplayName("Тест, что метод getExperience в классе Profile возвращает опыт персонажа")
    @Test
    void testGetExperience() {
        testGetter("getExperience", "setExperience", 8);
    }

    @DisplayName("Тест, что метод getPhysicalDefence в классе Profile возвращает физическую защиту персонажа")
    @Test
    void testGetPhysicalDefence() {
        testGetter("getPhysicalDefence", "setPhysicalDefence", 8);
    }

    @DisplayName("Тест, что метод getMagicDefence в классе Profile возвращает магическую защиту персонажа")
    @Test
    void testGetMagicDefence() {
        testGetter("getMagicDefence", "setMagicDefence", 8);
    }
}
