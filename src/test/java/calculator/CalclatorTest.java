package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;



class CalculatorTest {
    Spliter spliter = new Spliter();
    Calclator calclator = new Calclator();
    @Test
    @DisplayName("올바른 계산")
    void sum() {
        String[] splitedValue = {"1","2","5"};
        assertThat(calclator.sum(splitedValue)).isEqualTo(8);

    }
}