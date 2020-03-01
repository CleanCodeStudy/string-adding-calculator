package calculator;

import calculator.extractor.NumbersExtractor;

import java.util.List;

public class StringAddCalculator {

    public static int calculateWith(String inputString) {
        List<Integer> numbers = NumbersExtractor.extract(inputString);
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
