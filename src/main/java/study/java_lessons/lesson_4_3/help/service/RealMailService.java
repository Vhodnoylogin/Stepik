package study.java_lessons.lesson_4_3.help.service;

import study.java_lessons.lesson_4_3.help.mail.Sendable;

/*
Класс, в котором скрыта логика настоящей почты
*/
public class RealMailService implements MailService {

    @Override
    public Sendable processMail(Sendable mail) {
        // Здесь описан код настоящей системы отправки почты.
        return mail;
    }
}