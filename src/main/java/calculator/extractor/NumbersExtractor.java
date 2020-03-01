package calculator.extractor;

import calculator.Delimiters;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumbersExtractor {

    public static List<Integer> extract(String inputString) {
        Delimiters delimiters = new Delimiters(inputString);

        String numberString = "1,2:3";
        String delimiterRegex = delimiters.toRegexString();

        return Arrays.stream(numberString.split(delimiterRegex))
                .mapToInt(Integer::valueOf)
                .boxed()
                .collect(Collectors.toList());
    }
}
