package util;

import java.util.List;

public interface SplitUtil {

    String DEFAULT_MATCHER = "//(.)\n(.*)";

    static List<String> split(String text) {
        if(text.matches(DEFAULT_MATCHER)){
            return CustomSplitUtil.split(text);
        }
        return DefaultSplitUtil.split(text);
    }
}
