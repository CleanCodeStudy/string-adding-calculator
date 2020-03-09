package calculator;

public class Calculator {
	public static int addValues(String[] tokens, Parser parser) {

		int sum = 0;
		for (String token : tokens) {
			sum += parser.stringToInteger(token);
		}
		return sum;
	}
}