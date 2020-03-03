package calculator.domain.splitter;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DefaultSplitStrategy implements SplitStrategy {
    private static final Pattern DEFAULT_PATTERN = Pattern.compile("(.*)");
    private static final String COMMA_AND_SEMICOLON = "[,|:]";

    @Override
    public boolean support(String expression) {
        return DEFAULT_PATTERN.matcher(expression)
                .find();
    }

    @Override
    public List<String> split(String expression) {
        Matcher matcher = DEFAULT_PATTERN.matcher(expression);
        matcher.find();
        String target = matcher.group(0);
        return Arrays.stream(target.split(COMMA_AND_SEMICOLON))
                .collect(Collectors.toList());
    }
}
