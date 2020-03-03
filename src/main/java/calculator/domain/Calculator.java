package calculator.domain;

import calculator.domain.splitter.SplitterGroup;

public class Calculator {

    public static int calculate(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            return 0;
        }
        SplitterGroup strategyByExpression = SplitterGroup.findStrategyByExpression(expression);
        PositiveNumbers positiveNumbers = strategyByExpression.split(expression);

        return positiveNumbers.sum();
    }
}
