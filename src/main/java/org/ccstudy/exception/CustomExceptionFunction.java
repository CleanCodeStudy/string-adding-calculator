package org.ccstudy.exception;

public interface CustomExceptionFunction<T,R> {
    R apply(T r) throws RuntimeException;
}