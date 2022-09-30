package study.java_lessons.lesson_6_2;

import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference {
    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> res1 = new HashSet<>(set1);
        Set<T> res2 = new HashSet<>(set2);

        res1.removeAll(set2);
        res2.removeAll(set1);
        res1.addAll(res2);
        return res1;
    }
}
