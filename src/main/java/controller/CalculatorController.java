package controller;

import domain.Calculator;
import util.SplitUtil;
import view.InputView;

import java.util.List;

public class CalculatorController {

    public static int calculate() {
        String text = InputView.getInput();
        Calculator calculator = new Calculator(getOperandGroup(text));
        return calculator.getResult();
    }

    public static List<String> getOperandGroup(String text) {
        return SplitUtil.split(text);
    }
}
