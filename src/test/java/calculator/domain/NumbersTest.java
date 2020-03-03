package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumbersTest {

    @DisplayName("숫자가 아닌 문자를 입력받으면 exception 발생")
    @Test
    void parseException() {
        assertThatThrownBy(() -> new Numbers(Arrays.asList("1", "22", "2;")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 값으로 합을 출력한다.")
    @Test
    void sum() {
        //given
        Numbers numbers = new Numbers(Arrays.asList("1", "2", "3"));

        //when
        int sum = numbers.sum();

        //then
        assertThat(sum).isEqualTo(6);
    }

    @DisplayName("숫자 일급 컬렉션 생성 테스트")
    @Test
    void equals() {
        Numbers numbers = new Numbers(Arrays.asList("1", "2", "3"));

        assertThat(numbers).isEqualTo(new Numbers(Arrays.asList("1", "2", "3")));
    }
}