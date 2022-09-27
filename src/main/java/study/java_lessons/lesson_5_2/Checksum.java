package study.java_lessons.lesson_5_2;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Checksum {
    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int b, checksum = 0;
        while ((b = inputStream.read()) > 0) {
            checksum = Integer.rotateLeft(checksum, 1) ^ b;
        }
        return checksum;
    }

    public static void main(String[] args) {
        byte[] initialArray = {0x33, 0x45, 0x01};
        InputStream targetStream = new ByteArrayInputStream(initialArray);

        try {
            int res = checkSumOfStream(targetStream);
            System.out.println(res);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
