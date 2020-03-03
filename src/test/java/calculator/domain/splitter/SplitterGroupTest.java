package calculator.domain.splitter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static calculator.domain.splitter.SplitterGroup.CUSTOM;
import static calculator.domain.splitter.SplitterGroup.DEFAULT;
import static org.assertj.core.api.Assertions.assertThat;

class SplitterGroupTest {

    private static Stream<Arguments> expressionProvider() {
        return Stream.of(
                Arguments.of("//#\n1#2#3", CUSTOM),
                Arguments.of("1,2,3", DEFAULT)
        );
    }

    @DisplayName("입력식이 커스텀 구분자를 가지고 있으면 커스텀전략을 아니면 기본전략을 반환한다.")
    @ParameterizedTest
    @MethodSource("expressionProvider")
    void findStrategyByExpression(String expression, SplitterGroup result) {
        SplitterGroup strategyByExpression = SplitterGroup.findStrategyByExpression(expression);

        assertThat(strategyByExpression).isEqualTo(result);
    }

    @DisplayName("해당하는 전략이 식을 분리한다.")
    @ParameterizedTest
    @MethodSource("expressionProvider")
    void split(String expression, SplitterGroup splitterGroup) {
        List<String> expect = splitterGroup.split(expression);

        assertThat(expect).containsExactly("1", "2", "3");
    }
}