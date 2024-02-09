public class Flower {

    private String countryOfOrigin;
    private int storageDays;
    private double price;

    static int sellCount = 0;

    public void sell(){
        sellCount++;
    }

    public Flower(String countryOfOrigin, int storageDays, double price) {
        this.countryOfOrigin = countryOfOrigin;
        this.storageDays = storageDays;
        this.price = price;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public int getStorageDays() {
        return storageDays;
    }

    public double getPrice() {
        return price;
    }
}

