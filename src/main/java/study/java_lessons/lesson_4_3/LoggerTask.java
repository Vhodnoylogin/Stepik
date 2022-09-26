package study.java_lessons.lesson_4_3;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class LoggerTask {
    private static void configureLogging() {
        Logger LOGGER_A = Logger.getLogger("org.stepic.java.logging.ClassA");
        LOGGER_A.setLevel(Level.ALL);

        Logger LOGGER_B = Logger.getLogger("org.stepic.java.logging.ClassB");
        LOGGER_B.setLevel(Level.WARNING);

        Logger LOGGER_C = Logger.getLogger("org.stepic.java");
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        handler.setFormatter(new XMLFormatter());
        LOGGER_C.addHandler(handler);
        LOGGER_C.setUseParentHandlers(false);
    }
}
