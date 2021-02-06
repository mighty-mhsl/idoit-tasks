package com.idoit.character.npc.seller;

import com.idoit.AbstractTest;
import com.idoit.meta.MetaContext;
import com.idoit.meta.character.npc.seller.HunterMeta;
import com.idoit.meta.item.weapon.BowMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты логики в классе Hunter")
class HunterTest extends AbstractTest {

    private HunterMeta.HunterLook seller;

    @BeforeEach
	void setUp() {
        setMeta(HunterMeta.class);
        HunterMeta meta = (HunterMeta) getMeta();
        seller = meta.getLook();
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
    void testFixIncreasesBowDurability() {
        int expectedDurability = 100;
        BowMeta weapon = (BowMeta) MetaContext.getMeta(BowMeta.class);
        weapon.getLook().setDurability(99);

        seller.fix(weapon);

        int actualDurability = weapon.getLook().getDurability();
        String message = getFieldValueAssert(weapon.getClassName(), "fix", "durability", expectedDurability, actualDurability);
        assertEquals(expectedDurability, actualDurability, message);
    }
}
