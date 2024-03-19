import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<String> readOnlyList = Collections.singletonList("букет");
        readOnlyList.add("трава");
        readOnlyList.add("упаковка");
    }
}