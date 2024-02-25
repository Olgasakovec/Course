import java.sql.SQLOutput;
import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        String login = "admin";
        String password = "password123";
        String confirmpassword = "password123";
        String incorrectLogin = "pass";
        String inCorrectPassword = "admin";

        Scanner scanner = new Scanner(System.in);
        login = scanner.nextLine();
        System.out.println("Введите логин");

        password = scanner.nextLine();
        System.out.println("Введите пароль");

        confirmpassword =scanner.nextLine();
        System.out.println("Введите подтверждение пароля");

        if (login.equals(login) && password.equals(password) && confirmpassword.equals(confirmpassword)) {
            System.out.println("Вход выполнен успешно");
        } else {
            System.out.println("Неверный логин или пароль");
        }
        scanner.close();
    }
}

