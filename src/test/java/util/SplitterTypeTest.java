package util;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitterTypeTest {
    @Test
    public void 커스텀_토큰을_넣었을때_커스텀_문자열_Splitter_반환() {
        //given
        String text = "//;\n1;2;3";
        //when
        Splitter splitter = SplitterType.getSplitter(text);
        //then
        assertThat(splitter.delimiterToken).isEqualTo(CustomSplitter.DELIMITER_TOKEN);
    }

    @Test
    public void 커스텀_토큰이_없을때_디폴트_문자열_Splitter_반환() {
        //given
        String text = "1;2;3";
        //when
        Splitter splitter = SplitterType.getSplitter(text);
        //then
        assertThat(splitter.delimiterToken).isEqualTo(DefaultSplitter.DELIMITER_TOKEN);
    }
}