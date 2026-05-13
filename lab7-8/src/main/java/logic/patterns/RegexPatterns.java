package logic.patterns;

public class RegexPatterns {

    private RegexPatterns() {
    }

    // идентификаторы и ключевые слова
    public static final String IDENTIFIER_PATTERN =
            "[A-Za-z_][A-Za-z0-9_]*";

    // variable = variable + 1
    public static final String INCREMENT_PATTERN =
            "\\b([A-Za-z_][A-Za-z0-9_]*)\\b\\s*=\\s*\\1\\s*\\+\\s*1\\b";
}
