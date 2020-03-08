package calculator.vo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiters {

    public static final String BASIC_DELIMITER_REGEX = ",|:";
    public static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

    private String delimiterRegex = BASIC_DELIMITER_REGEX;

    public Delimiters(String inputString) {
        Pattern customDelimiterPattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);
        Matcher matcher = customDelimiterPattern.matcher(inputString);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);

            StringBuilder stringBuilder = new StringBuilder(delimiterRegex)
                    .append("|")
                    .append(customDelimiter);
            delimiterRegex = stringBuilder.toString();
        }
    }

    public String toRegexString() {
        return delimiterRegex;
    }

}
