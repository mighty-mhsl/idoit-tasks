package com.idoit.item.bijouterie.belt;

import com.idoit.AbstractTest;
import com.idoit.meta.item.bijouterie.belt.BeltMeta;

abstract class BeltTest extends AbstractTest {

    void testBeltIsInPackage(String className) {
        testClassIsInPackage(className);
    }

    @Override
    protected String getPackageName() {
        return BeltMeta.PACKAGE_NAME;
    }
}
