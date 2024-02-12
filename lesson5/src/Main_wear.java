public class Main_wear {

    public static void main(String[] args) {

        Trouthers trouthers = new Trouthers();
        trouthers.towearmen("одетьМужчину");
        Tshirt tshirt = new Tshirt();
        tshirt.towearmen("одетьМужчину");
        Skirt skirt = new Skirt();
        skirt.towearmen("одетьМужчину");
        Tie tie = new Tie();
        tie.towearmen("одетьМужчину");
    }
    private Trouthers trouthers;
    private Tshirt tshirt;
    private Skirt skirt;
    private Tie tie;
}
