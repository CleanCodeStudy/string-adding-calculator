package util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSplitUtil implements SplitUtil{
    private static final int DELIMITER_INDEX = 1;
    private static final int OPERAND_INDEX = 2;


    public static List<String> split(String text) {
        Matcher matcher  = Pattern.compile(DEFAULT_MATCHER).matcher(text);
        matcher.find();
        String customDelimiter =  matcher.group(DELIMITER_INDEX);
        return Arrays.asList(matcher.group(OPERAND_INDEX).split(customDelimiter));
    }
}
