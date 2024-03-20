public class Variant3 {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    public static void task1() {
        /*
        Какой суффикс используется для написания литералов типа long? Вариантов ответа может быть больше 1
        Ответ запишите ниже
         */
        System.out.println("Task 1");
        System.out.println("Answer: L, l");
        System.out.println();
    }

    public static void task2() {
        /*
        В переменных a и b лежат положительные длины катетов прямоугольного треугольника.
        Вычислить и вывести на экран площадь треугольника и его периметр.
         */
        double a = 40, b = 45;
        double c = Math.sqrt((a * a) + (b * b));
        double s = a * b / 2;
        double p = a + b + c;
        System.out.println("Task 2");
        System.out.println("Perimeter: " + (int) p + " (" + p + ")");
        System.out.println("Square: " + (int) s);
        System.out.println();
    }

    public static void task3() {
        /*
        Натуральное положительное число записано в переменную n.
        Создайте программу, которая будет генерировать и выводить на экран целое число из отрезка [-n;n].
         */
        System.out.println("Task 3");
        int n = 6;
        int o = (int) (Math.random() * ((n*2)+1))-n;
            System.out.println(o);
    }
}
