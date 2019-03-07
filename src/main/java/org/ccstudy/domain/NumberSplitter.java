package org.ccstudy.domain;

import org.ccstudy.exception.CustomExceptionFunction;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NumberSplitter {
    private String source;

    public NumberSplitter(String source) {
        this.source = source;
    }

    public List<Integer> getNumbers() {
        if (checkEmptySource()) {
            return Arrays.asList(0);
        }

        String splitter = getSplitter();

        //temp의 네이밍을 뭐로 해야할지 모르겠음....
        String[] splits = source.split(splitter);

        return checkNumbers(splits);
    }

    public boolean checkEmptySource() {
        if (source == null || source.isEmpty())
            return true;
        return false;
    }

    public String getSplitter() {
        String splitter = ",|:";
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(source);
        if (matcher.find()) {
            splitter = splitter + "|" + matcher.group(1);
            source = matcher.group(2);
        }
        return splitter;
    }

    public List<Integer> checkNumbers(String[] source) {
        return Arrays.stream(source)
                .map(wrap(Integer::valueOf))
                .collect(Collectors.toList());
    }

    public static <T,R> Function<T,R> wrap(CustomExceptionFunction<T,R> f){

        return (T r) -> {
            try {
                if((Integer)r < 0)
                    throw new RuntimeException();
                return f.apply(r);
            } catch (RuntimeException e) {
                throw e;
            }
        };
    }
}
