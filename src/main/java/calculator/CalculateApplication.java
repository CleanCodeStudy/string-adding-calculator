package calculator;

import java.util.Scanner;

public class CalculateApplication {
    public static void main(String[] args) {
        ResultView.printOutResult(new AddCalculator(), InputView.inputString(new Scanner(System.in)));
    }
}
