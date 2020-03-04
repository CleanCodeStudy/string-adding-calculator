package calculator;

import java.util.List;

public class CalculatorService {

    public int calculate(String expression) {
        List<Number> numbers = Splitter.getSplitNumbers(expression);

        Number result = numbers.stream()
                .reduce(Number::sum)
                .orElseThrow(() -> new ArithmeticException());

        return result.getValue();
    }
}
