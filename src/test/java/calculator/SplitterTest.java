package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SplitterTest {

    @Test
    void makeNumbers() {
        assertThat(Splitter.makeNumbers("1:2:3")).isEqualTo(new String[]{"1","2","3"});
    }
}