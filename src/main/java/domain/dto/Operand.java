package domain.dto;

public class Operand {
    private final long value;

    public Operand(final String operand) {
        try {
            long parsedOperand = Long.parseLong(operand);

            checkNegative(parsedOperand);

            this.value = parsedOperand;
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException(String.format("%s 는 Double 형으로 파싱될 수 없습니다.", operand));
        }
    }

    private void checkNegative(double parsedOperand) {
        if (parsedOperand < 0) {
            throw new IllegalArgumentException(String.format("음수인 %s 값은 들어올 수 없습니다", parsedOperand));
        }
    }

    public double getValue() {
        return value;
    }

}
