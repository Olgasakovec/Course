import java.sql.SQLOutput;
import java.util.Random;

public class Variant2 {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    public static void task1() {
        /*
        Объявить переменные с помощью которых можно будет посчитать общую сумму покупки нескольких товар.
        Например плитки шоколада, кофе и пакет молока.
         */
        int choklate = 2;
        int cofe = 1;
        int milk = 1;

        double pricechoklate = 4;
        double pricecofe = 5.5;
        double pricemilk = 1.5;
        double sum = (choklate * pricechoklate) + (cofe * pricecofe) + (milk * pricemilk);
    }

    public static void task2() {
        /*
        Создайте массив из всех нечётных чисел от 1 до 99, выведите его на экран в строку,
        а затем этот же массив выведите на экран тоже в строку, но в обратном порядке (99 97 95 93 … 7 5 3 1).
         */
        int a = 0;
        for (int i = 1; i <= 99; i++) {
            if (i % 2 != 0) a++;
        }
        int[] mas = new int[a];
        for (int i = 1, b = 0; i <= 99; i++) {
            if (i % 2 != 0) {
                mas[b] = i;
                System.out.print(mas[b] + " ");
                b++;
            }
        }
        {
            System.out.println(" ");
            for (int i = mas.length - 1; i >= 0; i--) {
                System.out.print(mas[i] + " ");
            }
        }

    }

    public static void task3() {
        /*
        Создать программу, выводящую на экран случайно сгенерированное трёхзначное натуральное число и его наибольшую цифру.

        В этом примере для генерации псевдослучайного числа используем новый класс Random из библиотеки java.util.
         */

        Random rnd = new Random();
        int a = (int) rnd.nextInt(899) + 100;
        int first = a / 100;
        int secondBegin = a / 10;
        int second = secondBegin % 10;
        int third = a % 10;
        if (first > second && first > third) {
            System.out.println(first);
        } else if (second > first && second > third) {
            System.out.println(second);
        } else {
            System.out.println(third);
        }
        System.out.println(a);
    }
}



