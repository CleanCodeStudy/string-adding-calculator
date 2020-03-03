package calculator;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SplitterTest {

    @Ignore
    @DisplayName("일반적인 식 입력시 분리된 숫자 List가 반환")
    @Test
    void name() {
        String expression = "1,2:3,4";
        List<Number> numbers = Splitter.getSplittedNumbers(expression);
        assertThat(numbers.size()).isEqualTo(4);
    }

    @Ignore
    @DisplayName("커스텀 구분자로 입력시 분리된 숫자 List가 반환")
    @Test
    void name1() {
        String expression = "///\n1/2/3/6";
        List<Number> numbers = Splitter.getSplittedNumbers(expression);
        assertThat(numbers.size()).isEqualTo(4);
    }
}