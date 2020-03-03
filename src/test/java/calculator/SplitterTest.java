package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SplitterTest {
	Splitter splitter = new Splitter();

	@DisplayName("Custom delimeter test")
	@Test
	void customDelimeterTest() {
		String inputText = "//;\n1;2;3";
		String[] inspectTokens = {"1","2","3"};
		assertThat(splitter.checkDelimeter(inputText)).isEqualTo(inspectTokens);
	}

	@DisplayName("Default delimeter test")
	@Test
	void defaultDelimeterTest() {
		String inputText = "1,2:3";
		String[] inspectTokens = {"1","2","3"};
		assertThat(splitter.checkDelimeter(inputText)).isEqualTo(inspectTokens);
	}
}