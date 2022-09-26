package study.java_lessons.lesson_4_2;

public class Work {
    public static int MAX = 10;
    public static int MIN = 1;

    public static int ERR_PROB = 5;
    public static int TOTAL_ERR_PROB = 9;

    public static void main(String[] args) {
        try {
            moveRobot(() -> {
                int rand = random();
                if (rand > TOTAL_ERR_PROB) throw new RuntimeException("Runtime Connection error");
                if (rand > ERR_PROB) throw new RobotConnectionException("Connection error");
                return new RobotConnection() {
                    @Override
                    public void moveRobotTo(int x, int y) {
                        int rand = random();
                        if (rand > TOTAL_ERR_PROB) throw new RuntimeException("Runtime Move error");
                        if (rand > ERR_PROB) throw new RobotConnectionException("Move error");
                    }

                    @Override
                    public void close() {
                        int rand = random();
//                    if (rand > TOTAL_ERR_PROB) throw new RuntimeException("Runtime Close error");
                        if (rand > ERR_PROB) throw new RobotConnectionException("Close error");
                    }
                };
            }, 5, 7);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        boolean flag = false;
        for (int i = 1; i <= 3 && !flag; i++) {
            try (RobotConnection conn = robotConnectionManager.getConnection()) {
                conn.moveRobotTo(toX, toY);
                flag = true;
                System.out.println("All right at " + i + " attempt");
            } catch (RobotConnectionException e) {
//                System.out.println(e.getMessage());
                if (i == 3 && !flag) throw e;
            } catch (Exception e) {
                System.out.println("Crash at " + i + " attempt with " + e.getMessage());
                throw e;
            }
        }
    }

    public static int random() {
        return (int) Math.floor(Math.random() * (MAX - MIN + 1) + MIN);
    }
}
