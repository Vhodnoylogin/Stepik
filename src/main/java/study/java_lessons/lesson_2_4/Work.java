package study.java_lessons.lesson_2_4;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Work {
    public static void main(String[] args) {
//        System.out.println("TEST");


        String path = "E:\\IdeaProjects\\Stepik\\src\\main\\resources\\source.txt";
        try {
            String text = readFromFile(path);
//            System.out.println(text);
            PrintStream ps = new PrintStream(System.out, true, StandardCharsets.UTF_8);
            ps.println(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected static String readFromFile(String path) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            return stream.collect(Collectors.joining("\n"));
        }
    }
}
