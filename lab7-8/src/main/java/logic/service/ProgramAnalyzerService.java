package logic.service;

import logic.keywords.KeywordFinder;
import logic.tokenizer.CSharpTokenizer;
import logic.transform.IncrementOptimizer;

import java.util.List;

public class ProgramAnalyzerService {

    private final CSharpTokenizer tokenizer;
    private final KeywordFinder keywordFinder;
    private final IncrementOptimizer optimizer;

    public ProgramAnalyzerService() {

        tokenizer = new CSharpTokenizer();
        keywordFinder = new KeywordFinder();
        optimizer = new IncrementOptimizer();
    }

    // ЗАДАЧА 16
    public List<String> findKeywords(String code) {

        List<String> tokens =
                tokenizer.tokenize(code);

        return keywordFinder.findKeywords(tokens);
    }

    // ЗАДАЧА 17
    public String optimizeCode(String code) {

        return optimizer.optimize(code);
    }
}