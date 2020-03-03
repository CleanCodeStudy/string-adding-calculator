package calculator.domain;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Numbers {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");
    private final List<Integer> numbers;

    public Numbers(List<String> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validate(List<String> numbers) {
        boolean canParse = numbers.stream()
                .map(NUMBER_PATTERN::matcher)
                .allMatch(Matcher::find);

        if (!canParse) {
            throw new IllegalArgumentException(numbers + "숫자가 아닌 입력값이 존재합니다.");
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
        Numbers numbers1 = (Numbers) o;
        return Objects.equals(numbers, numbers1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
