package util;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DefaultSplitUtilTest {

    @Test
    public void 기본_문자열_자르기() {
        //given
        String text = "1,2,3";

        //when
        List<String> tokens = DefaultSplitUtil.split(text);

        //then
        assertEquals("1", tokens.get(0));
        assertEquals("2", tokens.get(1));
        assertEquals("3", tokens.get(2));
    }

    @Test
    public void 구분자_리스트_스플릿터에_맞는_문자열로_변환(){

        String splitDelimiter = DefaultSplitUtil.getSplitDelimiter();

        assertEquals(":|,", splitDelimiter);
    }

}