package calculator;

public class Calculator {
	public int addValues(String[] tokens) {
		int result=0;
		Parser parser = new Parser();
		for (int i = 0; i < tokens.length; i++) {
			result += parser.stringToInteger(tokens[i]);
		}
		return result;
	}
}
