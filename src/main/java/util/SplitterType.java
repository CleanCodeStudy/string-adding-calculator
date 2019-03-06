package util;

import java.util.Arrays;

public enum SplitterType {
    CUSTOM(new CustomSplitter()),
    DEFAULT(new DefaultSplitter());

    private Splitter splitter;

    SplitterType(Splitter splitter) {
        this.splitter = splitter;
    }

    public static Splitter getSplitter(String text) {
        return Arrays.stream(SplitterType.values())
                .filter(splitterType -> splitterType.support(text))
                .findFirst()
                .orElseThrow(RuntimeException::new)
                .splitter;
    }

    private boolean support(String text){
        return splitter.support(text);
    }
}
