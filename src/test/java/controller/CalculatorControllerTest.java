package controller;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CalculatorControllerTest {

    @Test
    public void 피연산자와_커스텀_스플릿터를_구분한다() {

        //given
        String text = "//!\n1!2!3";

        //when
        int result = CalculatorController.calculate(text);

        //then
        assertEquals(2, result);
    }

    @Test(expected = RuntimeException.class)
    public void 형식에_이상하면_예외발생() {

        //given
        String text = "//!\n(*0)1!2!3";


        //when
        int result = CalculatorController.calculate(text);

        //then
        assertEquals(6, result);

    }

    @Test
    public void 빈문자열_0_반환() {

        //given
        String text = "";

        //when
        int result = CalculatorController.calculate(text);

        //then
        assertEquals(0, result);

    }

    @Test
    public void 커스텀_구분자_여부확인_후_스트링_배열_반환() {

        //given
        String text = "//!\n1!2!3";

        //when
        List<String> operandGroup = CalculatorController.getOperandGroup(text);

        //then
        assertEquals(3, operandGroup.size());

    }
}