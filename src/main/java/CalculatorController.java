import model.Calculator;
import util.SplitterType;
import view.InputView;

import java.util.List;

public class CalculatorController {

    public static void calculate() {
        String text = InputView.inputText();

        List<String> operandGroup = SplitterType.getSplitter(text).split();

        Calculator calculator = new Calculator(operandGroup);

        System.out.println(calculator.getResult());
    }
}
