package test.lesson_6_1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import study.java_lessons.lesson_6_1.Pair;

import java.util.logging.Logger;

public class TestPair {

    Logger logger = Logger.getLogger(Pair.class.getName());

    @Test
    public void test() {
        final Integer i = 1;
        final String s = "hello";

        Pair<Integer, String> pair = Pair.of(i, s);
        logger.info(pair.toString());
        Assertions.assertEquals(i, pair.getFirst()); // 1
        Assertions.assertEquals(s, pair.getSecond()); // "hello"


        Pair<Integer, String> pair2 = Pair.of(i, s);
        Assertions.assertEquals(pair, pair);
        Assertions.assertEquals(pair2, pair);
        Assertions.assertEquals(pair.hashCode(), pair2.hashCode());
    }
}
