package study.java_lessons.lesson_2_4;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Work {
    public static void main(String[] args) {
//        System.out.println("TEST");


        String path = "E:\\IdeaProjects\\Stepik\\src\\main\\resources\\source.txt";
        try {
            Text text = new Text(path);
            PrintStream ps = new PrintStream(System.out, true, StandardCharsets.UTF_8);
            ps.println(printTextPerRole(text.getRoles(), text.getTextLines()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected static String printTextPerRole(String[] roles, String[] textLines) {
        return "";
    }


}
