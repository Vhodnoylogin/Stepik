package study.java_lessons.lesson_4_1;

public class Work {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        m1();
    }

    public static double sqrt(double x) {
        if (x < 0) throw new IllegalArgumentException("Expected non-negative number, got " + x);
        return Math.sqrt(x); // your implementation here
    }

    static void m1() {
        System.out.println(getCallerClassAndMethodName());
        m2();
    }

    static void m2() {
        System.out.println(getCallerClassAndMethodName());
        m3();
    }

    static void m3() {
        System.out.println(getCallerClassAndMethodName());
    }

//    public static String getCallerClassAndMethodName(){
//        StackTraceElement[] stackTraceElements = new Throwable().getStackTrace();
//        if(stackTraceElements.length < 3) return null;
//
//        StackTraceElement element = stackTraceElements[2];
//        return element.getClassName() + "#" + element.getMethodName();
//    }

    public static String getCallerClassAndMethodName() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        if (stackTraceElements.length < 4) return null;

        StackTraceElement element = stackTraceElements[3];
        return element.getClassName() + "#" + element.getMethodName();
    }

}
