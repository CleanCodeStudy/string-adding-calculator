package org.ccstudy.team2.exception;

public class NotIntegerException extends RuntimeException{
    public NotIntegerException(){
        super("올바른 숫자가 아닙니다.");
    }
}
