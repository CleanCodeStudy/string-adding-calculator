package calculator;

import java.util.Arrays;

public class AddCalculator {
    public static int calculate(String[] numbers){
        return Arrays.stream(numbers).mapToInt(number -> Integer.parseInt(number)).sum();
    }
}