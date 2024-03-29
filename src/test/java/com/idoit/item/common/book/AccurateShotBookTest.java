package com.idoit.item.common.book;

import com.idoit.AbstractTest;
import com.idoit.meta.item.common.book.AccurateShotBookMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе AccurateShotBook")
class AccurateShotBookTest extends AbstractTest {

    @BeforeEach
	void setUp() {
        setMeta(AccurateShotBookMeta.class);
    }

    @DisplayName("Тест, что класс AccurateShotBook находится в пакете com.idoit.item.common.book")
    @Test
    void testAccurateShotBookIsInBookPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс AccurateShotBook имеет все необходимые поля")
    @Test
    void testAccurateShotBookHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе AccurateShotBook есть конструктор принимающий название и минимальный уровень книги")
    @Test
    void testAccurateShotBookHasConstructorWithNameAndLevelParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields("test", 5);
    }
}
