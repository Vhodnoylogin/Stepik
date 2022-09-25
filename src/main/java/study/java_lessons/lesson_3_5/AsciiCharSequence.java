package study.java_lessons.lesson_3_5;

import java.util.Arrays;

public class AsciiCharSequence implements CharSequence {
    protected char[] chars;

    public AsciiCharSequence(char... chars) {
        this.chars = chars;
    }

    @Override
    public int length() {
        return this.chars.length;
    }

    @Override
    public char charAt(int i) {
        return this.chars[i];
    }

    @Override
    public AsciiCharSequence subSequence(int i, int i1) {
        return new AsciiCharSequence(Arrays.copyOfRange(this.chars, i, i1));
    }

    @Override
    public String toString() {
        return Arrays.toString(this.chars);
    }
}
