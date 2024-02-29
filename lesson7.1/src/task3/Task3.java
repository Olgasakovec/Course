package task3;
import java.util.ArrayList;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        List<Integer> score = new ArrayList<>();
        score.add(5);
        score.add(4);
        score.add(3);

        Student student1 = new Student("Петя", "Группа А", 2, 3);

        System.out.println("Студент: " + student1.getName());
        System.out.println("Группа: " + student1.getGroup());
        System.out.println("Курс: " + student1.getCourse());
        System.out.println("Оценки: " + student1.getScore());
    }
}

