package study.java_lessons.lesson_4_3.actors;

import study.java_lessons.lesson_4_3.exceptions.IllegalPackageException;
import study.java_lessons.lesson_4_3.exceptions.StolenPackageException;
import study.java_lessons.lesson_4_3.help.Package;
import study.java_lessons.lesson_4_3.help.mail.MailPackage;
import study.java_lessons.lesson_4_3.help.mail.Sendable;
import study.java_lessons.lesson_4_3.help.service.MailService;

public class Inspector implements MailService {

    public static final String STONES = "stones";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    protected static final String[] BANNED = {
            WEAPONS, BANNED_SUBSTANCE
    };

    @Override
    public Sendable processMail(Sendable mail) {
        if (!(mail instanceof MailPackage)) return mail;

        Package pack = ((MailPackage) mail).getContent();
        for (String ban : BANNED) {
            if (pack.content().contains(ban)) throw new IllegalPackageException();
        }
        if (pack.content().contains(STONES)) throw new StolenPackageException();

        return mail;
    }
}
