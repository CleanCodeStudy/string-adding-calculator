package calculator;

public class ResultView {
    static void printOutResult(AddCalculator addCalculator, String[] numbers) {
        System.out.println(addCalculator.calculate(numbers));
    }
}
