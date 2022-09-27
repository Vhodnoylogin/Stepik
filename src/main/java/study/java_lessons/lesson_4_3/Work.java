package study.java_lessons.lesson_4_3;

import study.java_lessons.lesson_4_3.actors.Inspector;
import study.java_lessons.lesson_4_3.actors.Spy;
import study.java_lessons.lesson_4_3.actors.Thief;
import study.java_lessons.lesson_4_3.actors.UntrustworthyMailWorker;
import study.java_lessons.lesson_4_3.help.Package;
import study.java_lessons.lesson_4_3.help.mail.MailMessage;
import study.java_lessons.lesson_4_3.help.mail.MailPackage;
import study.java_lessons.lesson_4_3.help.service.MailService;

import java.util.logging.Logger;

public class Work {
    public static void main(String[] args) {
        MailService spy = new Spy(Logger.getLogger(Class.class.getName()));
        Thief thief = new Thief(10);
        MailService inspector = new Inspector();
        MailService[] msArray = {spy, thief, inspector};
        MailMessage mail1 = new MailMessage("Romeo", "Juliet", "I love you!");
        MailMessage mail2 = new MailMessage("Austin Powers", "James Bond", "Big secret!");
        MailPackage mail3 = new MailPackage("Romeo", "Juliet", new Package("Flowers", 15));
        MailPackage mail4 = new MailPackage("Romeo", "Juliet", new Package("Flowers", 25));
        MailPackage mail5 = new MailPackage("Austin Powers", "James Bond", new Package("weapons", 5));

        UntrustworthyMailWorker umw = new UntrustworthyMailWorker(msArray);
        try {
            umw.processMail(mail1);
        } catch (RuntimeException re) {
            System.out.println(re.getMessage());
        }
        try {
            umw.processMail(mail2);
        } catch (RuntimeException re) {
            System.out.println(re.getMessage());
        }
        try {
            umw.processMail(mail3);
        } catch (RuntimeException re) {
            System.out.println(re.getMessage());
        }
        try {
            umw.processMail(mail4);
        } catch (RuntimeException re) {
            System.out.println(re.getMessage());
        }
        try {
            umw.processMail(mail5);
        } catch (RuntimeException re) {
            System.out.println(re.getMessage());
        }

        System.out.println("Thief have stolen $" + thief.getStolenValue() + "!");
    }
}
