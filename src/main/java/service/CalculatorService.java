package service;

import domain.Calculator;
import support.Splitter;

import java.util.List;

public class CalculatorService {
    private final Calculator calculator;

    public CalculatorService(Calculator calculator) {
        this.calculator = calculator;
    }

    public long calculate(final String formula) {
        if (isNullOrEmpty(formula)) {
            return 0;
        }
        List<String> splitedFormula = Splitter.split(formula.trim());

        return calculator.calculate(splitedFormula);
    }

    private boolean isNullOrEmpty(String formula) {
        return formula == null || formula.isEmpty();
    }

}
