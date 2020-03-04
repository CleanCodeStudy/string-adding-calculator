package domain.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OperandTest {

    @DisplayName("음수나 문자가 들어가면 익셉션을 던져준다")
    @MethodSource("negativeAndString")
    @ParameterizedTest
    void negative(String input, String exceptionMessage){
        assertThatThrownBy(() -> new Operand(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(exceptionMessage);
    }

    static Stream<Arguments> negativeAndString(){
        return Stream.of(
                Arguments.of("-5", "음수인 -5 값은 들어올 수 없습니다"),
                Arguments.of("abc", "abc 는 Long 형으로 파싱될 수 없습니다.")
        );
    }

    @DisplayName("Operand 끼리 sum 정상 동작 수행 확인")
    @Test
    void sum(){
        Operand operand = new Operand("5");
        Operand operand1 = new Operand("1");

        assertThat(operand.sum(operand1)).isEqualTo(new Operand("6"));
    }


}