package org.ccstudy;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorServiceTest {
    @Test
    public void 더하기테스트() {
        Integer expect = 6;
        CalculatorService calculatorService = new CalculatorService();
        assertEquals(calculatorService.sum("1:3,2"),expect);
    }

}