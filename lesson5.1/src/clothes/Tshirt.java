package clothes;

public class Tshirt extends Clothe implements Menwear, Womenwear {

    public Tshirt(int sizewear, int costwear, String colorwear) {
        super(sizewear, costwear, colorwear);
    }

    @Override
    public void towearmen() {
        System.out.println("Футболка одета для мужчины");
    }

    @Override
    public void towearwomen() {
        System.out.println("Футболка одета для женщины");
    }
}