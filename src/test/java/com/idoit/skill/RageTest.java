package com.idoit.skill;

import com.idoit.AbstractTest;
import com.idoit.meta.skill.RageMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Rage")
class RageTest extends AbstractTest {

    @BeforeEach
    void setUp() {
        setMeta(new RageMeta());
    }

    @DisplayName("Тест, что класс Rage находится в пакете com.idoit.skill")
    @Test
    void testRageIsInSkillPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Rage имеет все необходимые поля")
    @Test
    void testRageHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе Rage есть конструктор принимающий название, количетсво расходуемой маны и минимальный уровень навыка")
    @Test
    void testRageHasConstructorWithNameAndManaAndMinLevelParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields(new Object[]{"test", 20, 5});
    }
}
