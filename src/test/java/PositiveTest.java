import org.junit.Test;

import static org.junit.Assert.*;

public class PositiveTest {

    @Test
    public void 한글자_스트링_양수_정수로_만들기() {
        //given
        String token = "1";
        //when
        Positive positive = new Positive(token);
        //then
        assertEquals(1, positive.getNumber());
    }


    @Test(expected = RuntimeException.class)
    public void 한글자_스트링_양수가_아닐_경우_예외발생() {
        //given
        String token = "s";
        //when
        //then
        assertEquals(1,  new Positive(token));
    }
}