package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @DisplayName("유효한 계산식이 잘 계산 되는지 확인")
    @Test
    void calculateTest() {
        // given
        String inputString = "1,2:3";

        // when
        int result = StringAddCalculator.calculateWith(inputString);

        // then
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("커스텀 구분자 계산식이 잘 계산 되는지 확인")
    @Test
    void calculateWithCustomDelimiter() {
        // given
        String inputString = "//;\n1;2;3";

        // when
        int result = StringAddCalculator.calculateWith(inputString);

        // then
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("공백 확인")
    @Test
    void calculateWithBlank() {
        // given
        String inputString = "";

        // when
        int result = StringAddCalculator.calculateWith(inputString);

        // then
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("단일 숫자 확인")
    @Test
    void calculateWithSingleNumber() {
        // given
        String inputString = "6";

        // when
        int result = StringAddCalculator.calculateWith(inputString);

        // then
        assertThat(result).isEqualTo(6);
    }
}
