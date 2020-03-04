package calculator.domain.splitter;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CustomSplitStrategy implements SplitStrategy {
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    @Override
    public boolean support(String expression) {
        return CUSTOM_PATTERN.matcher(expression)
                .find();
    }

    @Override
    public List<String> split(String expression) {
        Matcher matcher = CUSTOM_PATTERN.matcher(expression);
        matcher.find();

        String customDelimiter = matcher.group(1);
        String target = matcher.group(2);
        return Arrays.stream(target.split(customDelimiter))
                .collect(Collectors.toList());
    }
}
