package org.ccstudy.team2.exception;

public class NegativeValueException extends RuntimeException{
    public NegativeValueException(){
        super("음수입니다.");
    }
}
