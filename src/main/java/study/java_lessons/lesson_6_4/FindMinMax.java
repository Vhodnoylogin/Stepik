package study.java_lessons.lesson_6_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindMinMax {
    private final static Logger logger = Logger.getLogger(FindMinMax.class.getName());

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> arr = new ArrayList<>(Arrays.asList(null, null));
        stream
                .peek(x -> {
                    if (arr.get(0) == null) {
                        arr.set(0, x);
                    }
                    if (x == null) return;
                    arr.set(0, order.compare(arr.get(0), x) < 0 ? arr.get(0) : x);
                })
                .peek(x -> {
                    if (arr.get(1) == null) {
                        arr.set(1, x);
                    }
                    if (x == null) return;
                    arr.set(1, order.compare(arr.get(1), x) > 0 ? arr.get(1) : x);
                })
                .collect(Collectors.toList());
        minMaxConsumer.accept(arr.get(0), arr.get(1));
    }
}
