package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Splitter {
    private static final String COMMON_DELIMITER = "[,:]";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_NUMBER = "0";
    private static final int DELIMITER_GROUP = 1;
    private static final int FORMULA_GROUP = 2;

    public static List<Number> getSplitNumbers(String expression) {
        if (expression == null || expression.isEmpty()) {
            return commonSplit(DEFAULT_NUMBER);
        }

        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(expression);
        if (matcher.find()) {
            return customSplit(matcher);
        }

        return commonSplit(expression);
    }

    private static List<Number> customSplit(Matcher matcher) {
        String delimiter = matcher.group(DELIMITER_GROUP);
        String formula = matcher.group(FORMULA_GROUP);
        return Arrays.stream(formula.split(delimiter))
                .map(Number::new)
                .collect(Collectors.toList());
    }

    private static List<Number> commonSplit(String expression) {
        return Arrays.stream(expression.split(COMMON_DELIMITER))
                .map(Number::new)
                .collect(Collectors.toList());
    }
}
