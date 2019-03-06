package model;

import java.util.List;
import java.util.stream.Collectors;

public class Calculator {
    private List<Positive> positives;

    public Calculator(List<String> strings) {
        this.positives = createPositives(strings);
    }

    private List<Positive> createPositives(List<String> strings) {
        return strings.stream()
                .map(Positive::new)
                .collect(Collectors.toList());
    }

    public int getResult() {
        return positives.stream()
                .mapToInt(Positive::getNumber)
                .sum();
    }
}
