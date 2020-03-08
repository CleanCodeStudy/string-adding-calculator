package calculator.vo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiters {

    public static final String BASIC_DELIMITER_REGEX = ",|:";
    public static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

    public static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);

    private String delimiterRegex = BASIC_DELIMITER_REGEX;

    public Delimiters(String inputString) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(inputString);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            delimiterRegex = createDelimiterRegexWith(customDelimiter);
        }
    }

    public String toRegexString() {
        return delimiterRegex;
    }

    private String createDelimiterRegexWith(String customDelimiter) {
        return new StringBuilder(delimiterRegex)
                .append("|")
                .append(customDelimiter)
                .toString();
    }

}
