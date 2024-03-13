public class EmployeeThread extends Thread {
    private String name;

    private static ThreadLocal<String> email = new ThreadLocal<>();

    public EmployeeThread(String name) {
        super(name);
    }

    public static void setEmail(String emailValue) {
        email.set(emailValue);
    }

    @Override
    public void run() {
        email.set(Thread.currentThread().getName());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("current thread with id %s have name %s with value is %s%n", Thread.currentThread().getId(), Thread.currentThread().getName(), email);
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            EmployeeThread employeeThread = new EmployeeThread("Thread with index " + i);
            EmployeeThread.setEmail("testemail" + i);
            employeeThread.start();
        }
    }
}
