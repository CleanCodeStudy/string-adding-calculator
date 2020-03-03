package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {
    public static final int COMMA = 0;
    public static final int COLON = 1;

    public static String[] makeNumbers(String inputString) {

        if (isBlankSpace(inputString)) throw new RuntimeException();

        String[] numbers = Splitter.matchExpression(inputString);

        if (!isPositiveNumber(numbers)) throw new RuntimeException();

        return numbers;
    }

    private static String[] matchExpression(String expression) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(expression);

        if (matcher.find()) {
            return splitString(matcher.group(1), matcher.group(2));
        }

        if (!isContains(expression, new String[]{",", ":"})) {
            throw new IllegalArgumentException();
        }

        return splitString(expression, ",|:");
    }

    private static boolean isContains(String expression, String[] separators) {
        if (expression.contains(separators[COMMA])) return true;
        if (expression.contains(separators[COLON])) return true;

        return false;
    }

    private static String[] splitString(String expression, String separator) {
        return expression.split(separator);
    }

    private static boolean isBlankSpace(String inputString) {
        if (inputString == null || inputString.isEmpty() || inputString == " ") {
            return true;
        }
        return false;
    }

    private static boolean isPositiveNumber(String[] numbers) {
        return Arrays.stream(numbers).mapToInt(number -> Integer.parseInt(number)).allMatch(number -> number > 0);
    }
}
