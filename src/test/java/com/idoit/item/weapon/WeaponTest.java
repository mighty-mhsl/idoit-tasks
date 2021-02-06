package com.idoit.item.weapon;

import com.idoit.AbstractTest;

abstract class WeaponTest extends AbstractTest {

    void testSetDurability() {
        String methodName = "setDurability";
        String message = getSetterAssertMessage(methodName, int.class.getName(), getMeta().getClassName());
        testSetter(5, methodName, "durability", message, "test", 3);
    }
}
