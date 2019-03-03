import util.CustomSplitUtil;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorController {

    private static final String tokens = ",|:";


    public static int calculate(String text) {
        Calculator calculator = new Calculator(getOperandGroup(text));
        return calculator.getResult();
    }

    public static List<String> getOperandGroup(String text) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (matcher.find()) {
            return CustomSplitUtil.split(matcher);
        }
        return Arrays.asList(text.split(tokens));
    }

}
