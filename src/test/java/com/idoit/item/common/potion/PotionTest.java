package com.idoit.item.common.potion;

import com.idoit.AbstractTest;
import com.idoit.meta.item.common.potion.PotionMeta;

abstract class PotionTest extends AbstractTest {

    void testPotionIsInPackage(String className) {
        testClassIsInPackage(className);
    }

    @Override
    protected String getPackageName() {
        return PotionMeta.PACKAGE_NAME;
    }
}
