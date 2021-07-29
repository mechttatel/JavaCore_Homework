package utils.ex12;

import utils.ex12.Implements.NegativeTextAnalyzer;
import utils.ex12.Implements.SpamAnalyzer;
import utils.ex12.Implements.TooLongTextAnalyzer;

public class CheckLabels {

    private final TextAnalyzer[] filters;

    public CheckLabels(TextAnalyzer[] filters) {
        this.filters = new TextAnalyzer[] {
                new SpamAnalyzer("fu", "trash"),
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(30)
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
    };
}
