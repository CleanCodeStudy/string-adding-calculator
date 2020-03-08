package calculator.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberStringTest {

    @DisplayName("커스텀 구분자 없을 때 분리된 문자열 숫자 가져오기")
    @Test
    void noCustomDelimiter() {
        // given
        String inputString = "1,2:3";
        NumberString numberString = new NumberString(inputString);
        Delimiters delimiters = new Delimiters(inputString);

        // then
        assertThat(numberString.getSplitStringNumbers(delimiters)).isEqualTo(Arrays.asList("1", "2", "3"));
    }

    @DisplayName("유효하지 않은 문자열에 커스텀 구분자 없을 때 에러처리")
    @Test
    void invalidateStringWithoutCustomDelimiter() {
        // given
        String inputString = "/1,2:3";

        // then
        assertThatThrownBy(() -> new NumberString(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("invalid string");
    }

    @DisplayName("커스텀 구분자 있을 때 분리된 문자열 숫자 가져오기")
    @Test
    void haveCustomDelimiter() {
        // given
        String inputString = "//;\n1;2;3";
        NumberString numberString = new NumberString(inputString);
        Delimiters delimiters = new Delimiters(inputString);

        // then
        assertThat(numberString.getSplitStringNumbers(delimiters)).isEqualTo(Arrays.asList("1", "2", "3"));
    }

    @DisplayName("유효하지 않은 문자열에 커스텀 구분자 있을 때 에러처리")
    @Test
    void invalidateStringWithCustomDelimiter() {
        // given
        String inputString = "/;\n1;2;3";

        // then
        assertThatThrownBy(() -> new NumberString(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("invalid string");
    }

    @DisplayName("공백 검사")
    @Test
    void blankString() {
        // given
        String inputString = "";
        NumberString numberString = new NumberString(inputString);
        Delimiters delimiters = new Delimiters(inputString);

        // then
        assertThat(numberString.getSplitStringNumbers(delimiters)).isEqualTo(Collections.singletonList(""));
    }
}