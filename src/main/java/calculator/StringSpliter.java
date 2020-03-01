//package calculator;
//
//import java.rmi.UnexpectedException;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class StringSpliter {
//
//    public static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
//
//    private final Pattern customDelimiterPattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);
//
//    public String getNumberString(String inputString) {
//        validateString(inputString);
//
//    }
//
//    public String getCustomDelimiter(String inputString) {
//        validateString(inputString);
//        Matcher matcher = getCustomDelimiterMatcher(inputString);
//
//        if (matcher.find()) {
//            String customDelimiter = matcher.group(1);
//            return customDelimiter;
//        }
//        throw new ("");
//    }
//
//    private void validateString(String string) {
//        Matcher matcher = getCustomDelimiterMatcher(string);
//        if (!matcher.matches()) {
//            throw new IllegalArgumentException("Invalid string");
//        }
//    }
//
//    private Matcher getCustomDelimiterMatcher(String string) {
//        return customDelimiterPattern.matcher(string);
//    }
//}
