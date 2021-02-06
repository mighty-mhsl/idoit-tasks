package com.idoit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Проверка логики в классе App")
class AppTest {

    @Test
    @DisplayName("В методе main должны быть два вывода на экран: I do it! (строка) и текущий год (число)")
    void testMainPrintsPhraseAndCurrentYear() throws IOException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));

        App.main(new String[]{});
        bo.flush();
        String actualLines = bo.toString().trim();

        String expectedLines = "I do it! " + LocalDateTime.now().getYear();
        String message = MessageUtil.formatAssertMessage(expectedLines, actualLines);
        assertEquals(expectedLines, actualLines, message);
    }
}
