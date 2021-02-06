package com.idoit.character.npc;

import com.idoit.AbstractTest;
import com.idoit.meta.character.npc.NpcMeta;

abstract class NpcTest extends AbstractTest {

    void testNpcIsInPackage(String className) {
        testClassIsInPackage(className);
    }

    @Override
    protected String getPackageName() {
        return NpcMeta.PACKAGE_NAME;
    }
}
