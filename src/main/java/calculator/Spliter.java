package calculator;

import com.sun.org.apache.bcel.internal.generic.ATHROW;

public class Spliter {

    public static final String DELIMITER1 = ",";
    public static final String DELIMITER2 = ";";

    public String[] splitValue(String value){
        String[] splitedValue = value.split(",|;");

        return splitedValue;
    }

    public static int parseToInt(String value){

        int number =  Integer.parseInt(value);
        checkPositve(number);
        return number;
    }

    public static void checkPositve(int parseInt){
        if(parseInt > 0){
            return ;
        }
        throw new IllegalArgumentException("양수만 입력하세요.");
    }
}
