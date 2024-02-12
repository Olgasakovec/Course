public class Trouthers implements Menwear {
    @Override
    public void towearmen(String text) {
        System.out.println("Штаны одеты для мужчины");
    }
}
public class Trouthers implements Womenwear{
    @Override
    public void towearwomen(String text) {
        System.out.println("Штаны одеты для женщины");
    }
}
