package util;

import java.util.Arrays;
import java.util.List;

public class CustomSplitter extends Splitter {
    private static final int DELIMITER_INDEX = 1;
    private static final int OPERAND_INDEX = 2;
    public static final String DELIMITER_TOKEN = "//(.)\n(.*)";

    public CustomSplitter() {
        super.delimiterToken = DELIMITER_TOKEN;
    }

    public List<String> split() {
        String customDelimiter =  matcher.group(DELIMITER_INDEX);
        return Arrays.asList(matcher.group(OPERAND_INDEX).split(customDelimiter));
    }
}
