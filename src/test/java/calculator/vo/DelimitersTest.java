package calculator.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DelimitersTest {

    @DisplayName("커스텀 구분자 없을 때")
    @Test
    void noCustomDelimiter() {
        // given
        String inputString = "1,2:3";
        Delimiters delimiters = new Delimiters(inputString);

        // then
        assertThat(delimiters.toRegexString()).isEqualTo(",|:");
    }

    @DisplayName("커스텀 구분자 있을 때")
    @Test
    void haveCustomDelimiter() {
        // given
        String inputString = "//;\n1;2;3";
        Delimiters delimiters = new Delimiters(inputString);

        // then
        assertThat(delimiters.toRegexString()).isEqualTo(",|:|;");
    }
}