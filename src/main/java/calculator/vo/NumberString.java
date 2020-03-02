package calculator.vo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberString {

    public static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    public static final String VALID_NUMBER_STRING_REGEX = "([0-9]([,:][0-9])*)?";

    private final String value;

    public NumberString(String inputString) {
        Pattern customDelimiterPattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);
        Matcher matcher = customDelimiterPattern.matcher(inputString);
        if (matcher.find()) {
            String numberString = matcher.group(2);
            value = numberString;
            return;
        }
        validateString(inputString);
        value = inputString;
    }

    public String getValue() {
        return value;
    }

    private void validateString(String string) {
        Pattern customDelimiterPattern = Pattern.compile(VALID_NUMBER_STRING_REGEX);
        Matcher matcher = customDelimiterPattern.matcher(string);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("invalid string");
        }
    }

}
