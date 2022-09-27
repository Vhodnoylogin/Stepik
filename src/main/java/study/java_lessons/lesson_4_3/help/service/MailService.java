package study.java_lessons.lesson_4_3.help.service;

import study.java_lessons.lesson_4_3.help.mail.Sendable;

/*
Интерфейс, который задает класс, который может каким-либо образом обработать почтовый объект.
*/
public interface MailService {
    Sendable processMail(Sendable mail);
}
