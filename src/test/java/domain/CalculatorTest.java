package domain;

import domain.Calculator;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void 문자열배열로_positive_리스트_만들기() {
        Calculator calculator = createCalculator("1","2","3");

        //when
        //then
        assertEquals(1, calculator.getPositives().get(0).getNumber());
        assertEquals(2, calculator.getPositives().get(1).getNumber());
        assertEquals(3, calculator.getPositives().get(2).getNumber());

    }

    @Test
    public void positive_리스트_더하기() {
        //given
        //when
        //then
        assertEquals(6, createCalculator("1","2","3").getResult());
    }

    private Calculator createCalculator(String... tokens){
        return  new Calculator(Arrays.asList(tokens));
    }
}