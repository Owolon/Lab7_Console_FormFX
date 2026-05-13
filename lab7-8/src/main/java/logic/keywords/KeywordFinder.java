package logic.keywords;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class KeywordFinder {

    public List<String> findKeywords(List<String> tokens) {

        Set<String> foundKeywords = new LinkedHashSet<>();

        for (String token : tokens) {

            if (KeywordStorage.KEYWORDS.contains(token)) {
                foundKeywords.add(token);
            }
        }

        return new ArrayList<>(foundKeywords);
    }
}