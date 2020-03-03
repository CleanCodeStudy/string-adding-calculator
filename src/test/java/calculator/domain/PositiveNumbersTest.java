package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositiveNumbersTest {

    @DisplayName("음수 입력시 exception 발생")
    @Test
    void negativeNumber() {
        assertThatThrownBy(() -> new PositiveNumbers(Arrays.asList("1", "22", "-1")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 문자를 입력받으면 exception 발생")
    @Test
    void parseException() {
        assertThatThrownBy(() -> new PositiveNumbers(Arrays.asList("1", "22", "2;")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 값으로 합을 출력한다.")
    @Test
    void sum() {
        //given
        PositiveNumbers positiveNumbers = new PositiveNumbers(Arrays.asList("1", "2", "3"));

        //when
        int sum = positiveNumbers.sum();

        //then
        assertThat(sum).isEqualTo(6);
    }

    @DisplayName("숫자 일급 컬렉션 생성 테스트")
    @Test
    void equals() {
        PositiveNumbers positiveNumbers = new PositiveNumbers(Arrays.asList("1", "2", "3"));

        assertThat(positiveNumbers).isEqualTo(new PositiveNumbers(Arrays.asList("1", "2", "3")));
    }
}