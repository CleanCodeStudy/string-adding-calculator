package support;

import java.util.Arrays;
import java.util.List;


public class Splitter {

    private final static String DEFAULT_DELIMITER_REGEX = "[,:]";

    private final static String CUSTOM_DELIMITER_START_FORMAT = "//";
    private final static String CUSTOM_DELIMITER_END_FORMAT = "₩n";

    public static List<String> split(final String formula) {
        if (notExistCustomDelimiter(formula)) {
            return Arrays.asList(formula.split(DEFAULT_DELIMITER_REGEX));
        }

        String customDelimiter = DelimiterExtractor.extract(formula);
        String realFormula = formula.substring(formula.indexOf(CUSTOM_DELIMITER_END_FORMAT) + CUSTOM_DELIMITER_END_FORMAT.length());

        return Arrays.asList(realFormula.split(customDelimiter));
    }

    private static boolean notExistCustomDelimiter(final String maybeCustomDelimiter) {
        return !maybeCustomDelimiter.startsWith(CUSTOM_DELIMITER_START_FORMAT);
    }

    private static class DelimiterExtractor {

        private static String extract(final String maybeDelimiter) {
            int endDelimiterIndex = maybeDelimiter.indexOf(CUSTOM_DELIMITER_END_FORMAT);

            if (endDelimiterIndex < 0) {
                throw new IllegalArgumentException(String.format("%s는 올바르지 않은 요청 포맷입니다.", maybeDelimiter));
            }

            String customDelimiter = maybeDelimiter.substring(CUSTOM_DELIMITER_START_FORMAT.length(), endDelimiterIndex);

            if (customDelimiter.isEmpty() || isNumeric(customDelimiter)) {
                throw new IllegalArgumentException(String.format("%s는 올바르지 않은 커스텀구분자입니다.", maybeDelimiter));
            }

            return customDelimiter;
        }

        private static boolean isNumeric(final String customDelimiter){
            return customDelimiter.matches("-?\\d+(\\.\\d+)?");
        }

    }
}
