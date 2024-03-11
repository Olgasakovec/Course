public class EmployeeThread implements Runnable {
    String name;

    private static String email = "test@gmail.com";

    EmployeeThread(String name) {
        this.name = name;
    }

    public static void setEmail(String email) {
        EmployeeThread.email = email;
    }

    @Override
    public void run() {
        email = "test@gmail.com" + Thread.currentThread().getId();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Поток " + name + " был прерван");
            return;
        }
        System.out.println("ID потока: " + Thread.currentThread().getId() + ", Имя потока: " + name + ", Email: " + email.get());
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            EmployeeThread employeeThread = new EmployeeThread("Thread with index " + i);
            setEmail("testemail" + i);
        }
    }
}
