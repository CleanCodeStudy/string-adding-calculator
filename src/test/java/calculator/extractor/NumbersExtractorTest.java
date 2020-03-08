package calculator.extractor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersExtractorTest {

    @DisplayName("문자열에서 정수 리스트를 잘 추출해 내는지 테스트")
    @Test
    void numberExtractTest() {
        // given
        String inputString = "1,2:3";

        // when
        List<Integer> extractedNumbers = NumbersExtractor.extract(inputString);

        // then
        assertThat(extractedNumbers).isEqualTo(Arrays.asList(1, 2, 3));
    }

}