package task3;
import java.util.ArrayList;
import java.util.List;
public class Task3 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        List<Integer> score1 = new ArrayList<>();
        score1.add(5);
        score1.add(4);
        score1.add(3);

        Student student1 = new Student("Петя", "Группа А", 1, score1);

        List<Integer> score2 = new ArrayList<>();
        score2.add(9);
        score2.add(8);
        score2.add(7);

        Student student2 = new Student("Вася", "Группа Б", 2, score2);

        List<Integer> score3 = new ArrayList<>();
        score3.add(6);
        score3.add(3);
        score3.add(1);

        Student student3 = new Student("Женя", "Группа С", 3, score3);

        printStudent(students, 3);
        deleteStudents(students);
    }
    public static void deleteStudents(List<Student> students) {
        students.removeIf(student -> student.getAvgScore() < 3);
    }

    public static void printStudent (List<Student> students, int course) {
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName() + "обучается" + course + "курсе");
            }
        }
    }
}

