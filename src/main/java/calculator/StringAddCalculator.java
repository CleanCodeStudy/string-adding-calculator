package calculator;

import calculator.extractor.NumbersExtractor;

import java.util.List;

public class StringAddCalculator {

    public static final String BLANK = "";

    public static int calculateWith(String inputString) {
        if (inputString.equals(BLANK)) {
            return 0;
        }
        List<Integer> numbers = NumbersExtractor.extract(inputString);
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
