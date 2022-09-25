package test;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import study.java_lessons.lesson_3_3.DirectionExt;

public class TestMath {

    @Test
    public void testTurnLeft_UP() {
        DirectionExt dir = DirectionExt.UP;

        Assertions.assertSame(dir.turnLeft(), DirectionExt.LEFT);
        Assertions.assertSame(dir.turnLeft().turnLeft(), DirectionExt.DOWN);
        Assertions.assertSame(dir.turnLeft().turnLeft().turnLeft(), DirectionExt.RIGHT);
        Assertions.assertSame(dir.turnLeft().turnLeft().turnLeft().turnLeft(), DirectionExt.UP);
    }

    @Test
    public void testTurnRight_UP() {
        DirectionExt dir = DirectionExt.UP;

        Assertions.assertSame(dir.turnRight(), DirectionExt.RIGHT);
        Assertions.assertSame(dir.turnRight().turnRight(), DirectionExt.DOWN);
        Assertions.assertSame(dir.turnRight().turnRight().turnRight(), DirectionExt.LEFT);
        Assertions.assertSame(dir.turnRight().turnRight().turnRight().turnRight(), DirectionExt.UP);
    }

    @Test
    public void testMathCos() {
        Assertions.assertSame(DirectionExt.movX(DirectionExt.UP), 0);
        Assertions.assertSame(DirectionExt.movX(DirectionExt.LEFT), -1);
        Assertions.assertSame(DirectionExt.movX(DirectionExt.DOWN), 0);
        Assertions.assertSame(DirectionExt.movX(DirectionExt.RIGHT), 1);
    }

    @Test
    public void testMathSin() {
        Assertions.assertSame(DirectionExt.movY(DirectionExt.UP), 1);
        Assertions.assertSame(DirectionExt.movY(DirectionExt.LEFT), 0);
        Assertions.assertSame(DirectionExt.movY(DirectionExt.DOWN), -1);
        Assertions.assertSame(DirectionExt.movY(DirectionExt.RIGHT), 0);
    }
}
