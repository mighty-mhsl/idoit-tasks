package com.idoit.character.npc.seller;

import com.idoit.AbstractTest;
import com.idoit.meta.character.npc.seller.LibrarianMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Librarian")
class LibrarianTest extends AbstractTest {

    @BeforeEach
	void setUp() {
        setMeta(LibrarianMeta.class);
    }

    @DisplayName("Тест, что класс Librarian находится в пакете com.idoit.character.npc.seller")
    @Test
    void testLibrarianIsInNpcPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Librarian имеет все необходимые поля")
    @Test
    void testLibrarianHasAllFields() {
        testClassHasFields();
    }

    @DisplayName("Тест, что в классе Librarian есть конструктор принимающий название и уровень нпс")
    @Test
    void testLibrarianHasConstructorWithNameAndBothDefenceParams() {
        testClassHasConstructors();
        testConstructorSetsValueToFields("test", 3);
    }
}
