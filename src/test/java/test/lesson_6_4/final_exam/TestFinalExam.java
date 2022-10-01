package test.lesson_6_4.final_exam;

import org.junit.jupiter.api.Test;
import study.java_lessons.lesson_6_4.final_exam.FinalExam;
import test.TestClass;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class TestFinalExam extends TestClass {

    private static final String randomFrom = "..."; // Некоторая случайная строка. Можете выбрать ее самостоятельно.
    private static final String randomTo = "...";  // Некоторая случайная строка. Можете выбрать ее самостоятельно.
    private static final int randomSalary = 100;  // Некоторое случайное целое положительное число. Можете выбрать его самостоятельно.

    @Test
    public void test1() {
        // Создание списка из трех почтовых сообщений.
        FinalExam.MailMessage firstMessage = new FinalExam.MailMessage(
                "Robert Howard",
                "H.P. Lovecraft",
                "This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!"
        );

        assert firstMessage.getFrom().equals("Robert Howard") : "Wrong firstMessage from address";
        assert firstMessage.getTo().equals("H.P. Lovecraft") : "Wrong firstMessage to address";
        assert firstMessage.getContent().endsWith("Howard!") : "Wrong firstMessage content ending";
    }

    @Test
    public void test2() {
        FinalExam.MailMessage firstMessage = new FinalExam.MailMessage(
                "Robert Howard",
                "H.P. Lovecraft",
                "This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!"
        );

        FinalExam.MailMessage secondMessage = new FinalExam.MailMessage(
                "Jonathan Nolan",
                "Christopher Nolan",
                "Брат, почему все так хвалят только тебя, когда практически все сценарии написал я. Так не честно!"
        );

        FinalExam.MailMessage thirdMessage = new FinalExam.MailMessage(
                "Stephen Hawking",
                "Christopher Nolan",
                "Я так и не понял Интерстеллар."
        );

        List<FinalExam.MailMessage> messages = Arrays.asList(
                firstMessage, secondMessage, thirdMessage
        );

        // Создание почтового сервиса.
        FinalExam.MailService<String> mailService = new FinalExam.MailService<>();

        // Обработка списка писем почтовым сервисом
        messages.forEach(mailService);

        // Получение и проверка словаря "почтового ящика",
        //   где по получателю можно получить список сообщений, которые были ему отправлены
        Map<String, List<String>> mailBox = mailService.getMailBox();

        assert mailBox.get("H.P. Lovecraft").equals(
                List.of(
                        "This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!"
                )
        ) : "wrong mailService mailbox content (1)";

        assert mailBox.get("Christopher Nolan").equals(
                Arrays.asList(
                        "Брат, почему все так хвалят только тебя, когда практически все сценарии написал я. Так не честно!",
                        "Я так и не понял Интерстеллар."
                )
        ) : "wrong mailService mailbox content (2)";

        assert mailBox.get(randomTo).equals(Collections.<String>emptyList()) : "wrong mailService mailbox content (3)";
    }

    @Test
    public void test3() {
        // Создание списка из трех зарплат.
        FinalExam.Salary salary1 = new FinalExam.Salary("Facebook", "Mark Zuckerberg", 1);
        FinalExam.Salary salary2 = new FinalExam.Salary("FC Barcelona", "Lionel Messi", Integer.MAX_VALUE);
        FinalExam.Salary salary3 = new FinalExam.Salary(randomFrom, randomTo, randomSalary);

        // Создание почтового сервиса, обрабатывающего зарплаты.
        FinalExam.MailService<Integer> salaryService = new FinalExam.MailService<>();

        // Обработка списка зарплат почтовым сервисом
        Arrays.asList(salary1, salary2, salary3).forEach(salaryService);

        // Получение и проверка словаря "почтового ящика",
        //   где по получателю можно получить список зарплат, которые были ему отправлены.
        Map<String, List<Integer>> salaries = salaryService.getMailBox();
        assert salaries.get(salary1.getTo()).equals(List.of(1)) : "wrong salaries mailbox content (1)";
        assert salaries.get(salary2.getTo()).equals(List.of(Integer.MAX_VALUE)) : "wrong salaries mailbox content (2)";
        assert salaries.get(randomTo).equals(List.of(randomSalary)) : "wrong salaries mailbox content (3)";
    }
}
