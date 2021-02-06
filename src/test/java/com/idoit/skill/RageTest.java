package com.idoit.skill;

import com.idoit.meta.skill.RageMeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Rage")
class RageTest extends SkillTest {

    @DisplayName("Тест, что класс Rage находится в пакете com.idoit.skill")
    @Test
    void testRageIsInSkillPackage() {
        testSkillIsInPackage(RageMeta.CLASS_NAME);
    }
}
