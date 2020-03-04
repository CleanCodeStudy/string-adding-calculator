package calculator.domain.splitter;

import java.util.List;

public interface SplitStrategy {
    boolean support(String expression);

    List<String> split(String expression);
}
