package calculator.domain.splitter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CustomSplitStrategyTest {

    private static Stream<Arguments> customSupportProvider() {
        return Stream.of(
                Arguments.of("//?\n1?2?3", true),
                Arguments.of("1?2?3", false)
        );
    }

    @DisplayName("커스텀식을 나타내는 (// \\n)이 존재해야 지원한다.")
    @ParameterizedTest
    @MethodSource("customSupportProvider")
    void support(String expression, boolean result) {
        //given
        CustomSplitStrategy customSplitStrategy = new CustomSplitStrategy();

        //when
        boolean expect = customSplitStrategy.support(expression);

        //then
        assertThat(expect).isEqualTo(result);
    }

    @DisplayName("커스텀식은 커스텀 구분자로 구분한다.")
    @Test
    void split() {
        //given
        CustomSplitStrategy customSplitStrategy = new CustomSplitStrategy();
        String expression = "//#\n1#2#3";

        //when
        List<String> expect = customSplitStrategy.split(expression);

        //then
        assertThat(expect).containsExactly("1", "2", "3");
    }
}