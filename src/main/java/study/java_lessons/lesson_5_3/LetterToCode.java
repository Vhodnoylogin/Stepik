package study.java_lessons.lesson_5_3;

import java.nio.charset.StandardCharsets;

public class LetterToCode {
    public static void main(String[] args) {
        String letter = "Ы";
        var bytes = letter.getBytes(StandardCharsets.UTF_8);
        for (byte aByte : bytes) {
            System.out.printf("%d ", Byte.toUnsignedInt(aByte));
        }

    }
}
