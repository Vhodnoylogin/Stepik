package study.java_lessons.lesson_5_3;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ShowASCII {
    public static void main(String[] args) throws IOException {
        String str = "КВАС";
        OutputStream out = new ByteArrayOutputStream(8);
        Writer writer = new OutputStreamWriter(out, StandardCharsets.US_ASCII);
        try (out; writer) {
            writer.write(str);
            writer.flush();
        }
        System.out.println(out);
    }
}
