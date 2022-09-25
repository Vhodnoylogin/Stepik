package study.java_lessons.lesson_2_4;

import java.io.IOException;
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
            System.out.println(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected static String readFromFile(String path) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            return stream.collect(Collectors.joining("\n"));
        }

//        try (
//            FileInputStream fis = new FileInputStream(path);
//            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
//            BufferedReader reader = new BufferedReader(isr)
//        ) {
//            String sCurrentLine;
//            while ((sCurrentLine = reader.readLine()) != null) {
//                System.out.println(sCurrentLine);
//            }
//        }
//
//        try (
//                FileReader fis = new FileReader(path);
//                BufferedReader reader = new BufferedReader(fis)
//        ) {
//            String sCurrentLine;
//            while ((sCurrentLine = reader.readLine()) != null) {
//                System.out.println(sCurrentLine);
//            }
////            return reader.lines().collect(Collectors.joining("\n"));
//        }

//        return "DFDFG";
    }
}
