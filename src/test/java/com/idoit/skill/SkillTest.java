package com.idoit.skill;

import com.idoit.AbstractTest;
import com.idoit.meta.skill.SkillMeta;

abstract class SkillTest extends AbstractTest {

    void testSkillIsInPackage(String className) {
        testClassIsInPackage(className);
    }

    @Override
    protected String getPackageName() {
        return SkillMeta.PACKAGE_NAME;
    }
}
