package study.java_lessons.lesson_3_6.wclasses;

import study.java_lessons.lesson_3_6.help.Label;
import study.java_lessons.lesson_3_6.help.TextAnalyzer;
import study.java_lessons.lesson_3_6.wclasses.help.KeywordAnalyzer;

public class SpamAnalyzer extends KeywordAnalyzer implements TextAnalyzer {

    protected String[] keyWords;

    public SpamAnalyzer(String[] keyWords) {
        this.keyWords = keyWords;
    }

    @Override
    public Label processText(String text) {
        return findKey(text, keyWords) ? Label.SPAM : Label.OK;
    }
}
