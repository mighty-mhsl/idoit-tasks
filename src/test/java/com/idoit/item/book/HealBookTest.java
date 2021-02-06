package com.idoit.item.book;

import com.idoit.meta.item.book.HealBookMeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе HealBook")
class HealBookTest extends BookTest {

    @DisplayName("Тест, что класс HealBook находится в пакете com.idoit.item.book")
    @Test
    void testHealBookIsInBookPackage() {
        testBookIsInPackage(HealBookMeta.CLASS_NAME);
    }
}
