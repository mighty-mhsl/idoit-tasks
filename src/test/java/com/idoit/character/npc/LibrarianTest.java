package com.idoit.character.npc;

import com.idoit.AbstractTest;
import com.idoit.meta.character.npc.LibrarianMeta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Librarian")
class LibrarianTest extends AbstractTest {

    @BeforeEach
    void setUp() {
        setMeta(new LibrarianMeta());
    }

    @DisplayName("Тест, что класс Librarian находится в пакете com.idoit.character.npc")
    @Test
    void testLibrarianIsInNpcPackage() {
        testClassIsInPackage();
    }

    @DisplayName("Тест, что класс Librarian имеет все необходимые поля")
    @Test
    void testLibrarianHasAllFields() {
        testClassHasFields();
    }
}
