import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Variant2 {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();// вариант 2 выполнения задачи 3
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
        System.out.println("Task1");
        System.out.println("result is " + sum);
    }


    public static void task2() {
        /*
        Создайте массив из всех нечётных чисел от 1 до 99, выведите его на экран в строку,
        а затем этот же массив выведите на экран тоже в строку, но в обратном порядке (99 97 95 93 … 7 5 3 1).
         */

        int min = 1,
                max = 99,
                count = -1;
        int [] arr = new int[max%2==0 ? max/2 : max/2+1];
        String strSorted = "",
                strReversed = "";
        while(count < arr.length-1)
        {
            arr[++count] = min;
            strSorted += min +" ";
            strReversed = min +" "+ strReversed;
            min += 2;
        }
        System.out.println("Task2");
        System.out.println(strSorted);
        System.out.println(strReversed);
    }


    static void task3() {
        /*
        Создать программу, выводящую на экран случайно сгенерированное трёхзначное натуральное число и его наибольшую цифру.

        В этом примере для генерации псевдослучайного числа используем новый класс Random из библиотеки java.util.
         */
        Random rand = new Random();
        int a = rand.nextInt(899) + 100;
        int first = a / 100;
        int secondBegin = a / 10;
        int second = secondBegin % 10;
        int third = a % 10;
        System.out.println("Task3");
                if (first > second && first > third) {
            System.out.println (first);
        } else if (second > first && second > third) {
            System.out.println (second);
        } else {
            System.out.println (third);
        }
        System.out.println (a);
    }


    static void task4() { // вариант 2 выполнения задачи 3
        Random rand = new Random();
        int a = (int) rand.nextInt(899)+100;
        int b = a%10;
        int c = (a/10)%10;
        int d = (a/100)%10;
        System.out.println("Task4");
        if(b>=c&b>d||b>=d){
            System.out.println("В числе "+a+" наибольшая цифра" + b);
        }
        else {
            if (c>b&c>=d) {
                System.out.println("В числе " + a + " наибольшая цифра" + c);
            }
            else {
                System.out.println("В числе "+a+" наибольшая цифра" + d);
            }
        }
    }
    }