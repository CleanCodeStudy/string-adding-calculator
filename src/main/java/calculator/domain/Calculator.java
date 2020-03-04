package calculator.domain;

import calculator.domain.splitter.SplitterGroup;

public class Calculator {

    private Calculator() {
    }

    public static int calculate(String expression) {
        if (isEmpty(expression)) {
            return 0;
        }
        SplitterGroup strategyByExpression = SplitterGroup.findStrategyByExpression(expression);
        PositiveNumbers positiveNumbers = strategyByExpression.split(expression);

        return positiveNumbers.sum();
    }

    private static boolean isEmpty(String expression) {
        return expression == null || expression.trim().isEmpty();
    }
}
