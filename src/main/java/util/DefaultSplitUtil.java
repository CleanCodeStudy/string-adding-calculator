package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultSplitUtil implements SplitUtil{


    private static final String[] DEFAULT_DELIMITER = {":", ","};

    public static List<String> split(String text) {

         String splitDelimiter = getSplitDelimiter();
        return Arrays.asList(text.split(splitDelimiter));
    }


    public static String getSplitDelimiter() {

        String splitDelimiter = Arrays.asList(DEFAULT_DELIMITER).stream()
                .collect(Collectors.joining("|"));

        return splitDelimiter;
    }
}
