package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class InputCheckingTest {

	@DisplayName("인자의 값이 빈칸 또는 null 인지 점검한다.")
	@Test
	void shouldCheckIsTheInputBlankTest() {
		String isBlank = "";
		String isNull = null;
		assertThat(InputChecking.checkIsTheInputBlank(isBlank)).isTrue();
		assertThat(InputChecking.checkIsTheInputBlank(isNull)).isTrue();
	}

	@DisplayName("인자의 값이 한 글자일 때, 글자수를 올바르게 판단하는 지 점검")
	@ParameterizedTest
	@CsvSource({"1", "2", "3"})
	void shouldCheckSinglularityTest(String values) {
		Parser singleParser = new Parser();

		//  void type 테스트를 어떻게해야할지 모르겠습니다..ㅠㅠ
//		assertThatThrownBy(() -> InputChecking.checkSinglularityAndPrintResult(values, singleParser))
//				.hasMessageContaining(values);
	}
}