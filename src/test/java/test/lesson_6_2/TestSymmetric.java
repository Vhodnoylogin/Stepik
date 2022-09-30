package test.lesson_6_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import study.java_lessons.lesson_6_2.SymmetricDifference;
import test.TestClass;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TestSymmetric extends TestClass {
    @Test
    public void test() {
        Set<Integer> num1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> num2 = new HashSet<>(Arrays.asList(2, 3, 4));
        Set<Integer> res = new HashSet<>(Arrays.asList(1, 4));

        logger.info(res.toString());
        Assertions.assertEquals(SymmetricDifference.symmetricDifference(num1, num2), res);
    }
}
