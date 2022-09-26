package study.java_lessons.lesson_4_2;

public class Work {
    public static void main(String[] args) {
        try {
            moveRobot(() -> {
                int rand = random();
                if (rand > 9) throw new RuntimeException("Runtime Connection error");
                if (rand > 5) throw new RobotConnectionException("Connection error");
                return new RobotConnection() {
                    @Override
                    public void moveRobotTo(int x, int y) {
                        int rand = random();
                        if (rand > 9) throw new RuntimeException("Runtime Move error");
                        if (rand > 5) throw new RobotConnectionException("Move error");
                    }

                    @Override
                    public void close() {
//                    int rand = random();
//                    if (rand > 9) throw new RuntimeException("Runtime Close error");
//                    if (rand > 5) throw new RobotConnectionException("Close error");
                    }
                };
            }, 5, 7);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        for (int i = 1; i <= 3; i++) {
            try (RobotConnection conn = robotConnectionManager.getConnection()) {
                conn.moveRobotTo(toX, toY);
                System.out.println("All right at " + i + " attempt");
                break;
            } catch (RobotConnectionException e) {
//                System.out.println(e.getMessage());
                if (i == 3) throw e;
            } catch (Exception e) {
                System.out.println("Crash at " + i + " attempt with " + e.getMessage());
                throw e;
            }
        }
    }

    public static int random() {
        int MAX = 10;
        int MIN = 1;
        return (int) Math.floor(Math.random() * (MAX - MIN + 1) + MIN);
    }
}
