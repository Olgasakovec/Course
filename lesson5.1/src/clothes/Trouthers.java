package clothes;

public class Trouthers extends Clothe implements Menwear, Womenwear {

    public Trouthers(int sizewear, int costwear, String colorwear) {
        super(sizewear, costwear, colorwear);
    }

    @Override
    public void towearmen() {
        System.out.println("Штаны одеты для мужчины");
    }

    @Override
    public void towearwomen() {
        System.out.println("Штаны одеты для женщины");
    }
}
