package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @DisplayName("올바른 수식 덧셈")
    @Test
    void calculate() {
        //given
        List<String> formula = Arrays.asList("1", "2", "3");

        //when
        double result = calculator.calculate(formula);

        //then
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("숫자가 아닌 값이 들어갔을 때 에러를 던져준다")
    @Test
    void calculateThrow() {
        //given
        List<String> formula = Arrays.asList("1", "@", "3");

        //when
        //then
        assertThatThrownBy(() -> calculator.calculate(formula))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("%s 는 Long 형으로 파싱될 수 없습니다.", "@"));
    }

    @DisplayName("음수가 나오면 에러를 던진다")
    @Test
    void negative(){
        List<String> formula = Arrays.asList("1", "-2", "3");

        assertThatThrownBy(() -> calculator.calculate(formula))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
