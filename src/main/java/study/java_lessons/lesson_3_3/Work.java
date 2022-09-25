package study.java_lessons.lesson_3_3;

public class Work {
    public static void main(String[] args) {
        Robot rob = new Robot();
        System.out.println(rob);

        rob.turnLeft();
        rob.stepForward();
        rob.stepForward();
        rob.turnRight();
        rob.stepForward();

        System.out.println(rob);
    }
}
