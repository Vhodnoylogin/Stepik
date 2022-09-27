package study.java_lessons.lesson_4_3.actors;

import study.java_lessons.lesson_4_3.help.MailService;
import study.java_lessons.lesson_4_3.help.Sendable;

public class UntrustworthyMailWorker implements MailService {
    @Override
    public Sendable processMail(Sendable mail) {
        return null;
    }
}
