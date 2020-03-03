package calculator;

public class Parser {
	public int stringToInteger(String stringToInt) {
		int toInt = 0;
		try {
			toInt = Integer.parseInt(stringToInt);
			checkTheValueIsPositive(toInt);
			return toInt;
		} catch (NumberFormatException e) {
			System.out.println("숫자를 입력하세요.");
			System.exit(0);
		}
		return toInt;
	}

	public void checkTheValueIsPositive(int number){
		if(number<0) {
			System.out.println("양수를 입력하세요");
			throw new IllegalArgumentException();
		}
	}

	public int parseSingleValue(String inputValue){
		int result= 0;
		try {
			result = Integer.parseInt(inputValue);
		} catch (NumberFormatException parsingFail) {
			System.out.println("숫자를 입력하세요");
			System.exit(0);
		}
		return result;
	}
}
