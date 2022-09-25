package study.java_lessons.lesson_3_6;

import study.java_lessons.lesson_3_6.help.Label;
import study.java_lessons.lesson_3_6.help.TextAnalyzer;

public class Work {
    public Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer analyzer : analyzers) {
            Label test = analyzer.processText(text);
            if (test != Label.OK) return test;
        }
        return Label.OK;
    }
}
