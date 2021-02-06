package com.idoit.skill;

import com.idoit.AbstractTest;
import com.idoit.meta.skill.HealMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Heal")
class HealTest extends AbstractTest {

    @BeforeEach
    void setUp() {
        setMeta(new HealMeta());
    }

    @DisplayName("Тест, что класс Heal находится в пакете com.idoit.skill")
    @Test
    void testHealIsInSkillPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Heal имеет все необходимые поля")
    @Test
    void testHealHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе Heal есть конструктор принимающий название, количетсво расходуемой маны и минимальный уровень навыка")
    @Test
    void testHealHasConstructorWithNameAndManaAndMinLevelParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields(new Object[]{"test", 20, 5});
    }
}
