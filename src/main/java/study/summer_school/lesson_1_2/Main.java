package study.summer_school.lesson_1_2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        step8();
    }

    public static void step7() {
        Scanner reader = new Scanner(System.in);
        double val = reader.nextDouble() / reader.nextDouble();
        System.out.printf("%.2f", val);
    }

    public static void step8() {
        Scanner reader = new Scanner(System.in);
        long val = reader.nextLong() % reader.nextLong();
        System.out.println(val);
    }

    public static void step9() {
        Scanner reader = new Scanner(System.in);
        int val = reader.nextInt() / reader.nextInt();
        System.out.println(val);
    }

    public static void step10() {
        Scanner reader = new Scanner(System.in);
        System.out.println((long) Math.ceil(reader.nextLong() / 3.));
    }
}
