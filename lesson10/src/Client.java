import java.util.ArrayList;
import java.util.List;

public class Client implements Runnable {

    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        System.out.println(("Имя потока: " + currentThread.getName()) + ", ID потока: " + currentThread.getId());
        try {
            Thread.sleep(500);
        }catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "has been interrupted");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int numThreads = 5;
        List<Thread> thread = new ArrayList<>();
        for (int i = 0; i < numThreads; i++) {
            thread.add(new Thread(new Client()));
        }

        thread.get(0).start();
        thread.get(numThreads - 2).start();
    }
}
