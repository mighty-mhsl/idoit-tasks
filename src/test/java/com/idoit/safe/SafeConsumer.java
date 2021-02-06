package com.idoit.safe;

@FunctionalInterface
public interface SafeConsumer<T> {
    void consume(T arg) throws ClassNotFoundException;
}
