import util.SplitUtil;

import java.util.List;

public class CalculatorController {

    public static int calculate(String text) {
        if (text.isEmpty() || text == null) {
            return 0;
        }
        Calculator calculator = new Calculator(getOperandGroup(text));
        return calculator.getResult();
    }

    public static List<String> getOperandGroup(String text) {
        return SplitUtil.split(text);
    }
}
