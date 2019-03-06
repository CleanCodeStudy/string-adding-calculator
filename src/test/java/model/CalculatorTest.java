package model;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


public class CalculatorTest {
    @Test
    public void 숫자_문자열_리스트를_넣을때_덧셈결과_반환() {
        //given
        Calculator calculator = new Calculator(Arrays.asList("1","2","3"));
        //when
        int result = calculator.getResult();
        //then
        assertThat(result).isEqualTo(6);
    }

    @Test(expected = RuntimeException.class)
    public void 음수가_섞인_문자열_리스트를_넣을때_예외발생() {
        //given
        Calculator calculator = new Calculator(Arrays.asList("-1","-2","3"));
        //when
        int result = calculator.getResult();
        //then
        assertThat(result).isEqualTo(6);
    }

    @Test(expected = RuntimeException.class)
    public void 문자가_섞인_문자열_리스트를_넣을때_예외발생() {
        //given
        Calculator calculator = new Calculator(Arrays.asList("@","-2","3"));
        //when
        int result = calculator.getResult();
        //then
        assertThat(result).isEqualTo(6);
    }


}