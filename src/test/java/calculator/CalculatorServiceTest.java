package calculator;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    @DisplayName("기본 구분자로 식 입력시 결과 반환")
    @Test
    void name() {
        String expression = "1,2:3";
        CalculatorService calculatorService = new CalculatorService();
        int result = calculatorService.calculate(expression);
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("커스텀 구분자로 식 입력시 결과 반환")
    @Test
    void name1() {
        String expression = "//h\n1h2h3";
        CalculatorService calculatorService = new CalculatorService();
        int result = calculatorService.calculate(expression);
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("1 입력시 1 반환")
    @Test
    void name4() {
        String expression = "1";
        CalculatorService calculatorService = new CalculatorService();
        int result = calculatorService.calculate(expression);
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("빈 문자열, null 입력시 0")
    @ParameterizedTest
    @NullAndEmptySource
    void name2(String expression) {
        CalculatorService calculatorService = new CalculatorService();
        int result = calculatorService.calculate(expression);
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("음수 값 있을때 RuntimeExcetion Throw")
    @Test
    void name3() {
        String expression = "1,-2:3";
        CalculatorService calculatorService = new CalculatorService();
        assertThatThrownBy(() -> calculatorService.calculate(expression))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(String.format("음수가 입력되었습니다. : %s ", -2));
    }
}