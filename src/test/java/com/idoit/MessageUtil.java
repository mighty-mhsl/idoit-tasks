package com.idoit;

class MessageUtil {

    private static final String NEXT_LINE = "\r\n";

    static String formatAssertMessagePrint(String expected, String actual) {
        return String.format("\n\nОжидаемый вывод: \n\n%s\n\nВаш вывод: \n\n%s\n\n", expected, actual);
    }

    static String formatAssertMessage(String expected, String actual) {
        return String.format("\n\nОжидается: \n\n%s\n\nУ вас: \n\n%s\n\n", expected, actual);
    }

    static String getExpectedPrint(String... lines) {
        StringBuilder builder = new StringBuilder();
        for (String line : lines) {
            builder.append(line).append(NEXT_LINE);
        }
        return builder.toString().trim();
    }
}
