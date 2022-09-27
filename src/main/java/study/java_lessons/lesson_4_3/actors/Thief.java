package study.java_lessons.lesson_4_3.actors;

import study.java_lessons.lesson_4_3.help.Package;
import study.java_lessons.lesson_4_3.help.mail.MailPackage;
import study.java_lessons.lesson_4_3.help.mail.Sendable;
import study.java_lessons.lesson_4_3.help.service.MailService;

public class Thief implements MailService {
    protected static final String THIEF_MSG = "stones instead of {content}";
    protected int minValueToStole;
    protected int totalStolenAmount = 0;

    public Thief(int minValueToStole) {
        this.minValueToStole = minValueToStole;
    }

    public int getStolenValue() {
        return totalStolenAmount;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (!(mail instanceof MailPackage)) return mail;

        Package pack = ((MailPackage) mail).getContent();
        if (pack.price() < this.minValueToStole) return mail;

        totalStolenAmount += pack.price();
        pack = new Package(
                String.format(THIEF_MSG.replace("{content}", pack.content()))
                , 0
        );
        return new MailPackage(mail.getFrom(), mail.getTo(), pack);
    }
}
