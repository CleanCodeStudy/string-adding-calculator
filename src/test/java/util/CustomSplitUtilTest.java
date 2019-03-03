package util;

import org.junit.Test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class CustomSplitUtilTest {

    @Test
    public void 문자열_자르기() {
        //given
        String text = "//;\n1;2;3";
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        matcher.find();

        //when
        List<String> tokens = CustomSplitUtil.split(matcher);


        //then
        assertEquals(tokens.get(0),"1");
        assertEquals(tokens.get(1),"2");
        assertEquals(tokens.get(2),"3");
    }

}