package study.java_lessons.lesson_2_4;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Work {

    protected static final String SEP = ":";

    public static void main(String[] args) {
//        System.out.println("TEST");


        String path = "E:\\IdeaProjects\\Stepik\\src\\main\\resources\\source.txt";
        try {
            Text text = new Text(path);
            ps.println(printTextPerRole(text.getRoles(), text.getTextLines()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected static PrintStream ps = new PrintStream(System.out, true, StandardCharsets.UTF_8);

    protected static String printTextPerRole(String[] roles, String[] textLines) {
        Map<String, List<String>> roleText = new HashMap<>();
        for (String role : roles) {
            roleText.put(role + SEP, new ArrayList<>(10));
        }
        for (int i = 0; i < textLines.length; i++) {
            String line = textLines[i];
            findRole(line, roleText, i + 1);
        }
        ps.println(roleText);
        return "";
    }

    protected static void findRole(String text, Map<String, List<String>> roleText, int num) {
        int index = text.indexOf(SEP) + 1;
        String role = text.substring(0, index);
        text = text.substring(index);
//        List<String> texts = roleText.getOrDefault(role, null);
        List<String> texts = roleText.get(role);
        if (texts != null) texts.add(num + ")" + text);
    }

}
