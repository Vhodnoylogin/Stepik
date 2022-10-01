package study.java_lessons.lesson_6_4.final_exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Msg<T>> {
    private final Map<String, List<T>> mailBox = new MapOfLists<>();

    @Override
    public void accept(Msg<T> msg) {
        List<T> l = this.mailBox.getOrDefault(msg.getTo(), new ArrayList<>());
        l.add(msg.getContent());
        this.mailBox.put(msg.getTo(), l);
    }

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }

}
