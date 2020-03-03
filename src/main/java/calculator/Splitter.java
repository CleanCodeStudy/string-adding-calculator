package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {
	public static final String DEFAULT_DELIMITER = ",|:";
	public static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

	private static Matcher m;

	public String[] checkDelimeter(String text){
		m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(text);
		if(text.contains(",")|text.contains(":")){
			return splitByDefaultDelimiter(text);
		}
		if(m.find()){
			return splitByCustomDelimeter();
		}
		return null;
	}

	private String[] splitByDefaultDelimiter(String text) {
		return text.split(",|:");
	}

	private String[]  splitByCustomDelimeter() {
		String customDelimeter = m.group(1);
		return m.group(2).split(customDelimeter);
	}

}
