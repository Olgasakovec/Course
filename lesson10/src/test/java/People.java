/*
        Создать новый класс для потока через реализацию интерфейса Runnable.
        Переопределить метод run.
        В переопределённом методе run должен быть бесконечный цикл в котором надо выводить в консоль имя текущего потока и его id.
        Доработать созданный класс так что бы можно было отключать бесконечный цикл во время исполнения запущенного потока с помощью метода interrupt.
         */
public class People implements Runnable{

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            Thread currentThread = Thread.currentThread();
            System.out.println("Имя потока: " + currentThread.getName() + ", ID потока: " + currentThread.getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Поток был прерван");
                return;
            }
        }
    }

    public static void main(String[] args) {
        People people = new People();
        Thread thread = new Thread(people);
        thread.start();

        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}

