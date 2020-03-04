package calculator;

public class Calculator {
	public static int addValues(String[] tokens, Parser parser) {
		int result = 0;
		for (int i = 0; i < tokens.length; i++) {
			result += parser.stringToInteger(tokens[i]);
		}
		return result;
	}
}