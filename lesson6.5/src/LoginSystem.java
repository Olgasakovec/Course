import java.sql.SQLOutput;
import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String login = scanner.nextLine();
        System.out.println("Введите логин");

        String password = scanner.nextLine();
        System.out.println("Введите пароль");

        String confirmPassword = scanner.nextLine();
        System.out.println("Введите подтверждение пароля");

        scanner.close();
    }
}

