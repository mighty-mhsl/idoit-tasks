package com.idoit.skill;

import com.idoit.meta.skill.HealMeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Heal")
class HealTest extends SkillTest {

    @DisplayName("Тест, что класс Heal находится в пакете com.idoit.skill")
    @Test
    void testHealIsInSkillPackage() {
        testSkillIsInPackage(HealMeta.CLASS_NAME);
    }
}
