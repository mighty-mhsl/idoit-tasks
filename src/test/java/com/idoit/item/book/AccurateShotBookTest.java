package com.idoit.item.book;

import com.idoit.meta.item.book.AccurateShotBookMeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе AccurateShotBook")
class AccurateShotBookTest extends BookTest {

    @DisplayName("Тест, что класс AccurateShotBook находится в пакете com.idoit.item.book")
    @Test
    void testAccurateShotBookIsInBookPackage() {
        testBookIsInPackage(AccurateShotBookMeta.CLASS_NAME);
    }
}
