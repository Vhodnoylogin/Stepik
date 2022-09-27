package study.java_lessons.lesson_4_3.actors;

import study.java_lessons.lesson_4_3.help.mail.MailMessage;
import study.java_lessons.lesson_4_3.help.mail.Sendable;
import study.java_lessons.lesson_4_3.help.service.MailService;

import java.util.logging.Level;
import java.util.logging.Logger;

import static study.java_lessons.lesson_4_3.Work.AUSTIN_POWERS;

public class Spy implements MailService {
    protected static final String WARN_MSG = "Detected target mail correspondence: from {from} to {to} \"{message}\"";
    protected static final String INFO_MSG = "Usual correspondence: from {from} to {to}";
    protected Logger logger;

    public Spy(Logger logger) {
        this.logger = logger;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (!(mail instanceof MailMessage)) return mail;

        String from = mail.getFrom();
        String to = mail.getTo();
        if (from.indexOf(AUSTIN_POWERS) == 0 || to.indexOf(AUSTIN_POWERS) == 0) {
            this.logger.log(
                    Level.INFO
                    , INFO_MSG
                    , new Object[]{from, to}
            );
        } else {
            this.logger.log(
                    Level.WARNING
                    , WARN_MSG
                    , new Object[]{from, to, ((MailMessage) mail).getMessage()}
            );
        }
        return mail;
    }
}
