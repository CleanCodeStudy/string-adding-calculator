package service;

import com.sun.nio.sctp.IllegalReceiveException;
import domain.Calculator;
import support.Splitter;

import java.util.List;

public class CalculatorService {

    private final Calculator calculator;

    public CalculatorService(Calculator calculator) {
        this.calculator = calculator;
    }

    public double calculate(final String formula) {
        List<String> splitedFormula = Splitter.split(formula.trim());

        return calculator.calculate(splitedFormula);
    }

}
