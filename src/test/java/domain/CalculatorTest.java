package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @DisplayName("calculator에 음수가 아닌 숫자가 들어가면 정상적으로 더해서 반환한다.")
    @Test
    void calculate() {
        //given
        List<String> formula = Arrays.asList("1", "2", "3");

        //when
        double result = calculator.calculate(formula);

        //then
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("숫자가 아닌 값이나 음수가 들어가면 Exception이 발생한다")
    @MethodSource("exceptionCase")
    @ParameterizedTest
    void calculateThrow(List<String> formula, String exceptionMessage) {
        //given
        //when
        //then
        assertThatThrownBy(() -> calculator.calculate(formula))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(exceptionMessage);
    }

    static Stream<Arguments> exceptionCase() {
        return Stream.of(
                Arguments.of(Arrays.asList("1", "@", "3"), String.format("%s 는 Long 형으로 파싱될 수 없습니다.", "@")),
                Arguments.of(Arrays.asList("1", "-2", "3"), String.format("음수인 %d 값은 들어올 수 없습니다", -2))
        );
    }

}
