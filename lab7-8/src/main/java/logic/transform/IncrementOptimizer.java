package logic.transform;

import logic.patterns.RegexPatterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IncrementOptimizer {

    private final Pattern incrementPattern;

    public IncrementOptimizer() {

        incrementPattern = Pattern.compile(
                RegexPatterns.INCREMENT_PATTERN
        );
    }

    public String optimize(String code) {

        Matcher matcher = incrementPattern.matcher(code);

        return matcher.replaceAll("$1++");
    }
}