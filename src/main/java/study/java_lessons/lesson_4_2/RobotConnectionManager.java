package study.java_lessons.lesson_4_2;

public interface RobotConnectionManager {
    RobotConnection getConnection() throws RobotConnectionException;
}
