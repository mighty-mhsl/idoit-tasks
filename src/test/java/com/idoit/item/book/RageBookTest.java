package com.idoit.item.book;

import com.idoit.meta.item.book.RageBookMeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе RageBook")
class RageBookTest extends BookTest {

    @DisplayName("Тест, что класс RageBook находится в пакете com.idoit.item.book")
    @Test
    void testRageBookIsInBookPackage() {
        testBookIsInPackage(RageBookMeta.CLASS_NAME);
    }
}
