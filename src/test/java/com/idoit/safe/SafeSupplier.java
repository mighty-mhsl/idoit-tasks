package com.idoit.safe;

@FunctionalInterface
public interface SafeSupplier<T> {
    T supply() throws ClassNotFoundException;
}
