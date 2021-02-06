package com.idoit.safe;

import static org.junit.jupiter.api.Assertions.fail;

public class Safer {

    public static void runClassSafe(ClassSafeRunnable runnable) {
        try {
            runnable.run();
        } catch (ClassNotFoundException e) {
            fail("Не найдены все требуемые классы для полей класса для выполнения данного теста", e);
        }
    }

    public static void runSafe(SafeRunnable runnable) {
        try {
            runnable.run();
        } catch (ClassNotFoundException e) {
            fail("Не найдены все требуемые классы для полей класса для выполнения данного теста", e);
        } catch (NoSuchMethodException e) {
            fail("Не найден требуемый метод класса для выполнения данного теста", e);
        } catch (NoSuchFieldException e) {
            fail("Не найдено требуемое поле класса для выполнения данного теста", e);
        } catch (Exception e) {
            fail("Ошибка при выполнении теста", e);
        }
    }

    public static Object runSafe(SafeSupplier<Object> safeSupplier) {
        try {
            return safeSupplier.supply();
        } catch (ClassNotFoundException e) {
            fail("Не найдены все требуемые классы для полей класса для выполнения данного теста", e);
        } catch (NoSuchMethodException e) {
            fail("Не найден требуемый метод класса для выполнения данного теста", e);
        } catch (NoSuchFieldException e) {
            fail("Не найдено требуемое поле класса для выполнения данного теста", e);
        } catch (Exception e) {
            fail("Ошибка при выполнении теста", e);
        }
        return null;
    }
}
