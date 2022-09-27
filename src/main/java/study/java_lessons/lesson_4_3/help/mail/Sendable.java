package study.java_lessons.lesson_4_3.help.mail;

/*
Интерфейс: сущность, которую можно отправить по почте.
У такой сущности можно получить от кого и кому направляется письмо.
*/
public interface Sendable {
    String getFrom();

    String getTo();
}
