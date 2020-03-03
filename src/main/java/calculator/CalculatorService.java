package calculator;

import java.util.List;

public class CalculatorService {

    public int calculate(String expression) {
        List<Number> numbers = Splitter.getSplittedNumbers(expression);

        return numbers.stream()
                .mapToInt(Number::getValue)
                .sum();
    }
}
