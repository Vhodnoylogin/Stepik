package study.java_lessons.lesson_3_5;

import java.util.function.DoubleUnaryOperator;

public class Integrate {
    protected static final double STEP = 1E-7;

    public static void main(String[] args) {
        System.out.println(integrate(x -> 1, 0, 10));//10.0
        System.out.println(integrate(x -> x + 2, 0, 10));//70.0
        System.out.println(integrate(x -> Math.sin(x) / x, 1, 5));//0.603848
    }

    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double iter = a - STEP;
        double summ = 0;
        while (iter <= b) {
            summ += f.applyAsDouble(iter) * STEP;
            iter += STEP;
        }
        return summ;
    }
}
