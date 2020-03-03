package calculator.domain.splitter;

import java.util.Arrays;
import java.util.List;

public enum SplitterGroup {
    CUSTOM(new CustomSplitStrategy()),
    DEFAULT(new DefaultSplitStrategy());

    private final SplitStrategy splitStrategy;

    SplitterGroup(SplitStrategy splitStrategy) {
        this.splitStrategy = splitStrategy;
    }

    public static SplitterGroup findStrategyByExpression(String expression) {
        return Arrays.stream(values())
                .filter(aSplitter -> aSplitter.splitStrategy.support(expression))
                .findFirst()
                .orElseThrow(AssertionError::new);
    }

    public List<String> split(String expression) {
        return this.splitStrategy.split(expression);
    }
}
