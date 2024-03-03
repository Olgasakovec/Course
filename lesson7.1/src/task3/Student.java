package task3;
import java.util.ArrayList;
import java.util.List;
public class Student {

    private String name;
    private String group;
    private int course;
    private List<Integer> score;

    public Student(String name, String group, int course, List<Integer> score) {
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
}


