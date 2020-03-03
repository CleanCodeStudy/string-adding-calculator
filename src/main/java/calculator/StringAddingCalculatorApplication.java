package calculator;

import java.util.Scanner;

public class StringAddingCalculatorApplication {
	private static int result;

	public static void main(String[] args) {
		System.out.println("input : ");
		Scanner scanner = new Scanner(System.in);
		String inputValue = scanner.nextLine();

		if (InputChecking.isBlank(inputValue)) {
			System.out.println("값을 입력하세요.");
			System.exit(0);
		}

		Parser parser = new Parser();
		if (InputChecking.checkSinglularity(inputValue)) {
			System.out.println("result : "+parser.parseSingleValue(inputValue));
			return;
		}

		Splitter splitter = new Splitter();
		String[] tokens = splitter.checkDelimeter(inputValue);

		Calculator calculator = new Calculator();
		System.out.println("result : "+calculator.addValues(tokens));
	}
}