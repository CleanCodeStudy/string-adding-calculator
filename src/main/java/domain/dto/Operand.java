package domain.dto;

public class Operand {
    private final long value;

    public Operand(final String operand) {
        try {
            long parsedOperand = Long.parseLong(operand);
            checkNegative(parsedOperand);
            this.value = parsedOperand;
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException(String.format("%s 는 Long 형으로 파싱될 수 없습니다.", operand));
        }
    }

    private Operand(long value) {
        this.value = value;
    }


    public long getValue() {
        return this.value;
    }

    public Operand sum(Operand operand) {
        return new Operand(this.value + operand.value);
    }

    private void checkNegative(long parsedOperand) {
        if (parsedOperand < 0) {
            throw new IllegalArgumentException(String.format("음수인 %d 값은 들어올 수 없습니다", parsedOperand));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Operand operand = (Operand) o;

        return value == operand.value;
    }

    @Override
    public int hashCode() {
        return (int) (value ^ (value >>> 32));
    }
}
