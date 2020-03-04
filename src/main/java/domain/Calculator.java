package domain;

import domain.dto.Operand;

import java.util.List;

public class Calculator {
    public long calculate(List<String> operands) {
        return operands.stream()
                .map(Operand::new)
                .reduce(new Operand(), Operand::sum)
                .getValue();
    }
}
