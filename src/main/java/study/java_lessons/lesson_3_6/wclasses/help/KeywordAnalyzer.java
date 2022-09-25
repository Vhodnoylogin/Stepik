package study.java_lessons.lesson_3_6.wclasses.help;

import study.java_lessons.lesson_3_6.help.TextAnalyzer;

public abstract class KeywordAnalyzer implements TextAnalyzer {
    protected boolean findKey(String text, String[] keyWords) {
        for (String keyWord : keyWords) {
            if (text.contains(keyWord)) return true;
        }
        return false;
    }
}
