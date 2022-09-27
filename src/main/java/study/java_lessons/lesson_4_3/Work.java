package study.java_lessons.lesson_4_3;

import study.java_lessons.lesson_4_3.help.Package;
import study.java_lessons.lesson_4_3.help.mail.AbstractSendable;
import study.java_lessons.lesson_4_3.help.mail.MailMessage;
import study.java_lessons.lesson_4_3.help.mail.MailPackage;
import study.java_lessons.lesson_4_3.help.mail.Sendable;
import study.java_lessons.lesson_4_3.help.service.MailService;
import study.java_lessons.lesson_4_3.help.service.RealMailService;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import static study.java_lessons.lesson_4_3.Work.Spy.AUSTIN_POWERS;

public class Work {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Work.class.getName());

        Inspector inspector = new Inspector();
        Spy spy = new Spy(logger);
        Thief thief = new Thief(10000);
        MailService[] variousWorkers = new MailService[]{spy, thief, inspector};
        UntrustworthyMailWorker worker = new UntrustworthyMailWorker(variousWorkers);

        AbstractSendable[] correspondence = {
                new MailMessage("Oxxxymiron", "Гнойный", "Я здесь чисто по фану, поглумиться над слабым\n" +
                        "Ты же вылез из мамы под мой дисс на Бабана...."),
                new MailMessage("Гнойный", "Oxxxymiron", "....Что? Так болел за Россию, что на нервах терял ганглии.\n" +
                        "Но когда тут проходили митинги, где ты сидел? В Англии!...."),
                new MailMessage("Жриновский", AUSTIN_POWERS, "Бери пацанов, и несите меня к воде."),
                new MailMessage(AUSTIN_POWERS, "Пацаны", "Го, потаскаем Вольфовича как Клеопатру"),
                new MailPackage("берег", "море", new Package("ВВЖ", 32)),
                new MailMessage("NASA", AUSTIN_POWERS, "Найди в России ракетные двигатели и лунные stones"),
                new MailPackage(AUSTIN_POWERS, "NASA", new Package("рпакетный двигатель ", 2500000)),
                new MailPackage(AUSTIN_POWERS, "NASA", new Package("stones", 1000)),
                new MailPackage("Китай", "КНДР", new Package("banned substance", 99)),
                new MailPackage(AUSTIN_POWERS, "ИГИЛ (запрещенная группировка", new Package("tiny bomb", 9000)),
                new MailMessage(AUSTIN_POWERS, "Психиатр", "Помогите"),
        };
        Arrays.stream(correspondence).forEach(parcell -> {
            try {
                worker.processMail(parcell);
            } catch (StolenPackageException e) {
                logger.log(Level.WARNING, "Inspector found stolen package: " + e);
            } catch (IllegalPackageException e) {
                logger.log(Level.WARNING, "Inspector found illegal package: " + e);
            }
        });
    }

    public static class Inspector implements MailService {

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
                if (pack.getContent().contains(ban)) throw new IllegalPackageException();
            }
            if (pack.getContent().contains(STONES)) throw new StolenPackageException();

            return mail;
        }
    }

    public static class Spy implements MailService {
        public static final String AUSTIN_POWERS = "Austin Powers";
        protected static final String WARN_MSG = "Detected target mail correspondence: from {0} to {1} \"{2}\"";
        protected static final String INFO_MSG = "Usual correspondence: from {0} to {1}";
        protected Logger logger;

        public Spy(Logger logger) {
            this.logger = logger;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (!(mail instanceof MailMessage)) return mail;

            String from = mail.getFrom();
            String to = mail.getTo();
            if (from.contains(AUSTIN_POWERS) || to.contains(AUSTIN_POWERS)) {
                this.logger.log(Level.WARNING, WARN_MSG, new Object[]{from, to, ((MailMessage) mail).getMessage()});
            } else {
                this.logger.log(Level.INFO, INFO_MSG, new Object[]{from, to});
            }
            return mail;
        }
    }

    public static class Thief implements MailService {
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
            if (pack.getPrice() < this.minValueToStole) return mail;

            totalStolenAmount += pack.getPrice();
            pack = new Package(
                    String.format(THIEF_MSG.replace("{content}", pack.getContent()))
                    , 0
            );
            return new MailPackage(mail.getFrom(), mail.getTo(), pack);
        }
    }

    public static class UntrustworthyMailWorker implements MailService {

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

    public static class IllegalPackageException extends RuntimeException {
    }

    public static class StolenPackageException extends RuntimeException {
    }


}
