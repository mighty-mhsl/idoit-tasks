package com.idoit.item.common.book;

import com.idoit.AbstractTest;
import com.idoit.meta.item.common.book.RageBookMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе RageBook")
class RageBookTest extends AbstractTest {

    @BeforeEach
    void setUp() {
        setMetaSafe(RageBookMeta::new);
    }

    @DisplayName("Тест, что класс RageBook находится в пакете com.idoit.item.common.book")
    @Test
    void testRageBookIsInBookPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс RageBook имеет все необходимые поля")
    @Test
    void testRageBookHasAllFields() {
        testClassHasFields();
    }
}
