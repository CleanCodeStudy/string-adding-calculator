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

        if (splitedFormula.size() <= 0) {
            throw new IllegalReceiveException(String.format("%s 는 계산할 수 없는 수식입니다. Delimiter를 체크해주세요", formula));
        }

        return calculator.calculate(splitedFormula);
    }

}
