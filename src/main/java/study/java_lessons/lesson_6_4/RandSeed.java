package study.java_lessons.lesson_6_4;

import java.util.stream.IntStream;

public class RandSeed {
    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, n -> n * n / 10 % 1000);
    }
}
