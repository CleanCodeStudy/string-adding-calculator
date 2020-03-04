package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class NumberTest {
    @DisplayName("빈 문자열 또는 null일시 RuntimeException Throw")
    @ParameterizedTest
    @NullAndEmptySource
    void name1(String expression) {
        assertThatThrownBy(() -> new Number(expression))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("빈 문자열 입니다.");
    }

    @DisplayName("음수일시 RuntimeException Throw")
    @Test
    void name() {
        assertThatThrownBy(() -> new Number("-1"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(String.format("음수가 입력되었습니다. : %s ", -1));
    }
}