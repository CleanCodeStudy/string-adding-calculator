import domain.Calculator;
import service.CalculatorService;
import view.OutputView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculatorService calculatorService = new CalculatorService(new Calculator());

        OutputView.printRequestFormulaMessage();

        double result = calculatorService.calculate(scanner.next());

        OutputView.printCalculateResult(result);
    }
}
