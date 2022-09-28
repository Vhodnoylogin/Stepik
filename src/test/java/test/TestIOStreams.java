package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import study.java_lessons.lesson_5_2.Main;
import study.java_lessons.lesson_5_2.TokenComparator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.logging.Logger;


public class TestIOStreams {
    Logger logger = Logger.getLogger(TestIOStreams.class.getName());
//    byte[] arr = new byte[]{65, 13, 10, 10, 13};
//    byte[] resEth = new byte[]{65, 10, 10, 13};

    byte[] arr = {65, 66, 13, 13, 10, 10, 13, 67, 13, 13};
    byte[] resEth = {65, 66, 13, 10, 10, 13, 67, 13, 13};

    private static final String NEW_LINE = System.lineSeparator();
    TokenComparator comparator = new TokenComparator();

    @Test
    public void testStream() throws IOException {
        try (InputStream in = new ByteArrayInputStream(arr);
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream(arr.length)
        ) {
            Main.convert(in, outputStream);
            var res = outputStream.toByteArray();
            logger.info(NEW_LINE + Arrays.toString(arr) + NEW_LINE + Arrays.toString(res) + NEW_LINE + Arrays.toString(resEth));
            Assertions.assertArrayEquals(res, resEth);
        }
    }

    @Test
    public void testEmptyStream() throws IOException {
        try (InputStream in = new ByteArrayInputStream(new byte[0]);
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream(arr.length)
        ) {
            Main.convert(in, outputStream);
            var res = outputStream.toByteArray();
            logger.info(Arrays.toString(res) + " " + Arrays.toString(new byte[0]));
            Assertions.assertArrayEquals(res, new byte[0]);
        }
    }


    @Test
    public void tstToken() {
        int it = 0;
        var flag = comparator.put(arr[it++]);
        logger.info(flag.toString() + " " + comparator.getFlag().toString());
        Assertions.assertEquals(flag, comparator.getFlag());
        if (TokenComparator.TokenFlags.CONTINUE != comparator.getFlag()) {
            logger.info(Arrays.toString(comparator.getBuffer()));
        }

        flag = comparator.put(arr[it++]);
        logger.info(flag.toString() + " " + comparator.getFlag().toString());
        Assertions.assertEquals(flag, comparator.getFlag());
        if (TokenComparator.TokenFlags.CONTINUE != comparator.getFlag()) {
            logger.info(Arrays.toString(comparator.getBuffer()));
        }

        flag = comparator.put(arr[it++]);
        logger.info(flag.toString() + " " + comparator.getFlag().toString());
        Assertions.assertEquals(flag, comparator.getFlag());
        if (TokenComparator.TokenFlags.CONTINUE != comparator.getFlag()) {
            logger.info(Arrays.toString(comparator.getBuffer()));
        }

        flag = comparator.put(arr[it++]);
        logger.info(flag.toString() + " " + comparator.getFlag().toString());
        Assertions.assertEquals(flag, comparator.getFlag());
        if (TokenComparator.TokenFlags.CONTINUE != comparator.getFlag()) {
            logger.info(Arrays.toString(comparator.getBuffer()));
        }

        flag = comparator.put(arr[it++]);
        logger.info(flag.toString() + " " + comparator.getFlag().toString());
        Assertions.assertEquals(flag, comparator.getFlag());
        if (TokenComparator.TokenFlags.CONTINUE != comparator.getFlag()) {
            logger.info(Arrays.toString(comparator.getBuffer()));
        }

        if (TokenComparator.TokenFlags.CONTINUE == comparator.getFlag()) {
            logger.info(Arrays.toString(comparator.getBuffer()));
        }
    }

}
