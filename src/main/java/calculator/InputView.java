package calculator;

import java.util.Scanner;

public class InputView {
    public static String[] inputString(Scanner scanner){
        System.out.println("문자열을 입력하세요");
        String inputString = scanner.next();

        return Splitter.makeNumbers(inputString);
    }
}

