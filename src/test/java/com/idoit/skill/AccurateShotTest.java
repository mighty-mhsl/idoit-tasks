package com.idoit.skill;

import com.idoit.AbstractTest;
import com.idoit.meta.skill.AccurateShotMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе AccurateShot")
class AccurateShotTest extends AbstractTest {

    @BeforeEach
    void setUp() {
        setMeta(new AccurateShotMeta());
    }

    @DisplayName("Тест, что класс AccurateShot находится в пакете com.idoit.skill")
    @Test
    void testAccurateShotIsInSkillPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс AccurateShot имеет все необходимые поля")
    @Test
    void testAccurateShotHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе AccurateShot есть конструктор принимающий название, количетсво расходуемой маны и минимальный уровень навыка")
    @Test
    void testAccurateShotHasConstructorWithNameAndManaAndMinLevelParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields(new Object[]{"test", 20, 5});
    }
}
