package study.java_lessons.lesson_4_2;

public interface RobotConnection extends AutoCloseable {
    void moveRobotTo(int x, int y) throws RobotConnectionException;

    @Override
    void close() throws RobotConnectionException;
}
