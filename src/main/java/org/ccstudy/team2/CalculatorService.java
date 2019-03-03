package org.ccstudy.team2;

import org.ccstudy.team2.domain.NumberSplitter;

import java.util.List;

public class CalculatorService {
    public Integer sum(String source) {

        NumberSplitter numberSplitter = new NumberSplitter(source);
        List<Integer> integerList = numberSplitter.getNumbers();

        return integerList.stream().mapToInt(Integer::intValue).sum();
    }
}
