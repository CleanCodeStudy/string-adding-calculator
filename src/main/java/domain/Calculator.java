package domain;

import domain.dto.Operand;

import java.util.List;

public class Calculator {

    public double calculate(List<String> formula) {
        return formula.stream()
                .mapToDouble(o -> new Operand(o).getValue())
                .sum();
    }
}
