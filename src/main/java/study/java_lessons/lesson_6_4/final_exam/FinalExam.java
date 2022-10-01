package study.java_lessons.lesson_6_4.final_exam;


import java.util.*;
import java.util.function.Consumer;

public class FinalExam {
    public static class MailMessage extends Msg<String> {
        public MailMessage(String from, String to, String content) {
            super(from, to, content);
        }
    }

    public static class MailService<T> implements Consumer<Msg<T>> {
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

    static class MapOfLists<T> extends HashMap<String, List<T>> {
        @Override
        public List<T> get(Object key) {
            return super.getOrDefault(key, Collections.emptyList());
        }
    }

    public abstract static class Msg<T> {
        protected String from, to;
        protected T content;

        public Msg(String from, String to, T content) {
            this.from = from;
            this.to = to;
            this.content = content;
        }

        public String getFrom() {
            return from;
        }

        public String getTo() {
            return to;
        }

        public T getContent() {
            return content;
        }
    }

    public static class Salary extends Msg<Integer> {
        public Salary(String from, String to, Integer content) {
            super(from, to, content);
        }
    }
}
