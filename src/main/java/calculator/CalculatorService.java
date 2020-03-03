package calculator;

import java.util.List;

public class CalculatorService {

    public int calculate(String expression) {
        List<Number> numbers = Splitter.getSplitNumbers(expression);

        return numbers.stream()
                .mapToInt(Number::getValue)
                .sum();
    }
}
