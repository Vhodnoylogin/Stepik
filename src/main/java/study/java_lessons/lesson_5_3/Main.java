package study.java_lessons.lesson_5_3;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        work(System.in, System.out);
    }

    public static void work(InputStream in, OutputStream out) {
        Scanner scanner = new Scanner(in)
                .useLocale(Locale.ENGLISH)
                .useLocale(Locale.PRC);
        double sum = 0.;
        while (scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                sum += scanner.nextDouble();
            } else {
                scanner.next();
            }
        }
        PrintWriter writer = new PrintWriter(out);
        writer.printf("%.6f", sum);
        writer.flush();
    }
}
