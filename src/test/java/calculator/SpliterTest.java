package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class SpliterTest {
        Spliter spliter = new Spliter();
    @Test
    void splitValue() {
//        String inputValue = new String("1,2:3");
//        assertThat(spliter.splitValue(inputValue)).isEqualTo(["1", "2", "3"]);
    }

    @Test
    @DisplayName("숫자가 아닐 때 테스트")
    void parseToInt() {
        String splitedValue = " ";
        assertThatThrownBy(() -> spliter.parseToInt(splitedValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("양수로 된 숫자만 입력하세요.");
    }
    @Test
    @DisplayName("음수를 입력했을 때 테스트")
    void checkPositve() {
        int negative = -1;
        assertThatThrownBy(() -> spliter.checkPositve(negative))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수가 아닌 양수만 입력하세요.");
    }

}