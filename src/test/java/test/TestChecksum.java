package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static study.java_lessons.lesson_5_2.Checksum.checkSumOfStream;

public class TestChecksum {
    @Test
    public void tezd() {
        byte[] initialArray = {0x33, 0x45, 0x01};
        InputStream targetStream = new ByteArrayInputStream(initialArray);

        try {
            int res = checkSumOfStream(targetStream);
            Assertions.assertEquals(res, 71);
        } catch (IOException e) {
            Assertions.fail(e.getMessage());
        }
    }
}
