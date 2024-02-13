package clothes;

public class Tie extends Clothe implements MenWear {

    public Tie(int sizewear, int costwear, String colorwear) {
        super(sizewear, costwear, colorwear);
    }

    @Override
    public void towearmen() {
        System.out.println("Галстук одет для мужчины");
    }
}

