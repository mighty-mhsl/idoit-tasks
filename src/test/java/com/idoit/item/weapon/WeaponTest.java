package com.idoit.item.weapon;

import com.idoit.AbstractTest;
import com.idoit.meta.MetaContext;
import com.idoit.meta.item.stone.StoneMeta;
import com.idoit.safe.Safer;

abstract class WeaponTest extends AbstractTest {

    private static final Object[] CONSTRUCTOR_PARAMS = new Object[]{"test", 1};

    void testSetDurability() {
        String methodName = "setDurability";
        String message = getSetterAssertMessage(methodName, int.class.getName(), getMeta().getClassName());
        testSetter(5, methodName, "durability", message, "test", 3);
    }

    void testSetStone(Class<? extends StoneMeta> stoneMetaClass) {
        Safer.runSafe(() -> {
            String methodName = "setStone";
            Object value = MetaContext.getMeta(stoneMetaClass).instantiateObjectWithConstructor();
            String message = getSetterAssertMessage(methodName, value.getClass().getName(), getMeta().getClassName());
            testSetter(value, methodName, "stone", message, CONSTRUCTOR_PARAMS);
        });
    }

    void testGetStone(Class<? extends StoneMeta> stoneMetaClass) {
        Safer.runSafe(() -> {
            Object value = MetaContext.getMeta(stoneMetaClass).instantiateObjectWithConstructor();
            testGetter("getStone", "setStone", value, CONSTRUCTOR_PARAMS);
        });
    }
}
