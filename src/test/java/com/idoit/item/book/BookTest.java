package com.idoit.item.book;

import com.idoit.AbstractTest;
import com.idoit.meta.item.book.BookMeta;

abstract class BookTest extends AbstractTest {

    void testBookIsInPackage(String className) {
        testClassIsInPackage(className);
    }

    @Override
    protected String getPackageName() {
        return BookMeta.PACKAGE_NAME;
    }
}
