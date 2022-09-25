package study.java_lessons.lesson_2_4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class Work {
    public static void main(String[] args) {
//        System.out.println("TEST");

        String path = "E:\\IdeaProjects\\Stepik\\src\\main\\resources\\source.txt";
        try {
            System.out.println(readFromFile(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected static String readFromFile(String path) throws IOException {
//        Path file = Paths.get(path);
//        return Files.lines(file).collect(Collectors.joining("\n"));

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
        try (reader) {
            return reader.lines().collect(Collectors.joining("\n"));
        }
    }
}
