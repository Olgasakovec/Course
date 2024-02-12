import java.util.Scanner;
/*
        Задано перечисление Seasons, которое описывает четыре времени года.
        Реализовать ввод с клавиатуры номера времени года (1..4). На основе номера времени года вычислить продолжительность времени года в днях.
        Считать, что год не високосный.
         */
public class Main {
    public static void main(String[] args) {

        task1();
    }
    public static void task1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter season number (1-4): ");
        int seasonNumber = scanner.nextInt();
        Seasons seasons = Seasons.values()[seasonNumber - 1];
        System.out.println("Season: " + seasons.name());
        System.out.println("Season duration in days: " + seasons.getDays());
    }
}

