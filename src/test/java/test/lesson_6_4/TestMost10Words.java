package test.lesson_6_4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import study.java_lessons.lesson_6_4.Main;
import test.TestClass;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class TestMost10Words extends TestClass {

    static InputStream in;

    static ByteArrayOutputStream out;

    private static void help(String strIn, String exp) {
        in = new ByteArrayInputStream(strIn.getBytes(StandardCharsets.UTF_8));
        out = new ByteArrayOutputStream();
        try {
            Main.most10Words(in, out);
        } catch (IOException e) {
            Assertions.fail();
        }

        String res = out.toString(StandardCharsets.UTF_8);
        logger.info(res);
        Assertions.assertEquals(res, exp);
    }

    @Test
    public void test1() {
        String in = "Мама мыла-мыла-мыла раму!";
        String exp = "мыла\n" +
                "мама\n" +
                "раму";
        help(in, exp);
    }

    @Test
    public void test2() {
        String in = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.";
        String exp = "consectetur\n" +
                "faucibus\n" +
                "ipsum\n" +
                "lorem\n" +
                "adipiscing\n" +
                "amet\n" +
                "dolor\n" +
                "eget\n" +
                "elit\n" +
                "mi";
        help(in, exp);
    }
}
