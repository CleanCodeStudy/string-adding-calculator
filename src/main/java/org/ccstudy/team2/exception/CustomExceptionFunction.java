package org.ccstudy.team2.exception;

public interface CustomExceptionFunction<T,R> {
    R apply(T r) throws RuntimeException;
}

