package task3;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static String baseUrl = System.getProperty("user.dir");

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();

        userList.add(new User("Петр", "Петров", 41));
        userList.add(new User("Иван", "Иванов", 30));
        userList.add(new User("Екатерина", "Сидорова", 20));

        for (User user : userList) {
            System.out.println("Пользователь: " + user.getFirstName() + " " + user.getLastName() + ", Возраст: " + user.getAge());
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(baseUrl + "user.dat")))
        {
            oos.writeObject(userList);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
