public class Tshirt implements Menwear {
    @Override
    public void towearmen(String text) {
        System.out.println("Футболка одета для мужчины");
    }
}
public class Tshirt implements Womenwear{
    @Override
    public void towearwomen(String text) {
        System.out.println("Футболка одета для женщины");
    }
}