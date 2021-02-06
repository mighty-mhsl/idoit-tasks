package com.idoit.safe;

@FunctionalInterface
public interface ClassSafeSupplier<T> {
    T supply() throws ClassNotFoundException;
}
