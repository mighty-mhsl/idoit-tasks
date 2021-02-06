package com.idoit.character.npc;

import com.idoit.meta.character.npc.LibrarianMeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты логики в классе Librarian")
class LibrarianTest extends NpcTest {

    @DisplayName("Тест, что класс Librarian находится в пакете com.idoit.character.npc")
    @Test
    void testLibrarianIsInNpcPackage() {
        testNpcIsInPackage(LibrarianMeta.CLASS_NAME);
    }
}
