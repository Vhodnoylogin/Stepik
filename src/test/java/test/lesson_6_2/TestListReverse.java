package test.lesson_6_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import study.java_lessons.lesson_6_2.Main;
import test.TestClass;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class TestListReverse extends TestClass {


    @Test
    public void test() throws IOException {
        var out = new ByteArrayOutputStream();
        Main.listReverse(
                new ByteArrayInputStream("1 2 3 4 5 6 7".getBytes(StandardCharsets.UTF_8))
                , out
        );
        String res = out.toString(StandardCharsets.UTF_8);
        logger.info("|" + res + "|");
        Assertions.assertEquals(res, "6 4 2");
    }
}
