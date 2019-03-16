package view;

import java.util.Scanner;

public class InputView {
    public static String getInput() {
        System.out.println("계산 값을 입력하세요");

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        return checkEmpty(input)? "0" : input;
    }

    private static boolean checkEmpty(String text){
        if (text.isEmpty() || text == null) {
            return true;
        }
        return false;
    }
}
