package study.java_lessons.lesson_5_3;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class InputToString {
    public static void main(String[] args) throws IOException {
        InputStream in = new ByteArrayInputStream(new byte[]{48, 49, 50, 51});
        System.out.println(readAsString(in, StandardCharsets.US_ASCII));
    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        Reader reader = new BufferedReader(new InputStreamReader(inputStream, charset));
        StringBuilder stringBuffer = new StringBuilder();
        int b;
        while ((b = reader.read()) > 0) {
            stringBuffer.append((char) b);
        }
        return stringBuffer.toString();
    }
}
