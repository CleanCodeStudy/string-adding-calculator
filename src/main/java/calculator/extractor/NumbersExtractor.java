package calculator.extractor;

import calculator.vo.Delimiters;
import calculator.vo.NumberString;

import java.util.List;
import java.util.stream.Collectors;

public class NumbersExtractor {

    public static List<Integer> extract(String inputString) {
        Delimiters delimiters = new Delimiters(inputString);
        NumberString numberString = new NumberString(inputString);

        return numberString.getSplitStringNumbers(delimiters).stream()
                .mapToInt(Integer::valueOf)
                .boxed()
                .collect(Collectors.toList());
    }
}
