package com.idoit.item.armor;

import com.idoit.AbstractTest;
import com.idoit.meta.item.armor.ArmorMeta;

abstract class ArmorTest extends AbstractTest {

    void testArmorIsInPackage(String className) {
        testClassIsInPackage(className);
    }

    @Override
    protected String getPackageName() {
        return ArmorMeta.PACKAGE_NAME;
    }
}
