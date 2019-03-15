package util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSplitUtil implements SplitUtil{

    // custom 규칙이 여러개가 될 수 있을 것 같은데?!
    // custom이 쌓일 수록!
    // custom util이

    private static final int DELIMITER_INDEX = 1;
    private static final int OPERAND_INDEX = 2;


    public static List<String> split(String text) {
        Matcher matcher  = Pattern.compile(MATCHER).matcher(text);
        matcher.find();
        String customDelimiter =  matcher.group(DELIMITER_INDEX);
        return Arrays.asList(matcher.group(OPERAND_INDEX).split(customDelimiter));
    }
}
