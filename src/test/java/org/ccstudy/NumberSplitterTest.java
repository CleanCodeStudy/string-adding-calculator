package org.ccstudy;

import org.ccstudy.domain.NumberSplitter;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class NumberSplitterTest {
    @Test
    public void 하나만들어왔을때(){
        String source = "1";
        List<Integer> expect = Arrays.asList(1);

        NumberSplitter numberSplitter = new NumberSplitter(source);

        assertEquals(numberSplitter.getNumbers(),expect);
    }

    @Test
    public void 숫자리스트반환(){
        List<Integer> expect = Arrays.asList(1,2,3,4);

        String source = "//;\n1;2,3:4";
        String source1 = "1,2,3:4";

        NumberSplitter numberSplitter = new NumberSplitter(source);
        NumberSplitter numberSplitter1 = new NumberSplitter(source1);

        assertEquals(numberSplitter.getNumbers(),expect);
        assertEquals(numberSplitter1.getNumbers(),expect);
    }

    @Test
    public void 널_체크(){
        String emptySource = "";
        String nullSource = null;
        String source = "1,2,3:4";

        NumberSplitter numberSplitter = new NumberSplitter(nullSource);
        NumberSplitter numberSplitter1 = new NumberSplitter(emptySource);
        NumberSplitter numberSplitter2 = new NumberSplitter(source);


        assertTrue(numberSplitter.checkEmptySource());
        assertTrue(numberSplitter1.checkEmptySource());

        assertFalse(numberSplitter2.checkEmptySource());
    }

    @Test
    public void 커스텀구분자찾기(){
        String customSource = "//;\n1;2,3";
        String normalSource = "1:2,3";

        NumberSplitter numberSplitter = new NumberSplitter(customSource);
        NumberSplitter numberSplitter1 = new NumberSplitter(normalSource);

        assertEquals(numberSplitter.getSplitter(),",|:|;");
        assertEquals(numberSplitter1.getSplitter(),",|:");
    }

    @Rule
    public ExpectedException expectedExcetption = ExpectedException.none();

    @Test
    public void 음수_숫자이외_런타임익셉션() throws Exception{
        String abnormalSource = "!,1:2,3";
        String minusSource = "-1,2,3";
        NumberSplitter numberSplitter = new NumberSplitter(abnormalSource);
        NumberSplitter numberSplitter1 = new NumberSplitter(minusSource);

        expectedExcetption.expect(RuntimeException.class);

        numberSplitter.getNumbers();
        numberSplitter1.getNumbers();

    }
}