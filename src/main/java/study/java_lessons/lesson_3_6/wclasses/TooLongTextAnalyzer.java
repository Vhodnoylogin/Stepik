package study.java_lessons.lesson_3_6.wclasses;

import study.java_lessons.lesson_3_6.help.Label;
import study.java_lessons.lesson_3_6.help.TextAnalyzer;

public class TooLongTextAnalyzer implements TextAnalyzer {
    protected int maxLen;

    public TooLongTextAnalyzer(int maxLen) {
        this.maxLen = maxLen;
    }

    @Override
    public Label processText(String text) {
        return text.length() > this.maxLen ? Label.TOO_LONG : Label.OK;
    }
}
