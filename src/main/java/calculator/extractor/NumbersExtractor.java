package calculator.extractor;

import java.util.List;

public class NumbersExtractor {

    public static List<Integer> extract(String inputString) {

        Delimeters delimeters = new Delimeters(inputString);

        String numberString = "1,2:3";

        return numberString.split(delimeters.toRegexString());
    }
}
