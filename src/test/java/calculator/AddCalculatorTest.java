package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AddCalculatorTest {

    @Test
    void calculate() {
        assertThat(AddCalculator.calculate(new String[]{"1","2","3"})).isEqualTo(6);
    }
}