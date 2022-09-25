package study.java_lessons.lesson_3_6.wclasses;

import study.java_lessons.lesson_3_6.help.Label;
import study.java_lessons.lesson_3_6.help.TextAnalyzer;
import study.java_lessons.lesson_3_6.wclasses.help.KeywordAnalyzer;

public class NegativeTextAnalyzer extends KeywordAnalyzer implements TextAnalyzer {
    protected static final String[] keyWords = {":(", "=(", ":|"};

    @Override
    public Label processText(String text) {
        return findKey(text, keyWords) ? Label.NEGATIVE_TEXT : Label.OK;
    }
}
