public class Variant3 {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    public static void task1() {
        System.out.println("Task 1");
        System.out.println("Answer: L, l");
        System.out.println();
    }

    public static void task2() {
        double a = 40.0;
        double b = 45.0;
        double c = Math.sqrt(a * a + b * b);
        double s = a * b / 2.0;
        double p = a + b + c;
        System.out.println("Task 2");
        System.out.println("Perimeter: " + (int)p + " (" + p + ")");
        System.out.println("Square: " + (int)s);
        System.out.println();
    }

    public static void task3() {
        System.out.println("Task 3");
        int n = 6;
        int o = (int)(Math.random() * (double)(n * 2 + 1)) - n;
        System.out.println(o);
    }
}