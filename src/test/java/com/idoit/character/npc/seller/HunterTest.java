package com.idoit.character.npc.seller;

import com.idoit.meta.character.npc.seller.HunterMeta;
import com.idoit.meta.item.weapon.BowMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Hunter")
class HunterTest extends SellerTest {

    @BeforeEach
	void setUp() {
        setMeta(HunterMeta.class);
    }

    @DisplayName("Тест, что класс Hunter находится в пакете com.idoit.character.npc.seller")
    @Test
    void testHunterIsInNpcPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Hunter имеет все необходимые поля")
    @Test
    void testHunterHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе Hunter есть конструктор принимающий название и уровень нпс")
    @Test
    void testHunterHasConstructorWithNameAndBothDefenceParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields("test", 3);
    }

    @DisplayName("Тест, что в классе Hunter есть все необходимые методы")
    @Test
    void testHunterHasAllMethods() {
        testClassHasAllMethods();
    }

    @DisplayName("Тест, что метод fix в классе Hunter восстанавливает прочность луков до 100")
    @Test
    void testFixIncreasesSwordDurability() {
        testFix(BowMeta.class, (bowMeta) -> bowMeta.instantiateObjectWithConstructor("bow", 10));
    }
}
