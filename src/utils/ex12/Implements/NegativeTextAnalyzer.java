package utils.ex12.Implements;

import utils.ex12.KeywordAnalyzer;
import utils.ex12.Label;

public class NegativeTextAnalyzer extends KeywordAnalyzer {

    private final String[] smiles = new String[] {
            ":(", "=(", ":|"
    };

    @Override
    protected String[] getKeywords() {
        return smiles;
    }

    @Override
    protected Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
}
