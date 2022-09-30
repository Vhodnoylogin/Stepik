package test.lesson_6_3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import study.java_lessons.lesson_6_3.Main;
import test.TestClass;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestTernaryOperator extends TestClass {
    @Test
    public void test1() {
        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<Integer, Integer> ifFalse = Integer::valueOf;
        Function<Integer, Integer> safeStringLength = Main.ternaryOperator(condition, ifTrue, ifFalse);

        List<Integer> res = Stream.of(1, 2, 3, null, 5).map(safeStringLength).collect(Collectors.toList());
        Assertions.assertEquals(res, Arrays.asList(1, 2, 3, 0, 5));
    }
}
