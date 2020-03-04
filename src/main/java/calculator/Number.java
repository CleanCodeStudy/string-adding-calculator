package calculator;

public class Number {
    private final int value;

    public Number(String value) {
        this.value = parseString(value);
    }

    public Number(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Number sum(Number a, Number b) {
        return new Number(a.getValue() + b.getValue());
    }

    private int parseString(String value) {
        validateNumber(value);
        int result = Integer.parseInt(value);

        if (result < 0) {
            throw new RuntimeException(String.format("음수가 입력되었습니다. : %s ", result));
        }

        return result;
    }

    private void validateNumber(String value) {
        if (value == null || value.isEmpty()) {
            throw new RuntimeException("빈 문자열 입니다.");
        }
    }
}
