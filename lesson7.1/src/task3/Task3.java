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

        Student student2 = new Student("Вася", "Группа Б", 3, score2);

        List<Integer> score3 = new ArrayList<>();
        score3.add(1);
        score3.add(3);
        score3.add(1);

        Student student3 = new Student("Женя", "Группа С", 3, score3);

        students.add(student1);
        students.add(student2);
        students.add(student3);

        printStudents(students);
        updateStudents(students);
        printStudents(students);
    }

    public static void printStudents(List<Student> students, int course) {
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName() + " обучается " + course + " курсе");
            }
        }
    }

    public static void printStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student.getName() + " обучается " + student.getCourse() + " курсе");
        }
    }

    public static void updateStudents(List<Student> students) {
        List<Student> blackList = new ArrayList<>();
        for (Student student : students) {
            if (student.getAvgScore() < 3) {
                blackList.add(student);
                System.out.println(student.getName() + " отчислен ");
            } else {
                student.nextCourse();
                System.out.println(student.getName() + " переведен на следующий курс " + student.getCourse());
            }
        }
        students.removeAll(blackList);
    }
}
