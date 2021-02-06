package com.idoit.safe;

@FunctionalInterface
public interface ClassSafeRunnable {
    void run() throws ClassNotFoundException;
}
