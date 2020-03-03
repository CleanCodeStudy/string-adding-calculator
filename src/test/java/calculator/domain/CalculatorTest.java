package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    private static Stream<Arguments> expressionProvider() {
        return Stream.of(
                Arguments.of("1,2:3", 6),
                Arguments.of("//#\n1#4#10", 15),
                Arguments.of("1", 1)
        );
    }

    @DisplayName("null 또는 공백을 입력할 경우 0을 반환")
    @ParameterizedTest
    @NullAndEmptySource
    void calculateNullAndEmpty(String expression) {
        int expect = Calculator.calculate(expression);

        assertThat(expect).isEqualTo(0);
    }

    @DisplayName("입력식에 따른 결과 반환")
    @ParameterizedTest
    @MethodSource("expressionProvider")
    void calculate(String expression, int result) {
        int expect = Calculator.calculate(expression);

        assertThat(expect).isEqualTo(result);
    }
}