package com.idoit.safe;

@FunctionalInterface
public interface SafeFunction<T, U> {

    U apply(T arg) throws Exception;
}
