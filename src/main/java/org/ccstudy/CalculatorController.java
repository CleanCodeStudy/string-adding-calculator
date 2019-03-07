package org.ccstudy;

public class CalculatorController {
    public void calculate(){
        CalculatorService calculatorService = new CalculatorService();

        String source = Input.source();

        Integer sum = calculatorService.sum(source);

        System.out.println(sum);
    }
}
