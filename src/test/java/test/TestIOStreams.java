package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import study.java_lessons.lesson_5_2.Main;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.logging.Logger;


public class TestIOStreams {
    Logger logger = Logger.getLogger(TestIOStreams.class.getName());
    byte[] arr = new byte[]{65, 13, 10, 10, 13};
    byte[] resEth = new byte[]{65, 10, 10, 13};
    Main.TokenComparator comparator = new Main.TokenComparator();

    @Test
    public void testStream() throws IOException {
        try (InputStream in = new ByteArrayInputStream(arr);
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream(arr.length)
        ) {
            Main.convert(in, outputStream);
            var res = outputStream.toByteArray();
            logger.info(Arrays.toString(arr) + " " + Arrays.toString(res) + " " + Arrays.toString(resEth));
            Assertions.assertArrayEquals(res, resEth);
        }
    }

    @Test
    public void tstToken() {
        int it = 0;
        var flag = comparator.put(arr[it++]);
        logger.info(flag.toString() + " " + comparator.getFlag().toString());
        Assertions.assertEquals(flag, comparator.getFlag());
        if (Main.TokenComparator.TokenFlags.CONTINUE != comparator.getFlag()) {
            logger.info(Arrays.toString(comparator.getBuffer()));
        }

        flag = comparator.put(arr[it++]);
        logger.info(flag.toString() + " " + comparator.getFlag().toString());
        Assertions.assertEquals(flag, comparator.getFlag());
        if (Main.TokenComparator.TokenFlags.CONTINUE != comparator.getFlag()) {
            logger.info(Arrays.toString(comparator.getBuffer()));
        }

        flag = comparator.put(arr[it++]);
        logger.info(flag.toString() + " " + comparator.getFlag().toString());
        Assertions.assertEquals(flag, comparator.getFlag());
        if (Main.TokenComparator.TokenFlags.CONTINUE != comparator.getFlag()) {
            logger.info(Arrays.toString(comparator.getBuffer()));
        }

        flag = comparator.put(arr[it++]);
        logger.info(flag.toString() + " " + comparator.getFlag().toString());
        Assertions.assertEquals(flag, comparator.getFlag());
        if (Main.TokenComparator.TokenFlags.CONTINUE != comparator.getFlag()) {
            logger.info(Arrays.toString(comparator.getBuffer()));
        }

        flag = comparator.put(arr[it++]);
        logger.info(flag.toString() + " " + comparator.getFlag().toString());
        Assertions.assertEquals(flag, comparator.getFlag());
        if (Main.TokenComparator.TokenFlags.CONTINUE != comparator.getFlag()) {
            logger.info(Arrays.toString(comparator.getBuffer()));
        }

        if (Main.TokenComparator.TokenFlags.CONTINUE == comparator.getFlag()) {
            logger.info(Arrays.toString(comparator.getBuffer()));
        }
    }

    @Test
    public void testLoopToken() {
        var comparator = new Main.TokenComparator();
        byte[] res = new byte[0];
        for (int b : arr) {
            if (Main.TokenComparator.TokenFlags.CONTINUE != comparator.put((byte) b)) {
                for (byte b1 : comparator.getBuffer()) {
                    res = Arrays.copyOf(res, res.length + 1);
                    res[res.length - 1] = b1;
                }
            }
        }
        if (Main.TokenComparator.TokenFlags.CONTINUE == comparator.getFlag()) {
            for (byte b1 : comparator.getBuffer()) {
                res = Arrays.copyOf(res, res.length + 1);
                res[res.length - 1] = b1;
            }
        }
        logger.info(Arrays.toString(res) + " " + Arrays.toString(resEth));
        Assertions.assertArrayEquals(res, resEth);
    }
}
