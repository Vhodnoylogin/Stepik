package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import study.java_lessons.lesson_3_5.AsciiCharSequence;

public class TestAsciiChar {
    @Test
    public void testString() {
        AsciiCharSequence test = new AsciiCharSequence('a', 'b', 't');

//        System.out.println(test);
//        System.out.println(test.subSequence(1, 2));
//        System.out.println(test.length());

        Assertions.assertEquals("abt", test.toString());
        Assertions.assertEquals("b", test.subSequence(1, 2).toString());
        Assertions.assertEquals(3, test.length());
    }
}
