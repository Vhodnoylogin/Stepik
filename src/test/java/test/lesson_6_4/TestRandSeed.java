package test.lesson_6_4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import study.java_lessons.lesson_6_4.RandSeed;
import test.TestClass;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestRandSeed extends TestClass {
    @Test
    public void rand() {
        List<Integer> expec = Arrays.asList(13, 16, 25, 62, 384, 745, 502, 200, 0);
        List<Integer> res =
                RandSeed.pseudoRandomStream(13)
                        .peek(x -> logger.info(String.valueOf(x)))
                        .limit(9)
                        .boxed()
                        .collect(Collectors.toList());
        Assertions.assertEquals(res, expec);
    }
}
