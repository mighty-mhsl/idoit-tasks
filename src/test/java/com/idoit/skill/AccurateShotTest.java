package com.idoit.skill;

import com.idoit.meta.skill.AccurateShotMeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе AccurateShot")
class AccurateShotTest extends SkillTest {

    @DisplayName("Тест, что класс AccurateShot находится в пакете com.idoit.skill")
    @Test
    void testAccurateShotIsInSkillPackage() {
        testSkillIsInPackage(AccurateShotMeta.CLASS_NAME);
    }
}
