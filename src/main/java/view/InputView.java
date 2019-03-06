package view;

import java.util.Scanner;

public class InputView {
    private static final String RESULT = "0";

    public static String inputText() {
        System.out.println("계산한 내용을 입력하세요.");
        String text = new Scanner(System.in).nextLine();
        return isNullOrEmpty(text) ? RESULT : text;
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

}
