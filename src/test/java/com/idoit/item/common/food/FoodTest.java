package com.idoit.item.common.food;

import com.idoit.AbstractTest;
import com.idoit.meta.item.common.food.FoodMeta;

abstract class FoodTest extends AbstractTest {

    void testFoodIsInPackage(String className) {
        testClassIsInPackage(className);
    }

    @Override
    protected String getPackageName() {
        return FoodMeta.PACKAGE_NAME;
    }
}
