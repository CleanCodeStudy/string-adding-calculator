package service;

import domain.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class CalculatorServiceTest {

    CalculatorService calculatorService = new CalculatorService(new Calculator());

    @DisplayName("올바른 수식 계산 테스트")
    @MethodSource("validFormula")
    @ParameterizedTest
    void invalidFormula(String formula, long expectedValue){
        assertThat(calculatorService.calculate(formula)).isEqualTo(expectedValue);
    }

    static Stream<Arguments> validFormula() {
        return Stream.of(
                Arguments.of("//o₩n1o2o3", 6l),
                Arguments.of("//abc₩n1abc2abc3abc", 6l),
                Arguments.of("//@₩n3@1@7@1", 12l),
                Arguments.of("1,2:3", 6l)
        );
    }


    @DisplayName("올바르지 않은 수식 테스트")
    @MethodSource("invalidFormula")
    @ParameterizedTest
    void inValidFormula(String formula){
        assertThatThrownBy(() -> calculatorService.calculate(formula))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> invalidFormula() {
        return Stream.of(
                Arguments.of("//₩n1o2o3"),
                Arguments.of("//abc"),
                Arguments.of("1abc2abc3abc"),
                Arguments.of("//o₩n1*2")
        );
    }

    @DisplayName("구분자가 없는 경우 그대로반환하는지 테스트")
    @MethodSource("formulaWithoutDelimiter")
    @ParameterizedTest
    void formulaWithoutDelimiter(String formula, long expected){
        assertThat(calculatorService.calculate(formula)).isEqualTo(expected);
    }

    static Stream<Arguments> formulaWithoutDelimiter() {
        return Stream.of(
                Arguments.of("//;₩n123", 123l),
                Arguments.of("12345", 12345l)
        );
    }


}
