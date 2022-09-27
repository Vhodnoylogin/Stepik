package study.java_lessons.lesson_4_3.actors;

import study.java_lessons.lesson_4_3.help.mail.Sendable;
import study.java_lessons.lesson_4_3.help.service.MailService;
import study.java_lessons.lesson_4_3.help.service.RealMailService;

public class UntrustworthyMailWorker implements MailService {

    protected final MailService realMailService = new RealMailService();
    protected MailService[] nodes;

    public UntrustworthyMailWorker(MailService[] nodes) {
        this.nodes = nodes;
    }

    public MailService getRealMailService() {
        return realMailService;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        Sendable m = mail;
        for (MailService node : this.nodes) {
            m = node.processMail(m);
        }
        return this.realMailService.processMail(m);
    }
}
