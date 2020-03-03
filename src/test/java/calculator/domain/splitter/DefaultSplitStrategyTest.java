package calculator.domain.splitter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultSplitStrategyTest {

    @DisplayName("기본전략은 모든 식을 수용한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "1,2:3",
            "1",
            "1 2"}, delimiter = '|')
    void support(String expression) {
        //given
        DefaultSplitStrategy defaultSplitStrategy = new DefaultSplitStrategy();

        //then
        assertThat(defaultSplitStrategy.support(expression)).isTrue();
    }

    @DisplayName("기본전략은 연산자로 ,와 ;를 이용한여 식을 분리한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3",
            "1:2:3",
            "1,2:3",
    }, delimiter = '|')
    void split(String expression) {
        //given
        DefaultSplitStrategy defaultSplitStrategy = new DefaultSplitStrategy();

        //when
        List<String> split = defaultSplitStrategy.split(expression);

        //then
        assertThat(split).containsExactly("1", "2", "3");
    }

}