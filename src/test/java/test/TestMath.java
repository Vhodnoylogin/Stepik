package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import study.java_lessons.lesson_3_4.ComplexNumber;

public class TestMath {

    @Test
    public void testComp() {
        ComplexNumber cn1 = new ComplexNumber(2.3412, 7.2434);
        ComplexNumber cn2 = new ComplexNumber(2.3412, 7.2434);
        ComplexNumber cn3 = new ComplexNumber(3.23124, 1435.23);
        Assertions.assertEquals(cn1, cn2);
        Assertions.assertEquals(cn2, cn1);
        Assertions.assertNotEquals(cn2, cn3);
        Assertions.assertNotEquals(cn3, cn1);
        Assertions.assertEquals(cn1, cn1);
        Assertions.assertEquals(cn1.hashCode(), cn2.hashCode());
        Assertions.assertEquals(cn2.hashCode(), cn1.hashCode());
        Assertions.assertNotEquals(cn3.hashCode(), cn1.hashCode());
        Assertions.assertNotEquals(cn3.hashCode(), cn2.hashCode());
    }
}
