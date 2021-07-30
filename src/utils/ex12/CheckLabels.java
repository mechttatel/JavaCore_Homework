package utils.ex12;

import utils.ex12.Implements.NegativeTextAnalyzer;
import utils.ex12.Implements.SpamAnalyzer;
import utils.ex12.Implements.TooLongTextAnalyzer;

public class CheckLabels {

    private final TextAnalyzer[] filters;

    public CheckLabels(String[] keywords, int maxLength) {
        this.filters = new TextAnalyzer[] {
                new SpamAnalyzer(keywords),
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(maxLength)
        };
    }

    public Label checkLabels(String text) {
        for (TextAnalyzer filter : filters) {
            Label filterResult = filter.processText(text);
            if (filterResult != Label.OK) {
                return filterResult;
            }
        }

        return Label.OK;
    }
}
