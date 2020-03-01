package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberString {

    public static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

    private final String value;

    public NumberString(String inputString) {
        Pattern customDelimiterPattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);
        Matcher matcher = customDelimiterPattern.matcher(inputString);
        if (matcher.find()) {
            String numberString = matcher.group(2);
            value = numberString;
            return;
        }
        value = inputString;
    }

    public String getValue() {
        return value;
    }
}
