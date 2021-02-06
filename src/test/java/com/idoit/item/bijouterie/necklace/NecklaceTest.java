package com.idoit.item.bijouterie.necklace;

import com.idoit.AbstractTest;
import com.idoit.meta.item.bijouterie.necklace.NecklaceMeta;

abstract class NecklaceTest extends AbstractTest {

    void testNecklaceIsInPackage(String className) {
        testClassIsInPackage(className);
    }

    @Override
    protected String getPackageName() {
        return NecklaceMeta.PACKAGE_NAME;
    }
}
