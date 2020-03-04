package service;

import domain.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class CalculatorServiceTest {

    CalculatorService calculatorService = new CalculatorService(new Calculator());

    @DisplayName(",과 : 로 구분하거나 커스텀 구분자를 설정한 정상계산 테스트")
    @MethodSource("validFormula")
    @ParameterizedTest
    void validFormula(String formula, long expectedValue) {
        assertThat(calculatorService.calculate(formula)).isEqualTo(expectedValue);
    }

    static Stream<Arguments> validFormula() {
        return Stream.of(
                Arguments.of("//o₩n1o2o3", 6L),
                Arguments.of("//abc₩n1abc2abc3abc", 6L),
                Arguments.of("//@₩n3@1@7@1", 12L),
                Arguments.of("1,2:3", 6L)
        );
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @Test
    void formulaWithoutDelimiter() {
        String formula = "12345";

        assertThat(calculatorService.calculate(formula)).isEqualTo(Long.parseLong(formula));
    }

    @DisplayName("올바르지 않은 수식 테스트")
    @MethodSource("invalidFormula")
    @ParameterizedTest
    void inValidFormula(String formula, String exceptionMessage) {
        assertThatThrownBy(() -> calculatorService.calculate(formula))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(exceptionMessage);
    }

    static Stream<Arguments> invalidFormula() {
        return Stream.of(
                Arguments.of("//₩n1o2o3", " 는(은) 올바르지 않은 커스텀구분자입니다."),
                Arguments.of("//abc", "//abc 는 Long 형으로 파싱될 수 없습니다."),
                Arguments.of("1abc2abc3abc", "1abc2abc3abc 는 Long 형으로 파싱될 수 없습니다."),
                Arguments.of("//o₩n1*2", "1*2 는 Long 형으로 파싱될 수 없습니다.")
        );
    }

    @DisplayName("빈 문자열 또는 null 값이 들어가면 0 을 반환해야 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void emptyNull(String formula) {
        assertThat(calculatorService.calculate((formula))).isEqualTo(0);
    }

}
