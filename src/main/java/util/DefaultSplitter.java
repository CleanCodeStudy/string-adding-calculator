package util;

import java.util.Arrays;
import java.util.List;

public class DefaultSplitter extends Splitter {
    public static final String DELIMITER_TOKEN = "(.*)";
    private static final String TOKENS = ",|:";

    public DefaultSplitter() {
        super.delimiterToken = DELIMITER_TOKEN;
    }

    @Override
    public List<String> split() {
        return Arrays.asList(matcher.group().split(TOKENS));
    }
}
