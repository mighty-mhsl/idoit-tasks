package com.idoit.character.npc.seller;

import com.idoit.meta.character.npc.seller.BlacksmithMeta;
import com.idoit.meta.item.weapon.StaffMeta;
import com.idoit.meta.item.weapon.SwordMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Blacksmith")
class BlacksmithTest extends SellerTest {

    @BeforeEach
	void setUp() {
        setMeta(BlacksmithMeta.class);
    }

    @DisplayName("Тест, что класс Blacksmith находится в пакете com.idoit.character.npc.seller")
    @Test
    void testBlacksmithIsInNpcPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Blacksmith имеет все необходимые поля")
    @Test
    void testBlacksmithHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе Blacksmith есть конструктор принимающий название и уровень нпс")
    @Test
    void testBlacksmithHasConstructorWithNameAndBothDefenceParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields("test", 3);
    }

    @DisplayName("Тест, что в классе Blacksmith есть все необходимые методы")
    @Test
    void testBlacksmithHasAllMethods() {
        testClassHasAllMethods();
    }

    @DisplayName("Тест, что метод fix в классе Blacksmith восстанавливает прочность мечей до 100")
    @Test
    void testFixIncreasesSwordDurability() {
        testFix(SwordMeta.class, (swordMeta) -> swordMeta.instantiateObjectWithConstructor("sword", 10));
    }

    @DisplayName("Тест, что метод fix в классе Blacksmith восстанавливает прочность посохов до 100")
    @Test
    void testFixIncreasesStaffDurability() {
        testFix(StaffMeta.class, (staffMeta) -> staffMeta.instantiateObjectWithConstructor("staff", 10));
    }
}
