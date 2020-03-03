package calculator.domain;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PositiveNumbers {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("(\\d+)");
    private final List<Integer> numbers;

    public PositiveNumbers(List<String> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validate(List<String> numbers) {
        boolean canParse = numbers.stream()
                .map(NUMBER_PATTERN::matcher)
                .allMatch(Matcher::matches);

        if (!canParse) {
            throw new IllegalArgumentException(numbers + "양수가 아닌 입력값이 존재합니다.");
        }
    }

    public int sum() {
        return numbers.stream()
                .reduce(0, Integer::sum);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositiveNumbers positiveNumbers = (PositiveNumbers) o;
        return Objects.equals(numbers, positiveNumbers.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
