package test.lesson_5_3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import study.java_lessons.lesson_5_3.Main;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

public class TestPrint {

    Logger logger = Logger.getLogger(Main.class.getName());

    public static String outToString(ByteArrayOutputStream out) {
        return out.toString(StandardCharsets.UTF_8);
    }

    @Test
    public void testPrint1() {
        String str = "1 2 3";
        InputStream in = new ByteArrayInputStream(str.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream(str.getBytes(StandardCharsets.UTF_8).length);

        Main.work(in, out);
        String res = outToString(out);
        logger.info(res);
        Assertions.assertEquals(res, "6,000000");
    }

    @Test
    public void testPrint2() {
        String str = "a1 b2 c3";
        InputStream in = new ByteArrayInputStream(str.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream(str.getBytes(StandardCharsets.UTF_8).length);

        Main.work(in, out);
        String res = outToString(out);
        logger.info(res);
        Assertions.assertEquals(res, "0,000000");
    }

    @Test
    public void testPrint3() {
        String str = "-1e3\n" +
                "18 .111 11bbb";
        InputStream in = new ByteArrayInputStream(str.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream(str.getBytes(StandardCharsets.UTF_8).length);

        Main.work(in, out);
        String res = outToString(out);
        logger.info(res);
        Assertions.assertEquals(res, "-981,889000");
    }
}
