package study.java_lessons.lesson_3_5;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class AsciiCharSequence implements CharSequence {
    protected byte[] bytes;

    public AsciiCharSequence(char... chars) {
        this.bytes = new byte[chars.length];

        for (int i = 0; i < chars.length; i++) {
            this.bytes[i] = (byte) chars[i];
        }
    }

    public AsciiCharSequence(byte... bytes) {
        this.bytes = bytes;
    }

    @Override
    public int length() {
        return this.bytes.length;
    }

    @Override
    public char charAt(int i) {
        return (char) this.bytes[i];
    }

    @Override
    public AsciiCharSequence subSequence(int i, int i1) {
        return new AsciiCharSequence(Arrays.copyOfRange(this.bytes, i, i1));
    }

    @Override
    public String toString() {
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
