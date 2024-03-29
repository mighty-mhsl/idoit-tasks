package com.idoit.item.common.book;

import com.idoit.AbstractTest;
import com.idoit.meta.item.common.book.HealBookMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе HealBook")
class HealBookTest extends AbstractTest {

    @BeforeEach
	void setUp() {
        setMeta(HealBookMeta.class);
    }

    @DisplayName("Тест, что класс HealBook находится в пакете com.idoit.item.common.book")
    @Test
    void testHealBookIsInBookPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс HealBook имеет все необходимые поля")
    @Test
    void testHealBookHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе HealBook есть конструктор принимающий название и минимальный уровень книги")
    @Test
    void testHealBookHasConstructorWithNameAndLevelParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields("test", 5);
    }
}
