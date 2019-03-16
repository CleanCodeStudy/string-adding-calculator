package domain;

public class Positive {
    private String token;
    private Integer number;

    public Positive(String token) {
        this.token = token;
        this.number = parsePositiveInt(token);
    }

    public int getNumber() {
        return number;
    }

    private int parsePositiveInt(String token) {
        int number = Integer.parseInt(token);

        validatePositiveNumber(number);

        return number;
    }

    private void validatePositiveNumber(int number) {
        if (number <= 0) {
            throw new RuntimeException();
        }
    }

}
