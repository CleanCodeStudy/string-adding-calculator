package calculator.domain.splitter;

import calculator.domain.Numbers;

import java.util.Arrays;

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

    public Numbers split(String expression) {
        return new Numbers(this.splitStrategy.split(expression));
    }
}
