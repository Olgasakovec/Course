public class Task extends User {
    @Override
    public void stop() {
        super.stop();
        System.out.println("stop method is override");
    }
    @Override
    public void goTo() {
        super.goTo();
        System.out.println("goTo method is override");
    }
}