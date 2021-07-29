package utils.ex12.Implements;

import utils.ex12.Label;
import utils.ex12.TextAnalyzer;

public class TooLongTextAnalyzer implements TextAnalyzer {

    private final int maxLength;

    public TooLongTextAnalyzer(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public Label processText(String text) {
        return text.length() <= maxLength ? Label.OK : Label.TOO_LONG;
    }
}
