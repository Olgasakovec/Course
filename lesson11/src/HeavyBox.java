import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class HeavyBox {
    private int weight;

    public HeavyBox(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "HeavyBox{" +
                "weight=" + weight +
                '}';
    }
    public static void main(String[] args) {
        Queue<HeavyBox> boxQueue = new PriorityQueue<>();

        boxQueue.offer(new HeavyBox(5));
        boxQueue.offer(new HeavyBox(15));
        boxQueue.offer(new HeavyBox(10));

        IBox removeBoxOperation = boxes -> {
            int totalWeight = 0;
            while (!boxQueue.isEmpty()) {
                HeavyBox box = boxQueue.poll();
                totalWeight += box.getWeight();
                System.out.println("Weight: " + box.getWeight());
            }
            return totalWeight;
        };
        double totalWeight = removeBoxOperation.removeBox(boxQueue);
        System.out.println("Total weight of removed: " + totalWeight);
    }
}
