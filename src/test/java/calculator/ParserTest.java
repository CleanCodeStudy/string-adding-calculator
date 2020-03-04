package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParserTest {
	Parser parser = new Parser();

	@DisplayName("String을 Integer로 올바르게 파싱하는 지 점검")
	@Test
	void stringToInteger() {
		String stringToInt = "3";
		assertThat(parser.stringToInteger(stringToInt)).isEqualTo(3);
	}

	@DisplayName("인자가 문자일 때, 터지는 exception 점검.")
	@Test
	void shouldThrowException() {
		String invalidValue = "j";
		assertThat(parser.stringToInteger(invalidValue)).isEqualTo(new NumberFormatException());
	}

	@DisplayName("양수인지 점검")
	@Test
	void shouldCheckPositiveValueTest() {
		String negativeInt = "-1";
		assertThatThrownBy(() -> new Parser().stringToInteger(negativeInt))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("문자 하나를 입력했을 때, 제대로 파싱되는 지")
	@Test
	void singleValueTest() {
		String singleValue = "1";
		assertThat(parser.parseSingleValue(singleValue)).isEqualTo(1);
	}

	@DisplayName("숫자가 아닌 값을 입력했을 때, 오류")
	@Test
	void invalidSingleValueTest() {
		String invalidSingleValue = "j";
		assertThat(parser.parseSingleValue(invalidSingleValue)).isEqualTo(new NumberFormatException());
	}
}