public class Skirt implements Menwear {
    @Override
    public void towearmen(String text) {
        System.out.println("Юбка не может быть одета для мужчины");
    }
}
public class Skirt implements Womenwear{
    @Override
    public void towearwomen(String text) {
        System.out.println("Юбка одета для женщины");
    }
}