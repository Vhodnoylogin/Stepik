package study.java_lessons.lesson_2_4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Text {
    protected static final String SPLIT = "\n";
    protected static final String ROLE_SEP = "roles:" + SPLIT;
    protected static final String TEXT_SEP = "textLines:" + SPLIT;

    protected String[] roles;
    protected String[] textLines;

    public Text(String path) throws IOException {
        String text = readFromFile(path);
        this.roles = roles(text);
        this.textLines = textLines(text);
    }

    protected static String readFromFile(String path) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            return stream.collect(Collectors.joining("\n"));
        }
    }

    protected static String[] roles(String text) {
        return text.substring(
                text.indexOf(ROLE_SEP) + ROLE_SEP.length()
                , text.indexOf(TEXT_SEP)
        ).split(SPLIT);
    }

    protected static String[] textLines(String text) {
        return text.substring(
                text.indexOf(TEXT_SEP) + TEXT_SEP.length()
        ).split(SPLIT);
    }

    public String[] getRoles() {
        return roles;
    }

    public String[] getTextLines() {
        return textLines;
    }
}
