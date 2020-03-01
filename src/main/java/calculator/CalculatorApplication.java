import calculator.Calclator;
import calculator.Spliter;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorApplication {
    public static void main(String[] args) {
        int result = 0;
        System.out.println("숫자들을 입력하세요 : ");
        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.nextLine();
        if (inputValue.isEmpty()) {
            System.out.println(result);
            return;
        }

        Spliter spliter = new Spliter();
        String[] splitedValue = spliter.splitValue(inputValue);

        System.out.println(splitedValue);
        Calclator calclator = new Calclator();
        result = calclator.sum(splitedValue);

        System.out.println(result);
    }


}