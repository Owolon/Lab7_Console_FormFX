package logic.tokenizer;

import logic.patterns.RegexPatterns;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSharpTokenizer {

    private final Pattern tokenPattern;

    public CSharpTokenizer() {
        tokenPattern = Pattern.compile(
                RegexPatterns.IDENTIFIER_PATTERN
        );
    }

    public List<String> tokenize(String code) {

        List<String> tokens = new ArrayList<>();

        Matcher matcher = tokenPattern.matcher(code);

        while (matcher.find()) {
            tokens.add(matcher.group());
        }

        return tokens;
    }
}