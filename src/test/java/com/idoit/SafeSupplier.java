package com.idoit;

@FunctionalInterface
public interface SafeSupplier<T> {
    T supply() throws ClassNotFoundException;
}
