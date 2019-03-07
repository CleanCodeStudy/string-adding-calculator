package util;

import org.junit.Test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class CustomSplitUtilTest {

    @Test
    public void 커스텀_문자열_자르기() {
        //given
        String text = "//;\n1;2;3";

        //when
        List<String> tokens = CustomSplitUtil.split(text);

        //then
        assertEquals(tokens.get(0),"1");
        assertEquals(tokens.get(1),"2");
        assertEquals(tokens.get(2),"3");
    }

}