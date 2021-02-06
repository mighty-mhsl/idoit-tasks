package com.idoit.item.weapon;

import com.idoit.AbstractTest;
import com.idoit.meta.item.weapon.WeaponMeta;

abstract class WeaponTest extends AbstractTest {

    void testWeaponIsInPackage(String className) {
        testClassIsInPackage(className);
    }

    @Override
    protected String getPackageName() {
        return WeaponMeta.PACKAGE_NAME;
    }
}
