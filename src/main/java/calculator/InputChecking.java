package calculator;

public class InputChecking {

	public static boolean checkIsTheInputBlank(String value) {
		if (value == null || value.isEmpty()) {
			System.out.println("0");
			throw new NullPointerException();
		}
		return true;
	}

	public static void checkSinglularityAndPrintResult(String inputValue, Parser singleParser) {
		if (inputValue.length() == 1) {
			System.out.println("result : " + singleParser.parseSingleValue(inputValue));
		}
	}
}