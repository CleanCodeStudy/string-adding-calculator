package calculator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Spliter {

    public static final String DELIMITER1 = "[,|:]";
    public static final String CUSTOMER_DELIMITER = "//(.)\n(.*)";

    public String[] splitValue(String value) {
        Matcher m = Pattern.compile(CUSTOMER_DELIMITER).matcher(value);
        System.out.println(m.find());
        if(m.find()){
            String customDelimiter = m.group(1);
            String tokens =m.group(2);
            String[] splitedValue = tokens.split(CUSTOMER_DELIMITER);
            System.out.println(splitedValue[0]+"custom");
            System.out.println(splitedValue[1]+"custom");
            System.out.println(splitedValue[2]+"custom");
        }

        String[] splitedValue = value.split(DELIMITER1);
        System.out.println(splitedValue[0]);
        System.out.println(splitedValue[1]);
        System.out.println(splitedValue[2]);
        return splitedValue;
    }

    public int parseToInt(String splitedValue) {
        if (isNumberic(splitedValue)) {
            int number = Integer.parseInt(splitedValue);
            checkPositve(number);
            return number;
        }
        throw new IllegalArgumentException("양수로 된 숫자만 입력하세요.");
    }

    public void checkPositve(int parseInt) {
        if (parseInt > 0) {
            return;
        }
        throw new IllegalArgumentException("음수가 아닌 양수만 입력하세요.");
    }

    public boolean isNumberic(String splitedValue) {
        try {
            Integer.parseInt(splitedValue);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
