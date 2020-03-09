package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {
	public static final String DEFAULT_DELIMITER = "[,:]";
	public static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
	public static final int DELIMETER_GROUP = 1;
	public static final int TOKEN_GROUP = 2;

	private Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);

	public String[] getTokens(String text) {
		if (text.contains(DEFAULT_DELIMITER)) {
			return splitByDefaultDelimiter(text);
		}
		return splitByCustomDelimeter(text);
	}

	private String[] splitByDefaultDelimiter(String text) {
		return text.split(DEFAULT_DELIMITER);
	}

	private String[] splitByCustomDelimeter(String text) {
		Matcher matcher = pattern.matcher(text);
		String customDelimeter = matcher.group(DELIMETER_GROUP);
		return matcher.group(TOKEN_GROUP).split(customDelimeter);
	}
}
