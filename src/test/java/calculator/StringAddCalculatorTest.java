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
}
