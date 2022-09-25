package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import study.java_lessons.lesson_3_3.Robot;

import static study.java_lessons.lesson_3_3.Work.walkLine;
import static study.java_lessons.lesson_3_3.Work.walkRow;

public class TestRobot {
    protected static Robot robot;

    @Test
    public void testWalkLine() {
        int COORD_X;

        robot = new Robot(0, 0);
        COORD_X = 7;
        walkLine(robot, COORD_X);
        Assertions.assertEquals(robot.getX(), COORD_X);

        robot = new Robot(8, 0);
        walkLine(robot, COORD_X);
        Assertions.assertEquals(robot.getX(), COORD_X);

        robot = new Robot(-11, 0);
        walkLine(robot, COORD_X);
        Assertions.assertEquals(robot.getX(), COORD_X);

        robot = new Robot(-19, 0);
        COORD_X = -16;
        walkLine(robot, COORD_X);
        Assertions.assertEquals(robot.getX(), COORD_X);

        robot = new Robot(20, 0);
        COORD_X = -15;
        walkLine(robot, COORD_X);
        Assertions.assertEquals(robot.getX(), COORD_X);

        robot = new Robot(0, 0);
        COORD_X = 0;
        walkLine(robot, COORD_X);
        Assertions.assertEquals(robot.getX(), COORD_X);

        robot = new Robot(2, 0);
        COORD_X = 4;
        walkLine(robot, COORD_X);
        Assertions.assertNotEquals(robot.getX(), COORD_X + 7);
    }

    @Test
    public void testWalkRow() {
        int COORD_Y;

        robot = new Robot(0, 0);
        COORD_Y = 7;
        walkRow(robot, COORD_Y);
        Assertions.assertEquals(robot.getY(), COORD_Y);

        robot = new Robot(8, 0);
        walkRow(robot, COORD_Y);
        Assertions.assertEquals(robot.getY(), COORD_Y);

        robot = new Robot(-11, 0);
        walkRow(robot, COORD_Y);
        Assertions.assertEquals(robot.getY(), COORD_Y);

        robot = new Robot(-19, 0);
        COORD_Y = -16;
        walkRow(robot, COORD_Y);
        Assertions.assertEquals(robot.getY(), COORD_Y);

        robot = new Robot(20, 0);
        COORD_Y = -15;
        walkRow(robot, COORD_Y);
        Assertions.assertEquals(robot.getY(), COORD_Y);

        robot = new Robot(0, 0);
        COORD_Y = 0;
        walkRow(robot, COORD_Y);
        Assertions.assertEquals(robot.getY(), COORD_Y);

        robot = new Robot(2, 0);
        COORD_Y = 4;
        walkRow(robot, COORD_Y);
        Assertions.assertNotEquals(robot.getY(), COORD_Y + 7);
    }

    @Test
    public void testWalk() {
        int COORD_X;
        int COORD_Y;

        robot = new Robot(0, 0);
        COORD_X = 7;
        COORD_Y = 7;
        walkLine(robot, COORD_X);
        walkRow(robot, COORD_Y);
        Assertions.assertEquals(robot.getX(), COORD_X);
        Assertions.assertEquals(robot.getY(), COORD_Y);

        robot = new Robot(6, -4);
        walkLine(robot, COORD_X);
        walkRow(robot, COORD_Y);
        Assertions.assertEquals(robot.getX(), COORD_X);
        Assertions.assertEquals(robot.getY(), COORD_Y);

        robot = new Robot(7, 7);
        walkLine(robot, COORD_X);
        walkRow(robot, COORD_Y);
        Assertions.assertEquals(robot.getX(), COORD_X);
        Assertions.assertEquals(robot.getY(), COORD_Y);
    }
}
