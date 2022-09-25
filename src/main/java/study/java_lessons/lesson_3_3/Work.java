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

        moveRobot(rob, 1, 1);
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        walkLine(robot, toX);
        walkRow(robot, toY);
    }

    public static void walkLine(Robot rob, int toX) {
        int len = toX - rob.getX();
        while (
                len < 0 && rob.getDirection() != Direction.LEFT
                        || len > 0 && rob.getDirection() != Direction.RIGHT
        ) rob.turnLeft();
        while (len != 0) {
            rob.stepForward();
            len = toX - rob.getX();
        }
    }

    public static void walkRow(Robot rob, int toY) {
        int len = toY - rob.getY();
        while (
                len < 0 && rob.getDirection() != Direction.DOWN
                        || len > 0 && rob.getDirection() != Direction.UP
        ) rob.turnLeft();
        while (len != 0) {
            rob.stepForward();
            len = toY - rob.getY();
        }
    }
}
