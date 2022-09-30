package study.java_lessons.lesson_6_2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        listReverse(System.in, System.out);
    }

    public static void listReverse(InputStream in, OutputStream out) throws IOException {
        Scanner scanner = new Scanner(in)
                .useLocale(Locale.ENGLISH)
                .useDelimiter(" ");
        List<Integer> que = new ArrayList<>();
        while (scanner.hasNext()) {
            que.add(scanner.nextInt());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = que.size() - 1; i >= 0; i--) {
            if (i % 2 == 1) {
                sb.append(que.get(i));
                sb.append(" ");
//                    out.write(que.get(i).toString().getBytes(StandardCharsets.UTF_8));
//                    out.write(" ".getBytes(StandardCharsets.UTF_8));
            }
        }
        out.write(sb.toString().trim().getBytes(StandardCharsets.UTF_8));
    }
}
