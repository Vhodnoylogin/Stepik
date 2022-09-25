package study.java_lessons.lesson_2_4;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Work {

    protected static final String SEP = ":";
    protected static final String END_LINE = "\n";


    public static void main(String[] args) {
//        System.out.println("TEST");


        String path = "E:\\IdeaProjects\\Stepik\\src\\main\\resources\\source.txt";
        try {
            Text text = new Text(path);
            String res = printTextPerRole(text.getRoles(), text.getTextLines());
            ps.println(res);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected static PrintStream ps = new PrintStream(System.out, true, StandardCharsets.UTF_8);

    protected static String printTextPerRole(String[] roles, String[] textLines) {
        Map<String, StringBuilder> roleText = new HashMap<>();
        for (String role : roles) {
            roleText.put(role + SEP, new StringBuilder());
        }
        for (int i = 0; i < textLines.length; i++) {
            String line = textLines[i];
            findRole(line, roleText, i + 1);
        }
        StringBuilder res = new StringBuilder();
        for (String role : roles) {
            StringBuilder string = roleText.get(role + SEP);
            res.append(role).append(SEP).append(END_LINE).append(string).append(END_LINE);
        }
        return res.toString().trim();
    }

    protected static void findRole(String text, Map<String, StringBuilder> roleText, int num) {
        int index = text.indexOf(SEP) + 1;
        String role = text.substring(0, index);
        text = text.substring(index);
        StringBuilder texts = roleText.get(role);
        if (texts != null) texts.append(num).append(")").append(text).append(END_LINE);
    }

}
