package task3;
import java.util.List;
public class Student {

    private String name;
    private String group;
    private int course;
    private List<Integer> score;

    public Student(String name, String group, int course, int score) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getCourse() {
        return course;
    }

    public List<Integer> getScore() {
        return score;
    }

    public int getAvgScore() {
        int sum = 0;
        for (int score : score) {
            sum += score;
        }
        return sum / score.size();
    }

    public static void deleteStudents(List<Student> students) {
        students.removeIf(student -> student.getAvgScore() < 3);
    }

    public void nextCourse() {
        if (getAvgScore() >= 3) {
            course++;
            System.out.println(name + "Переведен на следующий курс" + course);
        } else {
            System.out.println(name + "Не переведен на следующий курс" + course);
        }
    }

    public static void printStudent (List<Student> students, int course) {
        for (Student third : students) {
            if (third.getCourse() == course) {
                System.out.println(third.getName() + "обучается" + course + "курсе");
            }
        }
    }
}


