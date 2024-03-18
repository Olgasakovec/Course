import java.util.PriorityQueue;
import java.util.Queue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Queue<HeavyBox> boxQueue = new PriorityQueue<>();

        boxQueue.offer(new HeavyBox(5));
        boxQueue.offer(new HeavyBox(15));
        boxQueue.offer(new HeavyBox(10));

        IBox removeBoxOperation = boxes -> {
            double totalWeight = 0;
            while (!boxQueue.isEmpty()) {
                HeavyBox box = boxQueue.poll();
                System.out.println("Weight: " + box.getWeight());
            }
            return totalWeight;
        }
    }
}