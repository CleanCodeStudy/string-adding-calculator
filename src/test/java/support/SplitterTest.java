package support;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class SplitterTest {

    @DisplayName("커스텀 구분자가 없을 때 제대로 쪼개지는 지")
    @CsvSource({"'1,2,3'", "'1:2:3'", "'1,2:3'"})
    @ParameterizedTest
    void split(String formula) {
        //given
        //when
        List<String> splitedFormula = Splitter.split(formula);

        //then
        assertThat(splitedFormula).isEqualTo(Arrays.asList(formula.split("[,:]")));
    }


    @DisplayName("커스텀 구분자가 있을 때 제대로 쪼개지는 지")
    @MethodSource("customDelimiterFormat")
    @ParameterizedTest
    void splitByCustomDelimiter(String formula, List<String> expectedValue) {
        //given
        //when
        List<String> splitedFormula = Splitter.split(formula);

        //then
        assertThat(splitedFormula).isEqualTo(expectedValue);
    }

    static Stream<Arguments> customDelimiterFormat() {
        return Stream.of(
                Arguments.of("//o₩n1o2o3", Arrays.asList("1", "2", "3")),
                Arguments.of("//abc₩n1abc2abc3abc", Arrays.asList("1", "2", "3"))
        );
    }



    @DisplayName("// \n 사이에 구분자가 없을 때 에러를 던져주는 지")
    @Test
    void splitCustomDelimiterThrow(){
        //given
        String formula = "//₩n1o2o3";

        //when
        //then
        assertThatThrownBy(() -> Splitter.split(formula))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("%s는 올바르지 않은 커스텀구분자입니다.", formula));
    }

    @DisplayName("// \n 사이에 구분자가 숫자일 때 에러를 던져주는 지")
    @Test
    void splitCustomDelimiterThrowIfNumeric(){
        //given
        String formula = "//1₩n11213";

        //when
        //then
        assertThatThrownBy(() -> Splitter.split(formula))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("%s는 올바르지 않은 커스텀구분자입니다.", formula));
    }

    @DisplayName("//는 있는데 ₩n 없으면 에러를 던져주는지")
    @Test
    void invalidCustomDeliment(){
        //given
        String formula = "//abcd";

        //when
        //then
        assertThatThrownBy(() -> Splitter.split(formula))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("%s는 올바르지 않은 요청 포맷입니다.", formula));
    }

}
