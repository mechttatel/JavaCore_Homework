package utils.ex12;

public abstract class KeywordAnalyzer implements TextAnalyzer {

    protected abstract String[] getKeywords();
    protected abstract Label getLabel();

    @Override
    public Label processText(String text) {
        for (String keyword : this.getKeywords()) {
            if (text.contains(keyword)) {
                return this.getLabel();
            }
        }

        return Label.OK;
    }
}
