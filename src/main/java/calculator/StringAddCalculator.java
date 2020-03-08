package calculator;

import calculator.extractor.NumbersExtractor;

import java.util.List;

public class StringAddCalculator {

    public static int calculateWith(String inputString) {
        verifyInputStringNotNull(inputString);
        if (inputString.isEmpty()) {
            return 0;
        }
        List<Integer> numbers = NumbersExtractor.extract(inputString);
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static void verifyInputStringNotNull(String inputString) {
        if (inputString == null) {
            throw new IllegalArgumentException("input string cannot be null");
        }
    }
}
