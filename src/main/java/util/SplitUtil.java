package util;

import java.util.List;

public interface SplitUtil {

    String MATCHER = "//(.)\n(.*)";

    static List<String> split(String text) {
        if(text.matches(MATCHER)){
            return CustomSplitUtil.split(text);
        }
        return DefaultSplitUtil.split(text);
    }
}
