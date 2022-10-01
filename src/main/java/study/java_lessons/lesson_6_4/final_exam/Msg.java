package study.java_lessons.lesson_6_4.final_exam;

public abstract class Msg<T> {
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
