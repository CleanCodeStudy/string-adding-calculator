package calculator;

public class StringAddingCalculatorApplication {
	public static void main(String[] args) {
		String inputValue = GetInput.getInput();

		InputChecking.checkIsTheInputBlank(inputValue);

		Parser parser = new Parser();
		InputChecking.checkSinglularityAndPrintResult(inputValue, parser);

		Splitter splitter = new Splitter();
		String[] tokens = splitter.getTokens(inputValue);

		System.out.println("result : " + Calculator.addValues(tokens, parser));
	}
}