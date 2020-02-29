package domain;

import domain.dto.Operand;

import java.util.List;

public class Calculator {
    public long calculate(List<String> operands) {
        return operands.stream()
                .map(Operand::new)
                .reduce(Operand::sum)
                .orElseThrow(() -> new IllegalArgumentException("sum 할 수 있는 operand가 없습니다"))
                .getValue();
    }
}
