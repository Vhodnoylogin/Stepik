package test.lesson_6_4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import study.java_lessons.lesson_6_4.FindMinMax;
import test.TestClass;

import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class TestFindMinMax extends TestClass {

    private static final BiConsumer<Integer, Integer> minMaxConsumer = (x, y) -> logger.info(x + " " + y);

    @Test
    public void rand1() {
        BiConsumer<Integer, Integer> bI = minMaxConsumer
                .andThen((x, y) -> Assertions.assertEquals(x, 0))
                .andThen((x, y) -> Assertions.assertEquals(y, 9));
        FindMinMax.findMinMax(
                Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
                , Integer::compareTo
                , bI
        );
    }

    @Test
    public void rand2() {
        BiConsumer<Integer, Integer> bI = minMaxConsumer
                .andThen((x, y) -> Assertions.assertEquals(x, 2))
                .andThen((x, y) -> Assertions.assertEquals(y, 7));
        FindMinMax.findMinMax(
                Stream.of(2, 6, 7)
                , Integer::compareTo
                , bI
        );
    }

    @Test
    public void randEnpty() {
        BiConsumer<Integer, Integer> bI = minMaxConsumer
                .andThen((x, y) -> Assertions.assertNull(x))
                .andThen((x, y) -> Assertions.assertNull(y));
        FindMinMax.findMinMax(
                Stream.empty()
                , Integer::compareTo
                , bI
        );
    }
}
