package study.java_lessons.lesson_5_3;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class InputToString {
    public static void main(String[] args) throws IOException {
        InputStream in = new ByteArrayInputStream(new byte[]{48, 49, 50, 51});
        System.out.println(readAsString(in, StandardCharsets.US_ASCII));
    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        return new BufferedReader(
                new InputStreamReader(inputStream, charset)
        )
                .lines()
                .collect(Collectors.joining(""));
    }
}
