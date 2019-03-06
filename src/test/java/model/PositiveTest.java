package model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class PositiveTest {

    @Test(expected = RuntimeException.class)
    public void 음수문자열을_넣었을때_예외발생() {
        //given
        String token = "-1";
        //when
        new Positive(token);
        //then
    }

    @Test(expected = RuntimeException.class)
    public void 특수문자열을_넣었을때_예외발생() {
        //given
        String token = "@";
        //when
        new Positive(token);
        //then
    }

    @Test
    public void 양수문자열을_넣었을때_Positive_생성() {
        //given
        String token = "1";
        //when
        Positive positive = new Positive(token);
        //then
        assertThat(positive.getNumber()).isEqualTo(1);
    }
}