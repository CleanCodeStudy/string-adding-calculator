package util;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SplitUtilTest {

    @Test
    public void 입력값_분석하여_텍스트_분리_CUSTOM() {
        //given
        String text = "//;\n1;2;3";

        //when
        List<String> tokens = SplitUtil.split(text);

        //then
        assertEquals("1", tokens.get(0));
        assertEquals("2", tokens.get(1));
        assertEquals("3", tokens.get(2));
    }

    @Test
    public void 입력값_분석하여_텍스트_분리_DEFAULT() {
        //given
        String text = "1,2,3";

        //when
        List<String> tokens = SplitUtil.split(text);

        //then
        assertEquals("1", tokens.get(0));
        assertEquals("2", tokens.get(1));
        assertEquals("3", tokens.get(2));
    }
}