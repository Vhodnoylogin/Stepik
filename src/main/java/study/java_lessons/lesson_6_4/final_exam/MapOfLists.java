package study.java_lessons.lesson_6_4.final_exam;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class MapOfLists<T> extends HashMap<String, List<T>> {
    @Override
    public List<T> get(Object key) {
        return super.getOrDefault(key, Collections.emptyList());
    }
}
