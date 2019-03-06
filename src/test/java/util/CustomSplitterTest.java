package util;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CustomSplitterTest {

    @Test
    public void 커스텀_토큰을_가진_문자열을_넣었을때_지원가능한지_여부_반환() {
        //given
        String text = "//;\n1;2;3";
        CustomSplitter customSplitter = new CustomSplitter();
        //when
        //then
        assertThat(customSplitter.support(text)).isTrue();
        assertThat(customSplitter.matcher).isNotNull();
    }

    @Test
    public void 커스텀_토큰을_가진_문자열을_넣었을때_파싱배열_반환() {
        //given
        String text = "//;\n1;2;3";
        CustomSplitter customSplitter = new CustomSplitter();
        //when
        customSplitter.support(text);
        //then
        assertThat(customSplitter.split()).contains("1","2","3");
    }
}