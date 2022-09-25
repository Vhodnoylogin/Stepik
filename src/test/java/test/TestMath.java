package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static study.java_lessons.lesson_3_5.Integrate.integrate;

public class TestMath {
    public static final double INFELICITY = 1E-5;

    @Test
    public void testIntegrals() {
        Assertions.assertEquals(10.0, integrate(x -> 1, 0, 10), INFELICITY);//10.0
        Assertions.assertEquals(70.0, integrate(x -> x + 2, 0, 10), INFELICITY);//70.0
        Assertions.assertEquals(0.603848, integrate(x -> Math.sin(x) / x, 1, 5), INFELICITY);//0.603848
    }
}
