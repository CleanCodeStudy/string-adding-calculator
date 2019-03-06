package util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Splitter {
    protected String delimiterToken;
    protected Matcher matcher;

    public boolean support(String text){
        matcher = Pattern.compile(delimiterToken).matcher(text);
        return matcher.find();
    };

    public abstract List<String> split();
}
