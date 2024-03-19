import java.sql.SQLOutput;
import java.util.Scanner;
public class LoginSystem {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите логин");
        String login = scanner.nextLine();

        System.out.println("Введите пароль");
        String password = scanner.nextLine();

        System.out.println("Введите подтверждение пароля");
        String confirmPassword = scanner.nextLine();

        scanner.close();

        boolean validate = ValidationSystem.validate(login, password, confirmPassword);

        if (validate) {
            System.out.println("Успешно");
        } else {
            System.out.println("Не успешно");
        }
    }
}

