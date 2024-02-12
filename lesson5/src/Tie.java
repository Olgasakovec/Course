public class Tie implements Menwear {
    @Override
    public void towearmen(String text) {
        System.out.println("Галстук одет для мужчины");
    }
}
public class Tie implements Womenwear{
    @Override
    public void towearwomen(String text) {
        System.out.println("Галстук не может быть одет для женщины");
    }
}
