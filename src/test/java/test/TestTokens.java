package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import study.java_lessons.lesson_3_6.Work;
import study.java_lessons.lesson_3_6.help.Label;
import study.java_lessons.lesson_3_6.help.TextAnalyzer;
import study.java_lessons.lesson_3_6.wclasses.NegativeTextAnalyzer;
import study.java_lessons.lesson_3_6.wclasses.SpamAnalyzer;
import study.java_lessons.lesson_3_6.wclasses.TooLongTextAnalyzer;

public class TestTokens {
    String[] spamKeywords = {"spam", "bad"};
    int commentMaxLength = 40;
    TextAnalyzer[] textAnalyzers = {
            new NegativeTextAnalyzer(),
            new TooLongTextAnalyzer(commentMaxLength),
            new SpamAnalyzer(spamKeywords)
    };


    String[] tests = new String[8];
    Label[] labels = {
            Label.OK
            , Label.TOO_LONG
            , Label.NEGATIVE_TEXT
            , Label.NEGATIVE_TEXT
            , Label.SPAM
            , Label.TOO_LONG
            , Label.NEGATIVE_TEXT
            , Label.NEGATIVE_TEXT
    };

    {
        tests[0] = "This comment is so good.";                            // OK
        tests[1] = "This comment is so Loooooooooooooooooooooooooooong."; // TOO_LONG
        tests[2] = "Very negative comment !!!!=(!!!!;";                   // NEGATIVE_TEXT
        tests[3] = "Very BAAAAAAAAAAAAAAAAAAAAAAAAD comment with :|;";    // NEGATIVE_TEXT or TOO_LONG
        tests[4] = "This comment is so bad....";                          // SPAM
        tests[5] = "The comment is a spam, maybeeeeeeeeeeeeeeeeeeeeee!";  // SPAM or TOO_LONG
        tests[6] = "Negative bad :( spam.";                               // SPAM or NEGATIVE_TEXT
        tests[7] = "Very bad, very neg =(, very ..................";      // SPAM or NEGATIVE_TEXT or TOO_LONG
    }

    @Test
    public void testToken() {
        Work qql = new Work();
        for (int i = 0; i < tests.length; i++) {
            System.out.println(tests[i]);
            System.out.println(qql.checkLabels(textAnalyzers, tests[i]));
            Assertions.assertEquals(qql.checkLabels(textAnalyzers, tests[i]), labels[i]);
        }
    }

}
