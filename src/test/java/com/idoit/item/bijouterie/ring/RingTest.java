package com.idoit.item.bijouterie.ring;

import com.idoit.AbstractTest;
import com.idoit.meta.item.bijouterie.ring.RingMeta;

abstract class RingTest extends AbstractTest {

    void testRingIsInPackage(String className) {
        testClassIsInPackage(className);
    }

    @Override
    protected String getPackageName() {
        return RingMeta.PACKAGE_NAME;
    }
}
