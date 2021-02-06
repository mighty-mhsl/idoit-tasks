package com.idoit.character;

import com.idoit.AbstractTest;
import com.idoit.meta.character.CharacterMeta;

abstract class CharacterTest extends AbstractTest {

    void testCharacterInPackage(String className) {
        testClassIsInPackage(className);
    }

    @Override
    protected String getPackageName() {
        return CharacterMeta.PACKAGE_NAME;
    }
}
