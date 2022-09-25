package study.java_lessons.lesson_3_3;

public class Robot {

    protected int x;
    protected int y;
    protected DirectionExt direction = DirectionExt.UP;

    public Direction getDirection() {
        return this.direction.getDirection();
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void turnLeft() {
        this.direction = DirectionExt.turnLeft(this.direction);
    }

    public void turnRight() {
        this.direction = DirectionExt.turnRight(this.direction);
    }

    public void stepForward() {
        this.x += DirectionExt.movX(this.direction);
        this.y += DirectionExt.movY(this.direction);
    }

    @Override
    public String toString() {
        return "Robot{" +
                "x=" + x +
                ", y=" + y +
                ", direction=" + direction +
                '}';
    }
}
