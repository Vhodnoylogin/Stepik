package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static study.java_lessons.lesson_3_5.Integrate.integrate;

public class TestMath {

    @Test
    public void testIntegrals() {
        Assertions.assertEquals(10.0, integrate(x -> 1, 0, 10));//10.0
        Assertions.assertEquals(integrate(x -> x + 2, 0, 10), 70.0);//70.0
        Assertions.assertEquals(integrate(x -> Math.sin(x) / x, 1, 5), 0.603848);//0.603848
    }
}
