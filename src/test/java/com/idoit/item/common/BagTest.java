package com.idoit.item.common;

import com.idoit.AbstractTest;
import com.idoit.meta.item.common.BagMeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Bag")
class BagTest extends AbstractTest {

    @DisplayName("Тест, что класс Bag находится в пакете com.idoit.item.common")
    @Test
    void testBagIsInCommonPackage() {
        testClassIsInPackage(BagMeta.CLASS_NAME);
    }

    @Override
    protected String getPackageName() {
        return BagMeta.PACKAGE_NAME;
    }
}
