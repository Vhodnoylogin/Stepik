package study.java_lessons.lesson_3_3;

public enum DirectionExt {
    UP(90),
    DOWN(270),
    LEFT(180),
    RIGHT(0);

    public static final int ANGLE_90 = 90;
    public static final int ANGLE_360 = 360;
    public final int angle;

    DirectionExt(int angle) {
        this.angle = angle;
    }

    public static DirectionExt getInstance(int angle) {

        for (DirectionExt value : DirectionExt.values()) {
            if (value.angle == angle) return value;
        }
        return DirectionExt.UP;
    }

    public static DirectionExt turnLeft(DirectionExt direction) {
        int newAngle = (DirectionExt.ANGLE_360 + direction.angle + DirectionExt.ANGLE_90) % DirectionExt.ANGLE_360;
        return getInstance(newAngle);
    }

    public static DirectionExt turnRight(DirectionExt direction) {
        int newAngle = (DirectionExt.ANGLE_360 + direction.angle - DirectionExt.ANGLE_90) % DirectionExt.ANGLE_360;
        return getInstance(newAngle);
    }

    public static int movX(DirectionExt direction) {
        return (int) Math.cos(Math.toRadians(direction.angle));
    }

    public static int movY(DirectionExt direction) {
        return (int) Math.sin(Math.toRadians(direction.angle));
    }

    public Direction getDirection() {
        return Direction.valueOf(this.name());
    }

    public DirectionExt turnLeft() {
        return DirectionExt.turnLeft(this);
    }

    public DirectionExt turnRight() {
        return DirectionExt.turnRight(this);
    }

}
