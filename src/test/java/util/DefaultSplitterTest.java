package util;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class DefaultSplitterTest {

    @Test
    public void 기본_토큰을_가진_문자열을_지원가능한지_확인() {
        //given
        String text = "1,2:3";
        DefaultSplitter defaultSplitter = new DefaultSplitter();

        //when
        //then
        assertThat(defaultSplitter.support(text)).isTrue();
        assertThat(defaultSplitter.matcher).isNotNull();
    }


    @Test
    public void 기본_토큰을_가진_문자열을_넣었을때_파싱배열_반환() {
        //given
        String text = "1,2:3";
        DefaultSplitter defaultSplitter = new DefaultSplitter();

        //when
        defaultSplitter.support(text);
        //then
        assertThat(defaultSplitter.split()).contains("1","2","3");
    }
}