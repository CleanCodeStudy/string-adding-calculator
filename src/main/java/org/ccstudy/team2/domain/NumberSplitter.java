package org.ccstudy.team2.domain;

import org.ccstudy.team2.exception.CustomExceptionFunction;

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
        String[] temp = source.split(splitter);

        return checkNumbers(temp);
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

    //익셉션 처리의 리펙토링 필요
    public List<Integer> checkNumbers(String[] source) {
        return Arrays.stream(source)
                .map(host -> {
                    try {
                        if (Integer.valueOf(host) < 0)
                            throw new RuntimeException();
                        return Integer.valueOf(host);
                    } catch (RuntimeException e) {
                        throw e;
                    }
                })
                .collect(Collectors.toList());
    }

    public static <String,R> Function<String,R> wrap(CustomExceptionFunction<String,R> f){

        return (String r) -> {
            try {
                return f.apply(r);
            } catch (RuntimeException e) {
                throw e;
            }
        };
    }
}
