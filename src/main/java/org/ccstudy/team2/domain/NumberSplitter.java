package org.ccstudy.team2.domain;

import org.ccstudy.team2.exception.NegativeValueException;
import org.ccstudy.team2.exception.NotIntegerException;

import java.util.Arrays;
import java.util.List;
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

        String[] splittedSource = source.split(splitter);

        return checkNumbers(splittedSource);
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
                .map(arg -> convertStringToInteger(arg))
                .collect(Collectors.toList());
    }

    private Integer convertStringToInteger(final String source){
        try {
            if(Integer.valueOf(source)<0)
                throw new NegativeValueException();
            return Integer.valueOf(source);
        }catch(Exception e){
            throw new NotIntegerException();
        }
    }
}
