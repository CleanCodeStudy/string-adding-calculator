package calculator;

public class Calclator {
    Spliter spliter = new Spliter();
    public int sum(String[] splitedValue) {
        int result = 0;
        for (int i = 0; i < splitedValue.length; i++) {
            result += spliter.parseToInt(splitedValue[i]);
        }
        return result;
    }

}