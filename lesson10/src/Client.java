public class Client implements Runnable {

    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        System.out.println("Имя потока: " + currentThread.getName()) + ", ID потока: " + currentThread.getId();
        try {
            Thread.sleep(500);
        }catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "has been interrupted");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int numThreads = 5;
        Thread[] thread = new Thread[numThreads];
        for (i = 0; i < 5; i++) {
            thread[i] = new Thread(new Client());
        }
        thread[0].start();
        thread[numThreads -2].start();
    }
}
