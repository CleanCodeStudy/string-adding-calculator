package calculator.extractor;

import calculator.Delimiters;
import calculator.NumberString;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumbersExtractor {

    public static List<Integer> extract(String inputString) {
        Delimiters delimiters = new Delimiters(inputString);
        NumberString numberString = new NumberString(inputString);

        String delimiterRegex = delimiters.toRegexString();
        return Arrays.stream(numberString.getValue().split(delimiterRegex))
                .mapToInt(Integer::valueOf)
                .boxed()
                .collect(Collectors.toList());
    }
}
